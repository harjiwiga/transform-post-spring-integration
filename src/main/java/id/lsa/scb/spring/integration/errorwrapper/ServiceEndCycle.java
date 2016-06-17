package id.lsa.scb.spring.integration.errorwrapper;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.NullChannel;

/**
 * Created by harji on 5/25/16.
 */

@MessageEndpoint
public class ServiceEndCycle {

    private static Logger logger = Logger.getLogger(ServiceEndCycle.class);

    @ServiceActivator(inputChannel = "nullChannel", autoStartup = "true", sendTimeout = "10000")
    public void endCycle(NullChannel nullChannel) {
        logger.info("nullChannel"+nullChannel.getTimeSinceLastSend());

    }
}
