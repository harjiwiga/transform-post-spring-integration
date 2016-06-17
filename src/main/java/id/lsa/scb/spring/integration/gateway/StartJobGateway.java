package id.lsa.scb.spring.integration.gateway;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by harji on 5/11/16.
 */
//@MessagingGateway
public interface StartJobGateway {

    public Object postStartJob(Message<?> payload);

    public Object checkStartJobStatus(Message<?> payload);
}
