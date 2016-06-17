package id.lsa.scb.mappers;

/**
 * Created by harjiwigaasmoko on 4/24/16.
 */
public class ResponseJob {

    private String configurationId;
    private String status;

    public ResponseJob(){

    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
