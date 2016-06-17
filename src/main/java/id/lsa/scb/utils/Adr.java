package id.lsa.scb.utils;

import java.util.HashMap;

/**
 * Created by DS on 6/1/2016.
 */
public class Adr {

    private String directoryPath;
    private String countryCode;
    private String directoryCode;
    private String filePattern;
    private String targetDatabase;
    private boolean isActive;
    private String sequence;
    private String rule;
    private String loadType;
    private String targetTablename;

    private HashMap<String, String> params = new HashMap<String, String>();

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDirectoryCode() {
        return directoryCode;
    }

    public void setDirectoryCode(String directoryCode) {
        this.directoryCode = directoryCode;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    public String getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(String targetDatabase) {
        this.targetDatabase = targetDatabase;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getRule() { return rule; }

    public void setRule(String rule) { this.rule = rule; }

    public void addParam() {
        params.put(this.directoryPath, this.rule);
    }

    public void clearParam() {
        params.clear();
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public String getLoadType() { return loadType; }

    public void setLoadType(String loadType) { this.loadType = loadType; }

    public String getTargetTablename() {
        return targetTablename;
    }

    public void setTargetTablename(String targetTablename) {
        this.targetTablename = targetTablename;
    }
}
