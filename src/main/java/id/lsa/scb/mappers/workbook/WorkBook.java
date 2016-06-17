
package id.lsa.scb.mappers.workbook;

import com.fasterxml.jackson.annotation.*;
import id.lsa.scb.mappers.DatameerJob;
import id.lsa.scb.mappers.File;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "version",
    "className",
    "file",
    "pullType",
    "minKeepCount",
    "propertiesWorkBook",
    "hadoopProperties",
    "notificationAddresses",
    "notificationSuccessAddresses",
    "sheetWorkBooks",
    "advancedSchedulingInUse",
    "errorHandlingMode"
})
public class WorkBook extends DatameerJob{

    @JsonProperty("version")
    private String version;
    @JsonProperty("className")
    private String className;
    @JsonProperty("file")
    private File file;
    @JsonProperty("pullType")
    private String pullType;
    @JsonProperty("minKeepCount")
    private Integer minKeepCount;
    @JsonProperty("properties")
    private PropertiesWorkBook propertiesWorkBook;
    @JsonProperty("hadoopProperties")
    private String hadoopProperties;
    @JsonProperty("notificationAddresses")
    private String notificationAddresses;
    @JsonProperty("notificationSuccessAddresses")
    private String notificationSuccessAddresses;
    @JsonProperty("sheets")
    private List<SheetWorkBook> sheetWorkBooks = new ArrayList<SheetWorkBook>();
    @JsonProperty("advancedSchedulingInUse")
    private Boolean advancedSchedulingInUse;
    @JsonProperty("errorHandlingMode")
    private String errorHandlingMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public WorkBook(){}

    /**
     * 
     * @return
     *     The version
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The className
     */
    @JsonProperty("className")
    public String getClassName() {
        return className;
    }

    /**
     * 
     * @param className
     *     The className
     */
    @JsonProperty("className")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 
     * @return
     *     The file
     */
    @JsonProperty("file")
    public File getFile() {
        return file;
    }

    /**
     * 
     * @param file
     *     The file
     */
    @JsonProperty("file")
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 
     * @return
     *     The pullType
     */
    @JsonProperty("pullType")
    public String getPullType() {
        return pullType;
    }

    /**
     * 
     * @param pullType
     *     The pullType
     */
    @JsonProperty("pullType")
    public void setPullType(String pullType) {
        this.pullType = pullType;
    }

    /**
     * 
     * @return
     *     The minKeepCount
     */
    @JsonProperty("minKeepCount")
    public Integer getMinKeepCount() {
        return minKeepCount;
    }

    /**
     * 
     * @param minKeepCount
     *     The minKeepCount
     */
    @JsonProperty("minKeepCount")
    public void setMinKeepCount(Integer minKeepCount) {
        this.minKeepCount = minKeepCount;
    }

    /**
     * 
     * @return
     *     The propertiesWorkBook
     */
    @JsonProperty("properties")
    public PropertiesWorkBook getPropertiesWorkBook() {
        return propertiesWorkBook;
    }

    /**
     * 
     * @param propertiesWorkBook
     *     The propertiesWorkBook
     */
    @JsonProperty("properties")
    public void setPropertiesWorkBook(PropertiesWorkBook propertiesWorkBook) {
        this.propertiesWorkBook = propertiesWorkBook;
    }

    /**
     * 
     * @return
     *     The hadoopProperties
     */
    @JsonProperty("hadoopProperties")
    public String getHadoopProperties() {
        return hadoopProperties;
    }

    /**
     * 
     * @param hadoopProperties
     *     The hadoopProperties
     */
    @JsonProperty("hadoopProperties")
    public void setHadoopProperties(String hadoopProperties) {
        this.hadoopProperties = hadoopProperties;
    }

    /**
     * 
     * @return
     *     The notificationAddresses
     */
    @JsonProperty("notificationAddresses")
    public String getNotificationAddresses() {
        return notificationAddresses;
    }

    /**
     * 
     * @param notificationAddresses
     *     The notificationAddresses
     */
    @JsonProperty("notificationAddresses")
    public void setNotificationAddresses(String notificationAddresses) {
        this.notificationAddresses = notificationAddresses;
    }

    /**
     * 
     * @return
     *     The notificationSuccessAddresses
     */
    @JsonProperty("notificationSuccessAddresses")
    public String getNotificationSuccessAddresses() {
        return notificationSuccessAddresses;
    }

    /**
     * 
     * @param notificationSuccessAddresses
     *     The notificationSuccessAddresses
     */
    @JsonProperty("notificationSuccessAddresses")
    public void setNotificationSuccessAddresses(String notificationSuccessAddresses) {
        this.notificationSuccessAddresses = notificationSuccessAddresses;
    }

    /**
     * 
     * @return
     *     The sheetWorkBooks
     */
    @JsonProperty("sheets")
    public List<SheetWorkBook> getSheetWorkBooks() {
        return sheetWorkBooks;
    }

    /**
     * 
     * @param sheetWorkBooks
     *     The sheetWorkBooks
     */
    @JsonProperty("sheets")
    public void setSheetWorkBooks(List<SheetWorkBook> sheetWorkBooks) {
        this.sheetWorkBooks = sheetWorkBooks;
    }

    /**
     * 
     * @return
     *     The advancedSchedulingInUse
     */
    @JsonProperty("advancedSchedulingInUse")
    public Boolean getAdvancedSchedulingInUse() {
        return advancedSchedulingInUse;
    }

    /**
     * 
     * @param advancedSchedulingInUse
     *     The advancedSchedulingInUse
     */
    @JsonProperty("advancedSchedulingInUse")
    public void setAdvancedSchedulingInUse(Boolean advancedSchedulingInUse) {
        this.advancedSchedulingInUse = advancedSchedulingInUse;
    }

    /**
     * 
     * @return
     *     The errorHandlingMode
     */
    @JsonProperty("errorHandlingMode")
    public String getErrorHandlingMode() {
        return errorHandlingMode;
    }

    /**
     * 
     * @param errorHandlingMode
     *     The errorHandlingMode
     */
    @JsonProperty("errorHandlingMode")
    public void setErrorHandlingMode(String errorHandlingMode) {
        this.errorHandlingMode = errorHandlingMode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
