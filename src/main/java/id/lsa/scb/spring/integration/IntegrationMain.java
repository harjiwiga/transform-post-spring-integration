package id.lsa.scb.spring.integration;

import id.lsa.scb.utils.AdrUtil;
import id.lsa.scb.utils.PropertiesFromDb;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.PollableChannel;

import java.io.IOException;

/**
 * Created by harji on 4/14/16.
 */
public class IntegrationMain {


    private static Logger logger = Logger.getLogger(IntegrationMain.class);


    public static AdrUtil adrUtil = AdrUtil.getInstance();

    public static void main(String[] args) throws IOException {

        System.out.println(" ===================== Automatic Data Replicator =========================== ");
        System.out.println(" =                          Lightstream Asia                               = ");
        System.out.println(" =                                2016                                     = ");
        System.out.println(" ===================== -------------------------- ========================== ");

        PropertiesFromDb propertiesFromDb = new PropertiesFromDb();

        switch (args.length) {
            case 0:
                exit("country_id");
                break;
            case 1:
                exit("load_type");
            break;
            case 2:
                exit("sequence");
                break;
            case 3:
                exit("source root directory");
                break;
        }

        propertiesFromDb.assignDataProperties(args,adrUtil);

        if(adrUtil.getAdrs().size() > 0) {
            if (adrUtil.getAdrs().get(0).getDirectoryPath() == null || adrUtil.getAdrs().get(0).getDirectoryPath().isEmpty()) {
                System.out.println("The Configuration of country id: " + args[0] + " was empty");
                System.exit(0);
            }
        }else{
            System.out.println("sqlStatement return empty result");
            System.exit(0);
        }

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/adr-context.xml", IntegrationMain.class);
//        adrUtil = (AdrUtil) context.getBean("pojoUtil");

//        propertiesFromDb.assignDataProperties(args,adrUtil);
        context.registerShutdownHook();

        PollableChannel pollableChannel = context.getBean("shutdownChannel",PollableChannel.class);
        pollableChannel.receive();
        System.out.println("exit ADR application after idle 20 sec ...... ");
        context.close();

    }

    private static void exit(String param){
        System.out.println("missing parameter "+param);
        System.exit(0);
    }
}
