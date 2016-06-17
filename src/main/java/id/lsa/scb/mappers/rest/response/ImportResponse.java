
package id.lsa.scb.mappers.rest.response;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "configuration-id",
    "status"
})
public class ImportResponse {

    @JsonProperty("configuration-id")
    private int configurationId;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ImportResponse(){

    }

    /**
     * 
     * @return
     *     The configurationId
     */
    @JsonProperty("configuration-id")
    public int getConfigurationId() {
        return configurationId;
    }

    /**
     * 
     * @param configurationId
     *     The configuration-id
     */
    @JsonProperty("configuration-id")
    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
