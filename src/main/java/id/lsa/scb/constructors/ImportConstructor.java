package id.lsa.scb.constructors;

import com.epam.parso.Column;
import id.lsa.scb.mappers.File;
import id.lsa.scb.mappers.ValueType;
import id.lsa.scb.mappers.importjob.DataStore;
import id.lsa.scb.mappers.importjob.Field;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.mappers.importjob.PropertiesImport;
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
public class ImportConstructor {

    private ImportJob importJob;
    private List<Column> columns;

    @Autowired
    private PropertiesUtil propertyHandler;
    private String sasFileName;
    private String sasFileType;

    /**
     *
     * @param columns
     * @param fileName
     */
    public ImportConstructor(List<Column> columns, String fileName){

        this.columns = columns;
        this.importJob = new ImportJob();

        String[] parts = fileName.split("\\.");
        this.sasFileName = parts[0];
        this.sasFileType = parts[1];
    }

    /**
     *
     */
    public ImportConstructor(){

    }

    /**
     *
     */
    public void constructImport(String dirCode, String timestamp){

        String version = propertyHandler.getProperty("datameer.version");
        String extension = propertyHandler.getProperty("datameer.extension.import");
        String classname = propertyHandler.getProperty("datameer.className.import");
        String filePath = propertyHandler.getProperty("datameer.filePath.import");
        String pullType = propertyHandler.getProperty("datameer.pullType.import");
        String minKeepCount = propertyHandler.getProperty("datameer.minKeepCount.import");
        String propertiesFileType = propertyHandler.getProperty("datameer.propertiesFileType.import");
        String propertiesFile = propertyHandler.getProperty("datameer.propertiesFile.import"); // static value, just for development
        String propertiesFileNameTimeRange_mode = propertyHandler.getProperty("datameer.propertiesFileNameTimeRange_mode.import");
        String propertiesFilterMaxAge = propertyHandler.getProperty("datameer.propertiesFilterMaxAge.import");
        String propertiesFilterMinAge = propertyHandler.getProperty("datameer.propertiesFilterMinAge.import");
        String propertiesIncrementalMode = propertyHandler.getProperty("datameer.propertiesIncrementalMode.import");
        String hadoopProperties = propertyHandler.getProperty("datameer.hadoopProperties.import");
        String datastorePath = propertyHandler.getProperty("datameer.datastorePath.import");
        String errorHandlingMode = propertyHandler.getProperty("datameer.errorHandlingMode.import");
        String maxLogErrors = propertyHandler.getProperty("datameer.maxLogErrors.import");
        String maxPreviewRecords = propertyHandler.getProperty("datameer.maxPreviewRecords.import");
        String notificationAddress = propertyHandler.getProperty("datameer.notificationAddress.import");
        String notificationSuccessAddress = propertyHandler.getProperty("datameer.notificationSuccessAddresses.import");

        importJob.setVersion(version);
        importJob.setClassName(classname);

        //construct key file
        File file = constructFile(filePath, extension, dirCode, timestamp);
        importJob.setFile(file);

        importJob.setPullType(pullType); //"MANUALLY" value just use in import job, all else use "WHEN_NEW_DATA_COMES_IN"
        importJob.setMinKeepCount(Integer.valueOf(minKeepCount));

        //construct key properties
        importJob.setPropertiesImport(constructProperties(propertiesFile+sasFileName+"."+sasFileType, propertiesFileType, propertiesFileNameTimeRange_mode, propertiesFilterMaxAge, propertiesFilterMinAge, propertiesIncrementalMode));

        importJob.setHadoopProperties(hadoopProperties);

        //construct key dataStore
        importJob.setDataStore(constructDataStore(datastorePath));

        importJob.setErrorHandlingMode(errorHandlingMode);
        importJob.setMaxLogErrors(Integer.valueOf(maxLogErrors));
        importJob.setMaxPreviewRecords(Integer.valueOf(maxPreviewRecords));
        importJob.setNotificationAddresses(notificationAddress);
        importJob.setNotificationSuccessAddresses(notificationSuccessAddress);

        //construct key fields
        List<Field> fields = new ArrayList<Field>();
        int id =0;
        for(Column col  : columns){

            Field field = constructField(col);
            fields.add(field);
            id++;
        }
        fields.addAll(addFieldsProperties(id));
        importJob.setFields(fields);

    }

    /**
     *
     *
     * @param propertiesFile: contains path of source data
     */
    public void constructImport(String propertiesFile, String dirCode, String timestamp){

        String version = propertyHandler.getProperty("datameer.version");
        String extension = propertyHandler.getProperty("datameer.extension.import");
        String classname = propertyHandler.getProperty("datameer.className.import");
        String filePath = propertyHandler.getProperty("datameer.filePath.import");
        String pullType = propertyHandler.getProperty("datameer.pullType.import");
        String minKeepCount = propertyHandler.getProperty("datameer.minKeepCount.import");
        String propertiesFileType = propertyHandler.getProperty("datameer.propertiesFileType.import");
        String propertiesFileNameTimeRange_mode = propertyHandler.getProperty("datameer.propertiesFileNameTimeRange_mode.import");
        String propertiesFilterMaxAge = propertyHandler.getProperty("datameer.propertiesFilterMaxAge.import");
        String propertiesFilterMinAge = propertyHandler.getProperty("datameer.propertiesFilterMinAge.import");
        String propertiesIncrementalMode = propertyHandler.getProperty("datameer.propertiesIncrementalMode.import");
        String hadoopProperties = propertyHandler.getProperty("datameer.hadoopProperties.import");
        String datastorePath = propertyHandler.getProperty("datameer.datastorePath.import");
        String errorHandlingMode = propertyHandler.getProperty("datameer.errorHandlingMode.import");
        String maxLogErrors = propertyHandler.getProperty("datameer.maxLogErrors.import");
        String maxPreviewRecords = propertyHandler.getProperty("datameer.maxPreviewRecords.import");
        String notificationAddress = propertyHandler.getProperty("datameer.notificationAddress.import");
        String notificationSuccessAddress = propertyHandler.getProperty("datameer.notificationSuccessAddresses.import");

        importJob.setVersion(version);
        importJob.setClassName(classname);

        //construct key file
        File file = constructFile(filePath, extension, dirCode, timestamp);
        importJob.setFile(file);

        importJob.setPullType(pullType); //"MANUALLY" value just use in import job, all else use "WHEN_NEW_DATA_COMES_IN"
        importJob.setMinKeepCount(Integer.valueOf(minKeepCount));

        //construct key properties
        importJob.setPropertiesImport(constructProperties(propertiesFile, propertiesFileType, propertiesFileNameTimeRange_mode, propertiesFilterMaxAge, propertiesFilterMinAge, propertiesIncrementalMode));

        importJob.setHadoopProperties(hadoopProperties);

        //construct key dataStore
        importJob.setDataStore(constructDataStore(datastorePath));

        importJob.setErrorHandlingMode(errorHandlingMode);
        importJob.setMaxLogErrors(Integer.valueOf(maxLogErrors));
        importJob.setMaxPreviewRecords(Integer.valueOf(maxPreviewRecords));
        importJob.setNotificationAddresses(notificationAddress);
        importJob.setNotificationSuccessAddresses(notificationSuccessAddress);

        //construct key fields
        List<Field> fields = new ArrayList<Field>();
        int id =0;
        for(Column col  : columns){

            Field field = constructField(col);
            fields.add(field);
            id++;
        }
        fields.addAll(addFieldsProperties(id));
        importJob.setFields(fields);

    }


    /**
     *
     * @param filePath
     * @return
     */
    private File constructFile(String filePath, String extension, String dirCode, String timestamp){

        File outputFile = new File();
        //TODO harji : the name will pass as parameter
        String uuid = AppUtil.generateUUID();
        String dtPath = filePath;
        String desc = "Import Job For "+sasFileName+"."+sasFileType;
        String imJobName = FileUtil.importJobNaming(sasFileName, dirCode, timestamp);

        outputFile.setUuid(uuid);
        //TODO harji: job naming?
        outputFile.setPath(dtPath+imJobName+"."+extension);
        outputFile.setDescription(desc);
        outputFile.setName(imJobName);

        return outputFile;
    }

    /**
     *
     * @param propertiesFile
     * @param propertiesFileType
     * @return
     */
    private PropertiesImport constructProperties(String propertiesFile, String propertiesFileType, String propertiesFileNameTimeRange_mode, String propertiesFilterMaxAge, String propertiesFilterMinAge, String propertiesIncrementalMode){
        PropertiesImport prop = new PropertiesImport();

        List<String> genericConfigurationImplTempFileStore = new ArrayList<String>();
        String genUUid = AppUtil.generateUUID();
        genericConfigurationImplTempFileStore.add(genUUid);
        prop.setGenericConfigurationImplTempFileStore(genericConfigurationImplTempFileStore);

        List<String> fileType = new ArrayList<String>();
        fileType.add(propertiesFileType);
        prop.setFileType(fileType);

        String sasFilePath = propertiesFile;
        List<String> file = new ArrayList<String>();
//        file.add(sasFilePath+sasFileName+"."+sasFileType); // development only
        file.add(sasFilePath); // real environment
        prop.setFile(file);

        List<String> fileNameTimeRangeMode = new ArrayList<String>();
        fileNameTimeRangeMode.add(propertiesFileNameTimeRange_mode);
        prop.setFileNameTimeRangeMode(fileNameTimeRangeMode);

        List<String> filterMaxAge = new ArrayList<String>();
        filterMaxAge.add(propertiesFilterMaxAge);
        prop.setFilterMaxAge(filterMaxAge);

        List<String> filterMinAge = new ArrayList<String>();
        filterMinAge.add(propertiesFilterMinAge);
        prop.setFilterMinAge(filterMinAge);

        List<String> incrementalMode = new ArrayList<String>();
        incrementalMode.add(propertiesIncrementalMode);
        prop.setIncrementalMode(incrementalMode);

        return prop;
    }

    /**
     *
     * @param dataStorePath
     * @return
     */
    private DataStore constructDataStore(String dataStorePath){

        DataStore outputDataStore = new DataStore();
        outputDataStore.setPath(dataStorePath);
        outputDataStore.setUuid(AppUtil.generateUUID());

        return outputDataStore;
    }

    /**
     *
     * @param col
     * @return
     */
    //just construct per value of fields key from column name value of sas7bdat file
    private Field constructField(Column col){

        //TODO implement filter or condition when null
        Field outputField = new Field();
        Integer origin = col.getId()-1;
        ValueType valueType = new ValueType("string");

        outputField.setInclude(true);
        outputField.setAcceptEmpty(true);
        outputField.setOrigin(String.valueOf(origin));
        outputField.setValueType(valueType.getJson());

        if(!(col.getName() == null)&&(!col.getName().isEmpty())) {
            outputField.setName(col.getName());
        }

        outputField.setPattern("");
        outputField.setId(col.getId());
        outputField.setVersion(3);

        return outputField;
    }

    /**
     *
     * @param id
     * @return
     */
    private List<Field> addFieldsProperties(int id){

        List<Field> fields =  new ArrayList<Field>();
        //filePath
        Field fileName = new Field();
        fileName.setInclude(false);
        fileName.setAcceptEmpty(false);
        fileName.setName("dasFileName");
        ValueType typeFileName= new ValueType("string");
        fileName.setValueType(typeFileName.getJson());
        fileName.setOrigin("fileInfo.fileName");
        fileName.setVersion(3);
        fileName.setId(id+2);

        fields.add(fileName);

        //filePath
        Field filePath = new Field();
        filePath.setInclude(false);
        filePath.setAcceptEmpty(false);
        filePath.setName("dasFilePath");
        ValueType typeFilePath= new ValueType("string");
        filePath.setValueType(typeFilePath.getJson());
        filePath.setOrigin("fileInfo.filePath");
        filePath.setVersion(3);
        filePath.setId(id+3);

        fields.add(filePath);

        //last modified
        Field lastModifyed = new Field();
        lastModifyed.setInclude(false);
        lastModifyed.setAcceptEmpty(false);
        lastModifyed.setName("dasLastModified");
        ValueType dateModified= new ValueType("date");
        lastModifyed.setValueType(dateModified.getJson());
        lastModifyed.setOrigin("fileInfo.lastModified");
        lastModifyed.setVersion(3);
        lastModifyed.setId(id+3);

        fields.add(lastModifyed);

        //id
        Field idField = new Field();
        idField.setInclude(false);
        idField.setAcceptEmpty(false);
        idField.setName("dasJobExecutionId");
        ValueType intID= new ValueType("integer");
        idField.setValueType(intID.getJson());
        idField.setOrigin("jobexecutionInfo.id");
        idField.setVersion(3);
        idField.setId(id+4);

        fields.add(idField);

        //jobStartTimeField
        Field jobStartTime = new Field();
        jobStartTime.setInclude(false);
        jobStartTime.setAcceptEmpty(false);
        jobStartTime.setName("dasJobExecutionStartTime");
        ValueType valueDate = new ValueType("date");
        jobStartTime.setValueType(valueDate.getJson());
        jobStartTime.setOrigin("jobexecutionInfo.starttime");
        jobStartTime.setVersion(3);
        jobStartTime.setId(id+5);

        fields.add(jobStartTime);

        return fields;

    }

    /**
     *
     * @return
     */
    public ImportJob getImportJob(){
        return importJob;
    }

    /**
     *
     * @return
     */
    public String getSasFileName(){
        return sasFileName;
    }

    /**
     *
     * @return
     */
    public String getSasFileType(){
        return sasFileType;
    }

}
