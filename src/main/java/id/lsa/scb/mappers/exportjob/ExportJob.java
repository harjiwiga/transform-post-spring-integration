
package id.lsa.scb.mappers.exportjob;

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
    "propertiesExport",
    "hadoopProperties",
    "connection",
    "sheetExport",
    "mappings",
    "errorHandlingMode",
    "notificationAddresses",
    "notificationSuccessAddresses"
})
public class ExportJob extends DatameerJob{

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
    private PropertiesExport propertiesExport;
    @JsonProperty("hadoopProperties")
    private String hadoopProperties;
    @JsonProperty("connection")
    private String connection;
    @JsonProperty("sheet")
    private SheetExport sheetExport;
    @JsonProperty("mappings")
    private List<Mapping> mappings = new ArrayList<Mapping>();
    @JsonProperty("errorHandlingMode")
    private String errorHandlingMode;
    @JsonProperty("notificationAddresses")
    private String notificationAddresses;
    @JsonProperty("notificationSuccessAddresses")
    private String notificationSuccessAddresses;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ExportJob(){

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
     *     The propertiesExport
     */
    @JsonProperty("properties")
    public PropertiesExport getPropertiesExport() {
        return propertiesExport;
    }

    /**
     * 
     * @param propertiesExport
     *     The propertiesExport
     */
    @JsonProperty("properties")
    public void setPropertiesExport(PropertiesExport propertiesExport) {
        this.propertiesExport = propertiesExport;
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
     *     The connection
     */
    @JsonProperty("connection")
    public String getConnection() {
        return connection;
    }

    /**
     * 
     * @param connection
     *     The connection
     */
    @JsonProperty("connection")
    public void setConnection(String connection) {
        this.connection = connection;
    }

    /**
     * 
     * @return
     *     The sheetExport
     */
    @JsonProperty("sheet")
    public SheetExport getSheetExport() {
        return sheetExport;
    }

    /**
     * 
     * @param sheetExport
     *     The sheetExport
     */
    @JsonProperty("sheet")
    public void setSheetExport(SheetExport sheetExport) {
        this.sheetExport = sheetExport;
    }

    /**
     * 
     * @return
     *     The mappings
     */
    @JsonProperty("mappings")
    public List<Mapping> getMappings() {
        return mappings;
    }

    /**
     * 
     * @param mappings
     *     The mappings
     */
    @JsonProperty("mappings")
    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
