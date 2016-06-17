package id.lsa.scb.spring.integration.routers;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by harji on 5/12/16.
 */

@MessageEndpoint
public class ResponseRouter {

    private static Logger logger = Logger.getLogger(ResponseRouter.class);

//    @Router(inputChannel = "responseApiJobs", applySequence = "true")
    public String isReturnSuccess(Message<?> message) {

        MessageHeaders header = message.getHeaders();
        HashMap<String, Object> payload = (HashMap<String, Object>) message.getPayload();
        String response = String.valueOf(header.get("http_statusCode"));
        String returnStr = "";

        if (response.equals("200")) {
            if (payload.get("status").equals("success")) {
                returnStr = "responseApiJobs.success";
                logger.info("success response");
            }
        }
        return returnStr;
    }

    @Router(inputChannel = "checkImportJob.response", applySequence = "true")
    public String startJobStatus(Message<?> message) throws InterruptedException {

        logger.info(" router start job status ");
        MessageHeaders header = message.getHeaders();
        HashMap<String, Object> payload = (HashMap<String, Object>) message.getPayload();
        String response = String.valueOf(header.get("http_statusCode"));
        String returnStr = "";

        logger.info(" header:"+header.entrySet());
        logger.info(" payload:"+payload.entrySet());
        List<String> jobStatFinish = new ArrayList<String>();
        jobStatFinish.add("COMPLETED");
        jobStatFinish.add("ERROR");
        jobStatFinish.add("CANCELED");
        jobStatFinish.add("COMPLETED_WITH_Warnings");

        List<String> onRunning = new ArrayList<String>();
        onRunning.add("QUEUED");
        onRunning.add("RUNNING");

        if (response.equals("200")) {
            String jobStatus = String.valueOf(payload.get("jobStatus")).trim();
            if (onRunning.contains(jobStatus)) {
                Thread.sleep(1500l);
                if(header.get("checkerType").equals("importJobChecker")){
                    returnStr = "StartImportJob.response";
                }else if(header.get("checkerType").equals("workBookChecker")){
                    returnStr = "StartWorkbookJob.response";
                }else if(header.get("checkerType").equals("StartExportJob")){
                    returnStr = "StartWorkbookJob.response";
                }

            }else if(jobStatus.equals("ERROR")){
                returnStr="importJobStatus.response";
            }else if(jobStatus.equals("CANCELED")){
                returnStr="importJobStatus.response";
            }else if(jobStatus.equals("COMPLETED")){
                returnStr="importJobStatus.response";
            }else if(jobStatus.equals("COMPLETED_WITH_Warnings")){
                returnStr="importJobStatus.response";
            }else{
                returnStr="importJobStatus.response";
            }
            logger.info("response:"+jobStatus);
        }
        return returnStr;
    }



//    @Router(inputChannel = "StartImportJob.response", applySequence = "true")
    public String isFromStatusChecker(Message<?> message) {

        logger.info(" isReturnFinish: ");
        MessageHeaders header = message.getHeaders();
        HashMap<String, Object> payload = (HashMap<String, Object>) message.getPayload();
        String response = String.valueOf(header.get("http_statusCode"));
        String returnStr = "";

        logger.info(" header:"+header.entrySet());
        logger.info(" payload:"+payload.entrySet());

        if (response.equals("200")) {
            String jobStatus = String.valueOf(payload.get("jobStatus")).trim();

            if(!jobStatus.isEmpty()&&jobStatus!=null){

            }else{

            }

            logger.info("success response:"+jobStatus);
        }
        return returnStr;
    }
}
