package id.lsa.scb.spring.integration.transformers;

import com.epam.parso.SasFileProperties;
import com.epam.parso.impl.SasFileReaderImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.lsa.scb.constructors.ExportConstructor;
import id.lsa.scb.constructors.ImportConstructor;
import id.lsa.scb.constructors.WorkBookConstructor;
import id.lsa.scb.mappers.JobMessage;
import id.lsa.scb.mappers.importjob.ImportJob;
import id.lsa.scb.utils.Adr;
import id.lsa.scb.utils.AdrUtil;
import id.lsa.scb.utils.FileUtil;
import id.lsa.scb.utils.PropertiesUtil;
import id.lsa.scb.spring.integration.errorwrapper.NamePatternException;
import id.lsa.scb.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harji on 4/18/16.
 */
@MessageEndpoint
public class FieldToJson {

    private Logger logger = Logger.getLogger(FieldToJson.class);

    @Autowired
    private PropertiesUtil propertyUtil;

    @Resource(name="pojoUtil")
    private AdrUtil adrUtil;

    public JobMessage process(@Payload File file, @Headers MessageHeaders headers) throws IOException {

        JobMessage jobMessage = new JobMessage();
        logger.info("headers:"+headers.get("fileMatchConf"));
        FileInputStream is = null;
        String timestamp_datameerJob = String.valueOf(System.currentTimeMillis());

        try {

            // create message parser same like in SuccessUnwrapper
            Adr adr = (Adr) headers.get("fileMatchConf");

            is = new FileInputStream(file);
            com.epam.parso.SasFileReader sasFileReader = new SasFileReaderImpl(is);
//            SasFileProperties sasFileProperties = sasFileReader.getSasFileProperties();

            String fileName = file.getName().replace(" ","_");
            String absolutePath = file.getAbsolutePath();
//        String filePath = absolutePath.replace("/"+fileName, "");
//        String rootPath = adrUtil.getSourceRootDir();
            String scenario = null;
            String tableName = null;

            Path fileP = Paths.get(file.getAbsolutePath());
            BasicFileAttributes attr = Files.readAttributes(fileP, BasicFileAttributes.class);
            Long timestamp_createdDate = attr.creationTime().toMillis();


            // check which scenario used
            scenario = FileUtil.filePatternScenarioSelector(fileName);

            logger.info("[SCENARIO] " + scenario);

            if(scenario.equals("scenario2")){

                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                String date = formatter.format(new java.util.Date (timestamp_createdDate));

                String mainFileName = fileName.split("\\.")[0];

                tableName = mainFileName+"_"+date+"_"+ adr.getDirectoryCode();

            } else if(scenario.equals("scenario1_3")){

                tableName = NamingFunctionMapUtil.getInstance().getScenarioOneThree(fileName, adr.getDirectoryCode()).get("appendDirID");
            }

            // import job
            ImportConstructor imc = new ImportConstructor(sasFileReader.getColumns(), fileName);
            // imc.constructImport(); // fixed path, development only
//            imc.constructImport(absolutePath, subDir, timestamp); // real environment
            imc.constructImport(absolutePath, adr.getDirectoryCode(), timestamp_datameerJob);
            ImportJob importJob = imc.getImportJob();
            logger.info("[IMPORT_JOB] " + importJob);

            // workbook job
            WorkBookConstructor wrk = new WorkBookConstructor(importJob, fileName);
            wrk.constructWorkbook(adr.getDirectoryCode(), timestamp_datameerJob);
            id.lsa.scb.mappers.workbook.WorkBook workBook = wrk.getWorkBook();
            logger.info("[WORKBOOK_JOB]" + workBook);

            // export job
            ExportConstructor exc = new ExportConstructor(sasFileReader.getColumns(), fileName, workBook);
            exc.constructExportJob(adr.getTargetDatabase(), tableName, adr.getDirectoryCode(), timestamp_datameerJob);
            id.lsa.scb.mappers.exportjob.ExportJob exportJob = exc.getExportJob();
            logger.info("[EXPORT_JOB]" + exportJob);

//             write json into file
             ObjectMapper mapper = new ObjectMapper();
             mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/arifpz/Documents/SAS/JsonResult_FinalTest/import_"+timestamp_datameerJob+".json"), importJob);
             mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/arifpz/Documents/SAS/JsonResult_FinalTest/workbook_"+timestamp_datameerJob+".json"), importJob);
             mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/arifpz/Documents/SAS/JsonResult_FinalTest/export_"+timestamp_datameerJob+".json"), exportJob);
//             write json into file


            jobMessage.setTableName(tableName);
            jobMessage.setCountryCode(adr.getCountryCode());
            jobMessage.setDirectoryPath(adr.getDirectoryPath());
            jobMessage.setDirectoryCode(adr.getDirectoryCode());
            jobMessage.setFilePatternUsed(adr.getFilePattern());
            jobMessage.setTargetDatabase(adr.getTargetDatabase());
            jobMessage.setLoadType(adr.getLoadType());
            jobMessage.setRuleApplied(adr.getRule());

            jobMessage.setImportJob(importJob);
            jobMessage.setWorkBook(workBook);
            jobMessage.setExportJob(exportJob);

            logger.info("[FILE NAME] "+fileName);
            logger.info("[TABLE NAME] " + file.getPath());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(is!=null) {
                is.close();
                is=null;
            }
        }

        return jobMessage;
    }

}