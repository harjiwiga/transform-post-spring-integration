package id.lsa.scb.spring.integration.transformers;

import id.lsa.scb.mappers.JobMessage;
import id.lsa.scb.spring.integration.errorwrapper.NamePatternException;
import id.lsa.scb.utils.Adr;
import id.lsa.scb.utils.AdrUtil;
import id.lsa.scb.utils.FileUtil;
import id.lsa.scb.utils.NamingFunctionMapUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harji on 6/3/16.
 */

@MessageEndpoint
public class ServiceCombiner {

    private Logger logger = Logger.getLogger(ServiceCombiner.class);

//    @Resource(name="pojoUtil")
//    private AdrUtil adrUtil;


    public void setAdrUtil(AdrUtil adrUtil) {
        this.adrUtil = adrUtil;
    }

    @Autowired
    private AdrUtil adrUtil;

    public HashMap<String,Object> addConfig(File file){

        HashMap<String,Object>messageMap = new HashMap<>();
        Adr adr = new Adr();


        //TODO
        // move code from FieldToJson here
        String fileName = file.getName(); // can get absolute file path from here
        String absolutePath = file.getAbsolutePath();
        String filePath = absolutePath.replace("/"+fileName, "");
//        String scenario = null;
//        Long timestamp = adrUtil.getCreatedDate().get(absolutePath);

        String rootPath = adrUtil.getSourceRootDir();


        //get mapping source rule
        Map<String, String> params = new HashMap<>();
        for(Adr ad:adrUtil.getAdrs()){
            params.putAll(ad.getParams());
            ad.getLoadType();
            if(FileUtil.priorityChecker(filePath, rootPath, params)){
                ad.getLoadType();
                adr = ad;
            }
        }


        //TODO taruh depan, so, this class just get right values and filename
        // check if it's empty file or not
        if(file.length()==0){
            throw new NullPointerException("Empty file");
        }

        messageMap.put("matchConf",adr);
        messageMap.put("file",file);

        return messageMap;
    }
}
