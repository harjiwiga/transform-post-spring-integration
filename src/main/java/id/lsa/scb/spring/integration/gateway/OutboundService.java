package id.lsa.scb.spring.integration.gateway;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by harjiwigaasmoko on 5/31/16.
 */

@MessageEndpoint
public class OutboundService {

    private Logger logger = Logger.getLogger(OutboundService.class);

    @Resource(name = "startImportJobGateway")
    public StartJobGateway startJobGateway;
//
////    @ServiceActivator(inputChannel = "ExportJob.reply" ,autoStartup = "true",sendTimeout = "10000",outputChannel = "successChannel.output")
//    public HashMap<String,String> startGateway(Message<?>message){
//
//        HashMap<String,String> responseStartJobs = new HashMap<>();
//
//        MessageHeaders headers = message.getHeaders();
//        Message<?>messageImportJob = MessageBuilder.createMessage(headers.get("importJobResponse"),headers) ;
//        Message<?>messageWorkbook = MessageBuilder.createMessage(headers.get("workBookResponse"),headers);
//        Message<?>messageExport = MessageBuilder.createMessage(headers.get("workBookResponse"),headers) ;
//
//        String importStartResponse = startJobGateway.postStartJob(messageImportJob);
//        String workbookStartResponse = startJobGateway.postStartJob(messageWorkbook);
//        String exportStartResponse = startJobGateway.postStartJob(messageExport);
//
//        responseStartJobs.put("importStartResponse",importStartResponse);
//        responseStartJobs.put("workbookStartResponse",workbookStartResponse);
//        responseStartJobs.put("exportStartResponse",exportStartResponse);
//
//        return responseStartJobs;
//    }

//    @Splitter(inputChannel = "ExportJob.reply", autoStartup = "true", sendTimeout = "10000", outputChannel = "successChannel.output")
    public List<HashMap<String, Object>> splitStartJob(Message<?> message) {
        List<HashMap<String, Object>> replys = new ArrayList<>();
        MessageHeaders headers = message.getHeaders();

        Message<?> messageImportJob = MessageBuilder.createMessage(headers.get("importJobResponse"), headers);
        Message<?> messageWorkbook = MessageBuilder.createMessage(headers.get("workBookResponse"), headers);
        Message<?> messageExport = MessageBuilder.createMessage(headers.get("exportJobResponse"), headers);

        HashMap<String, Object> startJobResponse = (HashMap<String, Object>) startJobGateway.postStartJob(messageImportJob);
        HashMap<String, Object> workBookResponse = (HashMap<String, Object>) startJobGateway.postStartJob(messageWorkbook);
        HashMap<String, Object> exportJobResponse = (HashMap<String, Object>) startJobGateway.postStartJob(messageExport);

        replys.add(startJobResponse);
        replys.add(workBookResponse);
        replys.add(exportJobResponse);

        return replys;
    }


}
