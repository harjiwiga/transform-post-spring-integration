package id.lsa.scb.mappers;

import id.lsa.scb.mappers.exportjob.ExportJob;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.mappers.workbook.WorkBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harji on 4/21/16.
 */
public class JobMessage {

    private String fileName;
    private ImportJob importJob;
    private WorkBook workBook;
    private ExportJob exportJob;

    private String tableName;
    private String countryCode;
    private String directoryPath;
    private String directoryCode;
    private String filePatternUsed;
    private String targetDatabase;
    private String loadType;
    private String ruleApplied;

    private List<DatameerJob> jobs = new ArrayList<DatameerJob>();

    public JobMessage() {
    }

    public JobMessage(ImportJob importJob, WorkBook workBook, ExportJob exportJob) {
        this.importJob = importJob;
        this.exportJob = exportJob;
        this.workBook = workBook;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ImportJob getImportJob() {
        return importJob;
    }

    public void setImportJob(ImportJob importJob) {
        this.importJob = importJob;
        this.jobs.add(0, importJob);
    }

    public WorkBook getWorkBook() {
        return workBook;
    }

    public void setWorkBook(WorkBook workBook) {
        this.workBook = workBook;
        this.jobs.add(1, workBook);
    }

    public ExportJob getExportJob() {
        return exportJob;
    }

    public void setExportJob(ExportJob exportJob) {
        this.exportJob = exportJob;
        this.jobs.add(2, exportJob);
    }

    public List<DatameerJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<DatameerJob> jobs) {
        this.jobs = jobs;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

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

    public String getDirectoryCode() {
        return directoryCode;
    }

    public void setDirectoryCode(String directoryCode) {
        this.directoryCode = directoryCode;
    }

    public String getFilePatternUsed() {
        return filePatternUsed;
    }

    public void setFilePatternUsed(String filePatternUsed) {
        this.filePatternUsed = filePatternUsed;
    }

    public String getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(String targetDatabase) {
        this.targetDatabase = targetDatabase;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getRuleApplied() {
        return ruleApplied;
    }

    public void setRuleApplied(String ruleApplied) {
        this.ruleApplied = ruleApplied;
    }

}
