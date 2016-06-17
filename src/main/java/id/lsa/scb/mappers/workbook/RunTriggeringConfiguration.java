
package id.lsa.scb.mappers.workbook;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "runTrigger"
})
public class RunTriggeringConfiguration {

    @JsonProperty("runTrigger")
    private Boolean runTrigger;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The runTrigger
     */
    @JsonProperty("runTrigger")
    public Boolean getRunTrigger() {
        return runTrigger;
    }

    /**
     * 
     * @param runTrigger
     *     The runTrigger
     */
    @JsonProperty("runTrigger")
    public void setRunTrigger(Boolean runTrigger) {
        this.runTrigger = runTrigger;
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
