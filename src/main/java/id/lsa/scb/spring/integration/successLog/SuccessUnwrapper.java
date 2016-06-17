package id.lsa.scb.spring.integration.successLog;

import id.lsa.scb.mappers.LogProcess;
import id.lsa.scb.spring.integration.gateway.DatabaseGateway;
import id.lsa.scb.utils.Adr;
import id.lsa.scb.utils.AdrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Created by arifpz on 30/05/16.
 */
@MessageEndpoint
public class SuccessUnwrapper {

    private static Logger logger = Logger.getLogger(SuccessUnwrapper.class);

    @Resource(name = "pojoUtil")
    private AdrUtil adrUtil;

    @Autowired
    private DatabaseGateway databaseGateway;

    @Autowired
    private LogProcess logProcess;

    @ServiceActivator(inputChannel = "importJobStatus.response", autoStartup = "true", sendTimeout = "10000", outputChannel = "successChannel.output")
    public String procesSuccess(Message<?> message) {


        String result;
        String fileName = "";
        String successMessage = message.getHeaders().toString();
        String countryCode = "";
        String sourceDirectory = "";
        String targetDatabase = "";
        String targetTableName = "";
        Long processingDatetime;
        String status = "Success";
        String stage = "Uploaded to Hive";
        MessageHeaders messageHeaders = message.getHeaders();
        Adr adr = (Adr) messageHeaders.get("fileMatchConf");
        String payload = String.valueOf(message.getPayload());
        HashMap<String, Object> payloadMap = (HashMap<String, Object>) message.getPayload();

        if (messageHeaders != null) {
            fileName = String.valueOf(messageHeaders.get("fileName"));
            targetTableName = String.valueOf(messageHeaders.get("tableName"));
            countryCode = adr.getCountryCode();
            sourceDirectory = adr.getDirectoryPath();
            targetDatabase = adr.getTargetDatabase();
        }

        processingDatetime = messageHeaders.getTimestamp();


        if (payloadMap.get("jobStatus").equals("ERROR") || payloadMap.get("jobStatus").equals("CANCELED")) {
            stage = "Start import job";
            status = "failed";
        }

        Timestamp timestamp = new Timestamp(processingDatetime);

        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (processingDatetime*1000));

//        result = timestamp + ";" + countryCode + ";" + sourceDirectory + ";" + fileName + ";" + targetDatabase + ";" + targetTableName + ";" + status + ";" + stage + ";" + successMessage + ";" + payload;
        result = date + ";" + countryCode + ";" + sourceDirectory + ";" + fileName + ";" + targetDatabase + ";" + targetTableName + ";" + status + ";" + stage + ";" + successMessage + ";" + payload;


        logProcess.setCountryCode(countryCode);
        logProcess.setDirectoryPath(sourceDirectory);
        logProcess.setFileName(fileName);
        logProcess.setTargetDatabase(targetDatabase);
        logProcess.setTargetTableName(targetTableName);
        logProcess.setLogTime(timestamp);
//        logProcess.setLogTime(date);
        logProcess.setStatus(status);
        logProcess.setStage(stage);
        logProcess.setMessage(payload);

//        Message<?> insertValues = MessageBuilder.createMessage(logProcess, messageHeaders);
        databaseGateway.insertProccessLog(logProcess);

        return result;
    }

}
