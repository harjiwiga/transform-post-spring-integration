package id.lsa.scb.constructors;

import id.lsa.scb.mappers.File;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.mappers.workbook.*;
import id.lsa.scb.utils.AppUtil;
import id.lsa.scb.utils.FileUtil;
import id.lsa.scb.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harjiwigaasmoko on 4/9/16.
 */
@Component
public class WorkBookConstructor {

    private ImportJob importJob;
    private WorkBook workBook;

    @Autowired
    private PropertiesUtil propertyHandler;
    private String sasFileName;
    private String sasFileType;

    public WorkBookConstructor(){
    }

    /**
     *
     * @param importJob
     * @param fileName
     */
    public WorkBookConstructor(ImportJob importJob, String fileName){
        this.workBook = new WorkBook();
        this.importJob = importJob;

        String[] parts = fileName.split("\\.");
        this.sasFileName = parts[0];
        this.sasFileType = parts[1];
    }

    /**
     *
     */
    public void constructWorkbook(String dirCode, String timestamp){
        String version = propertyHandler.getProperty("datameer.version");
        String extension = propertyHandler.getProperty("datameer.extension.workbook");
        String className = propertyHandler.getProperty("datameer.classname.workbook");
        String filePath = propertyHandler.getProperty("datameer.filePath.workbook");
        String pullType = propertyHandler.getProperty("datameer.pullType.workbook");
        String minKeepCount = propertyHandler.getProperty("datameer.minKeepCount.workbook");
        String hadoopProperties = propertyHandler.getProperty("datameer.hadoopProperties.workbook");
        String notificationAddress = propertyHandler.getProperty("datameer.notificationAddress.workbook");
        String notificationSuccessAddresses = propertyHandler.getProperty("datameer.notificationSuccessAddresses.workbook");
        String sheetsSheetType = propertyHandler.getProperty("datameer.sheetsSheetType.workbook");
        String sheetsKeep = propertyHandler.getProperty("datameer.sheetsKeep.workbook");
        String sheetsRunTriggeringConfiguration = propertyHandler.getProperty("datameer.sheetsRunTriggeringConfiguration.workbook");
        String advancedSchedulingInUse = propertyHandler.getProperty("datameer.advancedSchedulingInUse.workbook");
        String errorHandlingMode = propertyHandler.getProperty("datameer.errorHandlingMode.workbook");

        workBook.setVersion(version);
        workBook.setClassName(className);
        workBook.setFile(constructFile(filePath, sasFileName, sasFileType, extension, dirCode, timestamp));
        workBook.setPullType(pullType); //prefer with "WHEN_NEW_DATA_COMES_IN" value, so  it'll automatically started if importJob was finished
        workBook.setMinKeepCount(Integer.valueOf(minKeepCount));
        workBook.setPropertiesWorkBook(new PropertiesWorkBook());
        workBook.setHadoopProperties(hadoopProperties);
        workBook.setNotificationAddresses(notificationAddress);
        workBook.setNotificationSuccessAddresses(notificationSuccessAddresses);
        workBook.setSheetWorkBooks(constructSheet(sheetsSheetType, sheetsKeep, sheetsRunTriggeringConfiguration));
        workBook.setAdvancedSchedulingInUse(Boolean.valueOf(advancedSchedulingInUse));
        workBook.setErrorHandlingMode(errorHandlingMode);
    }

    /**
     *
     * @param filePath
     * @param sasFileName
     * @param sasFileType
     * @return
     */
    private File constructFile(String filePath, String sasFileName, String sasFileType, String extension, String dirCode, String timestamp){

        File outputFile = new File();

        //TODO harji : the name will pass as parameter
        String uuid = AppUtil.generateUUID();
        String dtPath = filePath;
        String desc = "Import Job For "+sasFileName+"."+sasFileType;
        String wbName = FileUtil.workBookNaming(sasFileName, dirCode, timestamp);

        outputFile.setUuid(uuid);
        //TODO ask about job name
        outputFile.setPath(dtPath+wbName+"."+extension);
        outputFile.setDescription(desc);
        outputFile.setName(wbName);

        return outputFile;
    }

    /**
     *
     * @param sheetsSheetType
     * @return
     */
    private List<SheetWorkBook> constructSheet(String sheetsSheetType, String sheetsKeep, String sheetsRunTriggeringConfiguration){

        List<SheetWorkBook> sheetWorkBooks = new ArrayList<SheetWorkBook>();
        SheetWorkBook sheetWorkBook = new SheetWorkBook();

        sheetWorkBook.setName(importJob.getFile().getName());
        sheetWorkBook.setSheetId(AppUtil.generateUUID());
        sheetWorkBook.setSheetType(sheetsSheetType);
        sheetWorkBook.setKeep(Boolean.valueOf(sheetsKeep));

        RunTriggeringConfiguration runTriggeringConfiguration = new RunTriggeringConfiguration();
        runTriggeringConfiguration.setRunTrigger(Boolean.valueOf(sheetsRunTriggeringConfiguration));
        sheetWorkBook.setRunTriggeringConfiguration(runTriggeringConfiguration);

        Datasource datasource = new Datasource();
        datasource.setPath(importJob.getFile().getPath());
        datasource.setUuid(importJob.getFile().getUuid());
        sheetWorkBook.setDatasource(datasource);

        List<Object> columnStyles = new ArrayList<Object>();
        sheetWorkBook.setColumnStyles(columnStyles);

        sheetWorkBooks.add(sheetWorkBook);

        return sheetWorkBooks;
    }

    /**
     *
     * @return
     */
    public WorkBook getWorkBook(){
        return workBook;
    }

}