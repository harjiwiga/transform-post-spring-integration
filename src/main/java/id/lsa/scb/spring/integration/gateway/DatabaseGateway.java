package id.lsa.scb.spring.integration.gateway;

import id.lsa.scb.mappers.LogProcess;

/**
 * Created by harji on 6/2/16.
 */
public interface DatabaseGateway {
    //    public String insertProccessLog(Message<?>message);
    public String insertProccessLog(LogProcess logProcess);
}
