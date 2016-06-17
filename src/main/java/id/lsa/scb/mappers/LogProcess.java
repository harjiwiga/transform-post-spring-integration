package id.lsa.scb.mappers;

import java.sql.Timestamp;

/**
 * Created by harji on 6/2/16.
 */

//(COUNTRY_CODE,DIRECTORY_PATH,FILENAME,TARGET_DATABASE,TARGET_TABLENAME,LOG_TIME,RULE_APPLIED,STATUS,STAGE,MESSAGE)
public class LogProcess {

    private int id;
    private String countryCode;
    private String directoryPath;
    private String fileName;
    private String targetDatabase;
    private String targetTableName;
    private Timestamp logTime;
//    private String logTime;
    private String ruleApplied;
    private String status;
    private String stage;
    private String message;

    public LogProcess(){}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(String targetDatabase) {
        this.targetDatabase = targetDatabase;
    }

    public String getTargetTableName() {
        return targetTableName;
    }

    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }


//    public String getLogTime() {
//        return logTime;
//    }
//
//    public void setLogTime(String logTime) {
//        this.logTime = logTime;
//    }

    public String getRuleApplied() {
        return ruleApplied;
    }

    public void setRuleApplied(String ruleApplied) {
        this.ruleApplied = ruleApplied;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
