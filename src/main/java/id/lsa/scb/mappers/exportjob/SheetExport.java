
package id.lsa.scb.mappers.exportjob;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "sheetId",
    "workbookExport"
})
public class SheetExport {

    @JsonProperty("name")
    private String name;
    @JsonProperty("sheetId")
    private String sheetId;
    @JsonProperty("workbook")
    private WorkbookExport workbookExport;
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
     *     The workbook
     */
    @JsonProperty("workbook")
    public WorkbookExport getWorkbookExport() {
        return workbookExport;
    }

    /**
     * 
     * @param workbook
     *     The workbook
     */
    @JsonProperty("workbook")
    public void setWorkbookExport(WorkbookExport workbookExport) {
        this.workbookExport = workbookExport;
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
