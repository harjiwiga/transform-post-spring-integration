package id.lsa.scb.spring.integration.gateway;

import id.lsa.scb.mappers.exportjob.ExportJob;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.mappers.workbook.WorkBook;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by harji on 4/19/16.
 */

@MessagingGateway
public interface DatameerGateway {

    @Gateway
    public String login(String login);

    @Gateway
    public String postImportJob(@Payload ImportJob importJob);

    @Gateway
    public String postWorkbook(@Payload WorkBook importJob);

    @Gateway
    public String postExportJob(@Payload ExportJob importJob);


}
