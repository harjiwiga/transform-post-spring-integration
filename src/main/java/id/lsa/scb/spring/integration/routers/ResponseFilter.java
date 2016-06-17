package id.lsa.scb.spring.integration.routers;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by harji on 5/12/16.
 */
@MessageEndpoint
public class ResponseFilter {

    private static Logger logger = Logger.getLogger(ResponseFilter.class);

    public boolean isImportResponse(Message<?> message) {
        MessageHeaders header = message.getHeaders();

        boolean result = true;

        HashMap<String, Object> payload = (message.getPayload() instanceof HashMap) ? (HashMap<String, Object>) message.getPayload() : new HashMap<String, Object>();
        logger.info("header: " + header.entrySet());
        logger.info("payload: " + message.getPayload());

        String responseCode = String.valueOf(header.get("http_statusCode"));
        header.get("http_statusCode");
        logger.info("responseCode:" + responseCode);

        if (responseCode.contains("200")) {
            logger.info(" TRUE ");

            if (!payload.isEmpty()) {
                String messageStatus = String.valueOf(payload.get("status"));
                if (messageStatus.equals("success")) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            logger.info(" FALSE ");
            result = false;
        }

        return result;
    }

    public boolean workBookResponseFilter(Message<?> message) {
        MessageHeaders header = message.getHeaders();
        logger.info("workbook header : " + header.entrySet());
        logger.info("workbook payload: " + message.getPayload());
        boolean result = true;

        HashMap<String, Object> payload = (message.getPayload() instanceof HashMap) ? (HashMap<String, Object>) message.getPayload() : new HashMap<String, Object>();

        String responseCode = String.valueOf(header.get("http_statusCode"));
        header.get("http_statusCode");
        logger.info("responseCode:" + responseCode);

        if (responseCode.contains("200")) {
            logger.info(" TRUE ");

            if (!payload.isEmpty()) {
                String messageStatus = String.valueOf(payload.get("status"));
                if (messageStatus.equals("success")) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            logger.info(" FALSE ");
            result = false;
        }
        return result;
    }

    public boolean exportJobFilter(Message<?> message) {
        MessageHeaders header = message.getHeaders();
        logger.info("exportJob header : " + header.entrySet());
        logger.info("exportJob payload: " + message.getPayload());
        boolean result = true;

        HashMap<String, Object> payload = (message.getPayload() instanceof HashMap) ? (HashMap<String, Object>) message.getPayload() : new HashMap<String, Object>();
        String responseCode = String.valueOf(header.get("http_statusCode"));
        header.get("http_statusCode");
        logger.info("responseCode:" + responseCode);

        if (responseCode.contains("200")) {
            logger.info(" TRUE ");

            if (!payload.isEmpty()) {
                String messageStatus = String.valueOf(payload.get("status"));
                if (messageStatus.equals("success")) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            logger.info(" FALSE ");
            result = false;
        }
        return result;
    }

//    {job-execution-user=admin, job-execution-trigger=RESTAPI, job-execution-id=272, status=success}

    public boolean startJobFilter(Message<?> message) {
        MessageHeaders header = message.getHeaders();
        logger.info("startImportJobFilter header : " + header.entrySet());
        logger.info("startImportJobFilter payload: " + message.getPayload());
        boolean result = true;

        HashMap<String, Object> payload = (message.getPayload() instanceof HashMap) ? (HashMap<String, Object>) message.getPayload() : new HashMap<String, Object>();
        String responseCode = String.valueOf(header.get("http_statusCode"));
        header.get("http_statusCode");
        logger.info("responseCode:" + responseCode);

        List<String> jobStatus = new ArrayList<String>();
        jobStatus.add("COMPLETED");
        jobStatus.add("ERROR");
        jobStatus.add("CANCELED");
        jobStatus.add("COMPLETED_WITH_Warnings");
        jobStatus.add("QUEUED");
        jobStatus.add("RUNNING");


        if (responseCode.contains("200")) {
            logger.info(" TRUE ");
            String messageStatus = "";
            if (!payload.isEmpty()) {

                messageStatus = String.valueOf(payload.get("status")==null?payload.get("jobStatus"):payload.get("status"));

                logger.info("payload:" + payload);
                logger.info("messageStatus:" + messageStatus);
                if (messageStatus.equals("success")) {
                    result = true;
                } else if (jobStatus.contains(messageStatus)) {
                    result = true;
                } else if(messageStatus==null||messageStatus.isEmpty()){
                    result = false;
                }
            } else {
                result = false;
            }
        } else {
            logger.info(" FALSE ");
            result = false;
        }
        return result;
    }
}
