package id.lsa.scb.constructors;

import com.epam.parso.Column;
import id.lsa.scb.mappers.File;
import id.lsa.scb.mappers.exportjob.*;
import id.lsa.scb.mappers.workbook.WorkBook;
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
public class ExportConstructor {

    private ExportJob exportJob;

    @Autowired
    private PropertiesUtil propertyHandler;
    private List<Column> columns;
    private String sasFileName;
    private String sasFileType;
    private WorkBook workBook;

    /**
     *
     * @param columns
     * @param fileName
     */
    public ExportConstructor(List<Column> columns, String fileName, WorkBook workBook) {

        this.exportJob = new ExportJob();
        this.columns = columns;
        this.workBook = workBook;

        String[] parts = fileName.split("\\.");
        this.sasFileName = parts[0];
        this.sasFileType = parts[1];
    }

    /**
     *
     */
    public ExportConstructor(){

    }

    /**
     *
     * @param sheetName -> import.file.name
     * @param sheetSheetId -> workbook.sheets.sheetId
     * @param sheetWorkbookPath -> workbook.file.path
     * @param sheetUuid -> workbook.file.uuid
     */
    public void constructExportJob(String sheetName, String sheetSheetId, String sheetWorkbookPath, String sheetUuid, String dbTarget, String tableName, String dirCode, String timestamp) {

        String version = propertyHandler.getProperty("datameer.version");
        String extension = propertyHandler.getProperty("datameer.extension.export");
        String className = propertyHandler.getProperty("datameer.classname.export");
        String filePath = propertyHandler.getProperty("datameer.filePath.export");
        String pullType = propertyHandler.getProperty("datameer.pullType.export");
        String minKeepCount = propertyHandler.getProperty("datameer.minKeepCount.export");
        String propertiesDatabaseName = dbTarget;
        String propertiesTableName = tableName;
        String propertiesOverwrite = propertyHandler.getProperty("datameer.propertiesOverwrite.export");
        String hadoopProperties = propertyHandler.getProperty("datameer.hadoopProperties.export");
        String connection = propertyHandler.getProperty("datameer.connection.export");
        String errorHandlingMode = propertyHandler.getProperty("datameer.errorHandlingMode.export");
        String notificationAddress = propertyHandler.getProperty("datameer.notificationAddress.export");
        String notificationSuccessAddress = propertyHandler.getProperty("datameer.notificationSuccessAddresses.export");

        exportJob.setVersion(version);
        exportJob.setClassName(className);
        exportJob.setFile(constructFile(filePath, extension, dirCode, timestamp));
        exportJob.setPullType(pullType); //prefer with "WHEN_NEW_DATA_COMES_IN" value, so  it'll automatically started if importJob was finished
        exportJob.setMinKeepCount(Integer.valueOf(minKeepCount));
        exportJob.setPropertiesExport(constructPropertiesExport(propertiesDatabaseName, propertiesTableName, propertiesOverwrite));
        exportJob.setHadoopProperties(hadoopProperties);
        exportJob.setConnection(connection);
        exportJob.setSheetExport(constructSheetExport(sheetName, sheetWorkbookPath, sheetSheetId, sheetUuid));
        exportJob.setMappings(constructMap());
        exportJob.setErrorHandlingMode(errorHandlingMode);
        exportJob.setNotificationAddresses(notificationAddress);
        exportJob.setNotificationSuccessAddresses(notificationSuccessAddress);

    }

    /**
     * using workbook object
     */
    public void constructExportJob(String dbTarget, String tableName, String dirCode, String timestamp) {

        String version = propertyHandler.getProperty("datameer.version");
        String extension = propertyHandler.getProperty("datameer.extension.export");
        String className = propertyHandler.getProperty("datameer.classname.export");
        String filePath = propertyHandler.getProperty("datameer.filePath.export");
        String pullType = propertyHandler.getProperty("datameer.pullType.export");
        String minKeepCount = propertyHandler.getProperty("datameer.minKeepCount.export");
        String propertiesDatabaseName = dbTarget;
        String propertiesTableName = tableName;
        String propertiesOverwrite = propertyHandler.getProperty("datameer.propertiesOverwrite.export");
        String hadoopProperties = propertyHandler.getProperty("datameer.hadoopProperties.export");
        String connection = propertyHandler.getProperty("datameer.connection.export");
        String errorHandlingMode = propertyHandler.getProperty("datameer.errorHandlingMode.export");
        String notificationAddress = propertyHandler.getProperty("datameer.notificationAddress.export");
        String notificationSuccessAddress = propertyHandler.getProperty("datameer.notificationSuccessAddresses.export");

        exportJob.setVersion(version);
        exportJob.setClassName(className);
        exportJob.setFile(constructFile(filePath, extension, dirCode, timestamp));
        exportJob.setPullType(pullType); //prefer use "WHEN_NEW_DATA_COMES_IN" value, so  it'll automatically started if importJob was finished
        exportJob.setMinKeepCount(Integer.valueOf(minKeepCount));
        exportJob.setPropertiesExport(constructPropertiesExport(propertiesDatabaseName, propertiesTableName, propertiesOverwrite));
        exportJob.setHadoopProperties(hadoopProperties);
        exportJob.setConnection(connection);
        exportJob.setSheetExport(constructSheetExport(workBook.getSheetWorkBooks().get(0).getName(), workBook.getFile().getPath(), workBook.getSheetWorkBooks().get(0).getSheetId(), workBook.getFile().getUuid()));
        exportJob.setMappings(constructMap());
        exportJob.setErrorHandlingMode(errorHandlingMode);
        exportJob.setNotificationAddresses(notificationAddress);
        exportJob.setNotificationSuccessAddresses(notificationSuccessAddress);

    }

    /**
     *
     * @param filePath
     * @return
     */
    private File constructFile(String filePath, String extension, String dirCode, String timestamp){

        File outputFile = new File();
        String uuid = AppUtil.generateUUID();
        String dtPath = filePath;
        String desc = "Import Job For "+sasFileName+"."+sasFileType;
        String imJobName = FileUtil.exportJobNaming(sasFileName, dirCode, timestamp);

        outputFile.setUuid(uuid);
        outputFile.setPath(dtPath+imJobName+"."+extension);
        outputFile.setDescription(desc);
        outputFile.setName(imJobName);

        return outputFile;
    }

    /**
     *
     * @return
     */
    private PropertiesExport constructPropertiesExport(String propertiesDatabaseName, String propertiesTableName, String propertiesOverwrite){

        PropertiesExport propertiesExport = new PropertiesExport();
        List<String> databaseName = new ArrayList<String>();
        List<String> tableName = new ArrayList<String>();
        List<String> overwrite = new ArrayList<String>();
        databaseName.add(propertiesDatabaseName);
        tableName.add(propertiesTableName);
        overwrite.add(propertiesOverwrite);

        propertiesExport.setDatabaseName(databaseName);
        propertiesExport.setTableName(tableName);
        propertiesExport.setOverwrite(overwrite);

        return propertiesExport;
    }

    /**
     *
     * @param sheetName
     * @param sheetWorkbookPath
     * @param sheetSheetId
     * @param sheetUuid
     * @return
     */
    private SheetExport constructSheetExport(String sheetName, String sheetWorkbookPath, String sheetSheetId, String sheetUuid){

        SheetExport sheetExport = new SheetExport();

        sheetExport.setName(sheetName);
        sheetExport.setSheetId(sheetSheetId);

        WorkbookExport workbookExport = new WorkbookExport();
        workbookExport.setPath(sheetWorkbookPath);
        workbookExport.setUuid(sheetUuid);

        sheetExport.setWorkbookExport(workbookExport);

        return sheetExport;
    }

    /**
     *
     * @return
     */
    private List<Mapping> constructMap() {

        List<Mapping> mappings = new ArrayList<Mapping>();

        for (Column col : columns) {
            Mapping map = new Mapping();
            if (!col.getName().isEmpty()) {
                map.setName(col.getName());
            }
            map.setSrcColumnIndex(col.getId()-1);
            map.setNullable(true);
            mappings.add(map);
        }

        return mappings;
    }

    /**
     *
     * @return
     */
    public ExportJob getExportJob(){
        return exportJob;
    }

}