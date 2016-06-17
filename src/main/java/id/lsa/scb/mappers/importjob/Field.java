
package id.lsa.scb.mappers.importjob;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "include",
    "acceptEmpty",
    "origin",
    "valueType",
    "name",
    "pattern",
    "id",
    "version"
})
public class Field {

    @JsonProperty("include")
    private Boolean include;
    @JsonProperty("acceptEmpty")
    private Boolean acceptEmpty;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("valueType")
    private String valueType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pattern")
    private String pattern;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("version")
    private Integer version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The include
     */
    @JsonProperty("include")
    public Boolean getInclude() {
        return include;
    }

    /**
     * 
     * @param include
     *     The include
     */
    @JsonProperty("include")
    public void setInclude(Boolean include) {
        this.include = include;
    }

    /**
     * 
     * @return
     *     The acceptEmpty
     */
    @JsonProperty("acceptEmpty")
    public Boolean getAcceptEmpty() {
        return acceptEmpty;
    }

    /**
     * 
     * @param acceptEmpty
     *     The acceptEmpty
     */
    @JsonProperty("acceptEmpty")
    public void setAcceptEmpty(Boolean acceptEmpty) {
        this.acceptEmpty = acceptEmpty;
    }

    /**
     * 
     * @return
     *     The origin
     */
    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    /**
     * 
     * @param origin
     *     The origin
     */
    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 
     * @return
     *     The valueType
     */
    @JsonProperty("valueType")
    public String getValueType() {
        return valueType;
    }

    /**
     * 
     * @param valueType
     *     The valueType
     */
    @JsonProperty("valueType")
    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

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
     *     The pattern
     */
    @JsonProperty("pattern")
    public String getPattern() {
        return pattern;
    }

    /**
     * 
     * @param pattern
     *     The pattern
     */
    @JsonProperty("pattern")
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The version
     */
    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
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
