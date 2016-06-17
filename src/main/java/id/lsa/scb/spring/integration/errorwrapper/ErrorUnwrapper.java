package id.lsa.scb.spring.integration.errorwrapper;

import id.lsa.scb.mappers.LogProcess;
import id.lsa.scb.spring.integration.gateway.DatabaseGateway;
import id.lsa.scb.utils.Adr;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.ErrorMessage;

import java.sql.Timestamp;

/**
 * Created by harjiwigaasmoko on 4/23/16.
 */
@MessageEndpoint
public class ErrorUnwrapper {

    private static Logger logger = Logger.getLogger(ErrorUnwrapper.class);

    @Autowired
    private DatabaseGateway databaseGateway;

    @Autowired
    private LogProcess logProcess;

    @ServiceActivator(inputChannel = "errorChannel", autoStartup = "true", sendTimeout = "10000", outputChannel = "errorChannel.output")
    public String proccessError(ErrorMessage message) {

        logger.info("payload: " + message.getPayload().getMessage());
        logger.info("failed message: " + ((MessagingException) message.getPayload()).getFailedMessage().getHeaders());

        MessagingException me = ((MessagingException) message.getPayload());

        MessageHeaders headers = ((MessagingException) message.getPayload()).getFailedMessage().getHeaders();

        Adr adr = (Adr) headers.get("fileMatchConf");



        String fileName = ""; //current
        String errorMessage = message.getPayload().getMessage(); //current
        String[] errorMessageDetails = errorMessage.split(";");
        String countryCode = "";
        String sourceDirectory = "";
        String targetDatabase = "";
        String targetTableName = "tableNameNull";
        Long processingDatetime;
        String status = "Failure";
        String stage = "";

        if (me != null) {
            headers = (me).getFailedMessage().getHeaders();

            fileName = String.valueOf(headers.get("fileName"));
            targetTableName = String.valueOf(headers.get("tableName"));
            countryCode = adr.getCountryCode();
            sourceDirectory = adr.getDirectoryPath();
            targetDatabase = adr.getTargetDatabase();
        }

        processingDatetime = headers.getTimestamp(); //current

        String nullError = "ArrayIndexOutOfBoundsException";
        String nullError2 = "java.lang.NullPointerException: Empty file";
        String uriError = "failed for URI";
        String importJobError = "/rest/import-job";
        String workbookError = "/rest/workbook";
        String exportJobError = "/rest/export-job";

        try {
            if (errorMessageDetails[0].contains(uriError) && errorMessageDetails[0].contains(importJobError)) {
                stage = "Import JSON failed";
            } else if (errorMessageDetails[0].contains(uriError) && errorMessageDetails[0].contains(workbookError)) {
                stage = "Workbook JSON failed";
            } else if (errorMessageDetails[0].contains(uriError) && errorMessageDetails[0].contains(exportJobError)) {
                stage = "Export JSON failed";
            } else if (errorMessageDetails[1].contains(nullError) || errorMessageDetails[1].contains(nullError2)) {
                stage = "Empty File";
            } else {
                stage = "Unknown Error";
            }
        } catch (Exception e) {
            logger.info("exception:"+e.getMessage());
            stage ="Unknown error";
        }

        Timestamp timestamp = new java.sql.Timestamp(processingDatetime);

        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (processingDatetime*1000));

        String errorString = date + ";" + countryCode + ";" + sourceDirectory + ";" + fileName + ";" + targetDatabase + ";" + targetTableName +  ";" + status + ";" + stage + ";" + errorMessage + ";" + message.getPayload();
//        String errorString = timestamp + ";" + countryCode + ";" + sourceDirectory + ";" + fileName + ";" + targetDatabase + ";" + targetTableName +  ";" + status + ";" + stage + ";" + errorMessage + ";" + message.getPayload();

        String payload = String.valueOf(message.getPayload());

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


        return errorString;
    }

}
