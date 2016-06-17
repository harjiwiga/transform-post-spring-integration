
package id.lsa.scb.mappers.importjob;

import com.fasterxml.jackson.annotation.*;
import id.lsa.scb.mappers.DatameerJob;
import id.lsa.scb.mappers.File;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement
@JsonPropertyOrder({
    "version",
    "className",
    "file",
    "pullType",
    "minKeepCount",
    "propertiesImport",
    "hadoopProperties",
    "dataStore",
    "errorHandlingMode",
    "maxLogErrors",
    "maxPreviewRecords",
    "notificationAddresses",
    "notificationSuccessAddresses",
    "fields"
})
public class ImportJob extends DatameerJob{

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
    private PropertiesImport propertiesImport;
    @JsonProperty("hadoopProperties")
    private String hadoopProperties;
    @JsonProperty("dataStore")
    private DataStore dataStore;
    @JsonProperty("errorHandlingMode")
    private String errorHandlingMode;
    @JsonProperty("maxLogErrors")
    private Integer maxLogErrors;
    @JsonProperty("maxPreviewRecords")
    private Integer maxPreviewRecords;
    @JsonProperty("notificationAddresses")
    private String notificationAddresses;
    @JsonProperty("notificationSuccessAddresses")
    private String notificationSuccessAddresses;
    @JsonProperty("fields")
    private List<Field> fields = new ArrayList<Field>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ImportJob(){

    }
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
     *     The propertiesImport
     */
    @JsonProperty("properties")
    public PropertiesImport getPropertiesImport() {
        return propertiesImport;
    }

    /**
     * 
     * @param propertiesImport
     *     The propertiesImport
     */
    @JsonProperty("properties")
    public void setPropertiesImport(PropertiesImport propertiesImport) {
        this.propertiesImport = propertiesImport;
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
     *     The dataStore
     */
    @JsonProperty("dataStore")
    public DataStore getDataStore() {
        return dataStore;
    }

    /**
     * 
     * @param dataStore
     *     The dataStore
     */
    @JsonProperty("dataStore")
    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
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

    /**
     * 
     * @return
     *     The maxLogErrors
     */
    @JsonProperty("maxLogErrors")
    public Integer getMaxLogErrors() {
        return maxLogErrors;
    }

    /**
     * 
     * @param maxLogErrors
     *     The maxLogErrors
     */
    @JsonProperty("maxLogErrors")
    public void setMaxLogErrors(Integer maxLogErrors) {
        this.maxLogErrors = maxLogErrors;
    }

    /**
     * 
     * @return
     *     The maxPreviewRecords
     */
    @JsonProperty("maxPreviewRecords")
    public Integer getMaxPreviewRecords() {
        return maxPreviewRecords;
    }

    /**
     * 
     * @param maxPreviewRecords
     *     The maxPreviewRecords
     */
    @JsonProperty("maxPreviewRecords")
    public void setMaxPreviewRecords(Integer maxPreviewRecords) {
        this.maxPreviewRecords = maxPreviewRecords;
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
     *     The fields
     */
    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    /**
     * 
     * @param fields
     *     The fields
     */
    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
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
