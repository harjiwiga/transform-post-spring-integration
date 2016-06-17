
package id.lsa.scb.mappers.exportjob;

import java.util.HashMap;
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
    "srcColumnIndex",
    "nullable"
})
public class Mapping {

    @JsonProperty("name")
    private String name;
    @JsonProperty("srcColumnIndex")
    private Integer srcColumnIndex;
    @JsonProperty("nullable")
    private Boolean nullable;
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
     *     The srcColumnIndex
     */
    @JsonProperty("srcColumnIndex")
    public Integer getSrcColumnIndex() {
        return srcColumnIndex;
    }

    /**
     * 
     * @param srcColumnIndex
     *     The srcColumnIndex
     */
    @JsonProperty("srcColumnIndex")
    public void setSrcColumnIndex(Integer srcColumnIndex) {
        this.srcColumnIndex = srcColumnIndex;
    }

    /**
     * 
     * @return
     *     The nullable
     */
    @JsonProperty("nullable")
    public Boolean getNullable() {
        return nullable;
    }

    /**
     * 
     * @param nullable
     *     The nullable
     */
    @JsonProperty("nullable")
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
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
