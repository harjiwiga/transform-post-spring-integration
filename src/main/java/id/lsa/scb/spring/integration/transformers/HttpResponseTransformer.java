package id.lsa.scb.spring.integration.transformers;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

/**
 * Created by harji on 5/12/16.
 */

@MessageEndpoint
public class HttpResponseTransformer {

    private Logger logger = Logger.getLogger(HttpResponseTransformer.class);


//    @Autowired
//    public StartJobGateway datameerGateway;

    public Message<?> transform(Message<?> message) {

        logger.info("message" + message.getPayload());
//        datameerGateway.postStartJob(message);



        return message;
    }
}
