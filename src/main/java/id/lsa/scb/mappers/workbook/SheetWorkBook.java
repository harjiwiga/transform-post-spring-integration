
package id.lsa.scb.mappers.workbook;

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
    "name",
    "sheetId",
    "sheetType",
    "keep",
    "runTriggeringConfiguration",
    "datasource",
    "columnStyles"
})
public class SheetWorkBook {

    @JsonProperty("name")
    private String name;
    @JsonProperty("sheetId")
    private String sheetId;
    @JsonProperty("sheetType")
    private String sheetType;
    @JsonProperty("keep")
    private Boolean keep;
    @JsonProperty("runTriggeringConfiguration")
    private RunTriggeringConfiguration runTriggeringConfiguration;
    @JsonProperty("datasource")
    private Datasource datasource;
    @JsonProperty("columnStyles")
    private List<Object> columnStyles = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The sheetId
     */
    @JsonProperty("sheetId")
    public String getSheetId() {
        return sheetId;
    }

    /**
     * 
     * @param sheetId
     *     The sheetId
     */
    @JsonProperty("sheetId")
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    /**
     * 
     * @return
     *     The sheetType
     */
    @JsonProperty("sheetType")
    public String getSheetType() {
        return sheetType;
    }

    /**
     * 
     * @param sheetType
     *     The sheetType
     */
    @JsonProperty("sheetType")
    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }

    /**
     * 
     * @return
     *     The keep
     */
    @JsonProperty("keep")
    public Boolean getKeep() {
        return keep;
    }

    /**
     * 
     * @param keep
     *     The keep
     */
    @JsonProperty("keep")
    public void setKeep(Boolean keep) {
        this.keep = keep;
    }

    /**
     * 
     * @return
     *     The runTriggeringConfiguration
     */
    @JsonProperty("runTriggeringConfiguration")
    public RunTriggeringConfiguration getRunTriggeringConfiguration() {
        return runTriggeringConfiguration;
    }

    /**
     * 
     * @param runTriggeringConfiguration
     *     The runTriggeringConfiguration
     */
    @JsonProperty("runTriggeringConfiguration")
    public void setRunTriggeringConfiguration(RunTriggeringConfiguration runTriggeringConfiguration) {
        this.runTriggeringConfiguration = runTriggeringConfiguration;
    }

    /**
     * 
     * @return
     *     The datasource
     */
    @JsonProperty("datasource")
    public Datasource getDatasource() {
        return datasource;
    }

    /**
     * 
     * @param datasource
     *     The datasource
     */
    @JsonProperty("datasource")
    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    /**
     * 
     * @return
     *     The columnStyles
     */
    @JsonProperty("columnStyles")
    public List<Object> getColumnStyles() {
        return columnStyles;
    }

    /**
     * 
     * @param columnStyles
     *     The columnStyles
     */
    @JsonProperty("columnStyles")
    public void setColumnStyles(List<Object> columnStyles) {
        this.columnStyles = columnStyles;
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
