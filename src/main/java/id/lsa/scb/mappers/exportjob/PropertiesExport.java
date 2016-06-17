
package id.lsa.scb.mappers.exportjob;

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
    "databaseName",
    "tableName",
    "overwrite"
})
public class PropertiesExport {

    @JsonProperty("databaseName")
    private List<String> databaseName = new ArrayList<String>();
    @JsonProperty("tableName")
    private List<String> tableName = new ArrayList<String>();
    @JsonProperty("overwrite")
    private List<String> overwrite = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The databaseName
     */
    @JsonProperty("databaseName")
    public List<String> getDatabaseName() {
        return databaseName;
    }

    /**
     * 
     * @param databaseName
     *     The databaseName
     */
    @JsonProperty("databaseName")
    public void setDatabaseName(List<String> databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * 
     * @return
     *     The tableName
     */
    @JsonProperty("tableName")
    public List<String> getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName
     *     The tableName
     */
    @JsonProperty("tableName")
    public void setTableName(List<String> tableName) {
        this.tableName = tableName;
    }

    /**
     * 
     * @return
     *     The overwrite
     */
    @JsonProperty("overwrite")
    public List<String> getOverwrite() {
        return overwrite;
    }

    /**
     * 
     * @param overwrite
     *     The overwrite
     */
    @JsonProperty("overwrite")
    public void setOverwrite(List<String> overwrite) {
        this.overwrite = overwrite;
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
