package id.lsa.scb.spring.integration.handlers;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

/**
 * Created by harji on 5/25/16.
 */
@MessageEndpoint
public class LastMessageProcessor {

    private static Logger logger = Logger.getLogger(LastMessageProcessor.class);
    private long lastProcessedTime = System.currentTimeMillis();



    @ServiceActivator(inputChannel = "importJobStatus.response", autoStartup = "true", sendTimeout = "10000")
    public void processContent(Message<?>message){
        logger.info("Processed content: "+message.getPayload());
        long lastSuccessTime = System.currentTimeMillis();
        this.lastProcessedTime = lastSuccessTime;
    }

    @ServiceActivator(inputChannel = "errorChannel.output", autoStartup = "true", sendTimeout = "10000")
    public void processError(Message<?>message){
        logger.info("Processed Error: "+message.getPayload());
        long lastErrorTime = System.currentTimeMillis();
        this.lastProcessedTime = lastErrorTime;
    }

    public long msSinceLastProcessed(){
        return System.currentTimeMillis() - this.lastProcessedTime;
    }
}
