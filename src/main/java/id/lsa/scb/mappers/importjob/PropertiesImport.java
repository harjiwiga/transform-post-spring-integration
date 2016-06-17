
package id.lsa.scb.mappers.importjob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "GenericConfigurationImpl.temp-file-store",
    "fileType",
    "file",
    "fileNameTimeRange_mode",
    "filter.maxAge",
    "filter.minAge",
    "incrementalMode"
})
public class PropertiesImport {

    @JsonProperty("GenericConfigurationImpl.temp-file-store")
    private List<String> GenericConfigurationImplTempFileStore = new ArrayList<String>();
    @JsonProperty("fileType")
    private List<String> fileType = new ArrayList<String>();
    @JsonProperty("file")
    private List<String> file = new ArrayList<String>();
    @JsonProperty("fileNameTimeRange_mode")
    private List<String> fileNameTimeRangeMode = new ArrayList<String>();
    @JsonProperty("filter.maxAge")
    private List<String> filterMaxAge = new ArrayList<String>();
    @JsonProperty("filter.minAge")
    private List<String> filterMinAge = new ArrayList<String>();
    @JsonProperty("incrementalMode")
    private List<String> incrementalMode = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The GenericConfigurationImplTempFileStore
     */
    @JsonProperty("GenericConfigurationImpl.temp-file-store")
    public List<String> getGenericConfigurationImplTempFileStore() {
        return GenericConfigurationImplTempFileStore;
    }

    /**
     * 
     * @param GenericConfigurationImplTempFileStore
     *     The GenericConfigurationImpl.temp-file-store
     */
    @JsonProperty("GenericConfigurationImpl.temp-file-store")
    public void setGenericConfigurationImplTempFileStore(List<String> GenericConfigurationImplTempFileStore) {
        this.GenericConfigurationImplTempFileStore = GenericConfigurationImplTempFileStore;
    }

    /**
     * 
     * @return
     *     The fileType
     */
    @JsonProperty("fileType")
    public List<String> getFileType() {
        return fileType;
    }

    /**
     * 
     * @param fileType
     *     The fileType
     */
    @JsonProperty("fileType")
    public void setFileType(List<String> fileType) {
        this.fileType = fileType;
    }

    /**
     * 
     * @return
     *     The file
     */
    @JsonProperty("file")
    public List<String> getFile() {
        return file;
    }

    /**
     * 
     * @param file
     *     The file
     */
    @JsonProperty("file")
    public void setFile(List<String> file) {
        this.file = file;
    }

    /**
     * 
     * @return
     *     The fileNameTimeRangeMode
     */
    @JsonProperty("fileNameTimeRange_mode")
    public List<String> getFileNameTimeRangeMode() {
        return fileNameTimeRangeMode;
    }

    /**
     * 
     * @param fileNameTimeRangeMode
     *     The fileNameTimeRange_mode
     */
    @JsonProperty("fileNameTimeRange_mode")
    public void setFileNameTimeRangeMode(List<String> fileNameTimeRangeMode) {
        this.fileNameTimeRangeMode = fileNameTimeRangeMode;
    }

    /**
     * 
     * @return
     *     The filterMaxAge
     */
    @JsonProperty("filter.maxAge")
    public List<String> getFilterMaxAge() {
        return filterMaxAge;
    }

    /**
     * 
     * @param filterMaxAge
     *     The filter.maxAge
     */
    @JsonProperty("filter.maxAge")
    public void setFilterMaxAge(List<String> filterMaxAge) {
        this.filterMaxAge = filterMaxAge;
    }

    /**
     * 
     * @return
     *     The filterMinAge
     */
    @JsonProperty("filter.minAge")
    public List<String> getFilterMinAge() {
        return filterMinAge;
    }

    /**
     * 
     * @param filterMinAge
     *     The filter.minAge
     */
    @JsonProperty("filter.minAge")
    public void setFilterMinAge(List<String> filterMinAge) {
        this.filterMinAge = filterMinAge;
    }

    /**
     * 
     * @return
     *     The incrementalMode
     */
    @JsonProperty("incrementalMode")
    public List<String> getIncrementalMode() {
        return incrementalMode;
    }

    /**
     * 
     * @param incrementalMode
     *     The incrementalMode
     */
    @JsonProperty("incrementalMode")
    public void setIncrementalMode(List<String> incrementalMode) {
        this.incrementalMode = incrementalMode;
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
