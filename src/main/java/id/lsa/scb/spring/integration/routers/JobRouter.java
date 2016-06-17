package id.lsa.scb.spring.integration.routers;

import id.lsa.scb.mappers.DatameerJob;
import id.lsa.scb.mappers.exportjob.ExportJob;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.mappers.workbook.WorkBook;
import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by harji on 4/21/16.
 */

@MessageEndpoint
public class JobRouter {
    private static Logger logger = Logger.getLogger(JobRouter.class);

//    @Router(inputChannel = "outJobs",applySequence = "true")
    public String pointJob(@Payload DatameerJob job) {

        String jobEndpoint = "";
        if (job instanceof ImportJob) {
            jobEndpoint = "ImportJsonChannel";
            logger.info("JobRouter------ ImportJob");
        }
        else if (job instanceof WorkBook) {
            jobEndpoint = "WorkbookJsonChannel";
            logger.info("JobRouter------ Workbook");
        } else if (job instanceof ExportJob) {
            jobEndpoint = "ExportJsonChannel";
            logger.info("JobRouter------ Export");
        } else {
            jobEndpoint = "errorChannel";
        }

        return jobEndpoint;
    }

}
