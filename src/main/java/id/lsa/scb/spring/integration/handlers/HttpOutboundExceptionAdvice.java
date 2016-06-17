package id.lsa.scb.spring.integration.handlers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by harji on 5/31/16.
 */
public class HttpOutboundExceptionAdvice extends AbstractRequestHandlerAdvice {

    private final static Logger logger = Logger.getLogger(HttpOutboundExceptionAdvice.class);

    @Override
    protected Object doInvoke(ExecutionCallback callback, Object target, Message<?> message) throws Exception {
        try {
            logger.info("message_advice:"+message.getHeaders());

            return callback.execute();
        }
        catch (MessageHandlingException e) {
            if (e.getCause() instanceof HttpClientErrorException) {
                if (((HttpClientErrorException) e.getCause()).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                    return MessageBuilder.withPayload("Got a 500").copyHeaders(message.getHeaders()).build();
                }
            }
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
    }

}
