package id.lsa.scb.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arifpz on 02/06/16.
 */
public class NamingFunctionMapUtil {

    private static NamingFunctionMapUtil instance = null;

    private NamingFunctionMapUtil(){
    }

    public static synchronized NamingFunctionMapUtil getInstance(){
        if (instance == null)
            instance = new NamingFunctionMapUtil();
        return instance;
    }


    //TODO
    // refactor so that just need to create one method
    // correspond to NamingFunctionUtil

//    /**
//     *
//     * @param fileName
//     * @param dirCode
//     * @return
//     */
//    public Map<String, String> getNamingFunctionMapPassAll(String fileName, String dirCode){
//
//        Map<String, String> namingFunctionMap = new HashMap<>();
//
//        namingFunctionMap.put("sameAsFileName", NamingFunctionUtil.sameAsFileName(fileName, dirCode));
//        namingFunctionMap.put("appendDirID", NamingFunctionUtil.appendDirID(fileName, dirCode));
//
//        return namingFunctionMap;
//    }
//
//    /**
//     *
//     * @param fileName
//     * @param dirCode
//     * @return
//     */
//    public Map<String, String> getNamingFunctionMap(String fileName, String dirCode){
//
//        Map<String, String> namingFunctionMap = new HashMap<>();
//
//        namingFunctionMap.put("replacem00withCurrentYYYYMMDirID", NamingFunctionUtil.replacem00withCurrentYYYYMMDirID(fileName, dirCode));
//        namingFunctionMap.put("replacem01withCurrentYYYYMMDirID", NamingFunctionUtil.replacem01withCurrentYYYYMMDirID(fileName, dirCode));
//        namingFunctionMap.put("replacew00withCurrentYYYYMMDDDirID", NamingFunctionUtil.replacew00withCurrentYYYYMMDDDirID(fileName, dirCode));
//        namingFunctionMap.put("replacew01withCurrentYYYYMMDDDirID", NamingFunctionUtil.replacew01withCurrentYYYYMMDDDirID(fileName, dirCode));
//        namingFunctionMap.put("replaced00withCurrentYYYYMMDDDirID", NamingFunctionUtil.replaced00withCurrentYYYYMMDDDirID(fileName, dirCode));
//        namingFunctionMap.put("replaced01withCurrentYYYYMMDDDirID", NamingFunctionUtil.replaced01withCurrentYYYYMMDDDirID(fileName, dirCode));
//        namingFunctionMap.put("addingFileNameWithTimestampYYYYMMDD", NamingFunctionUtil.addingFileNameWithTimestampYYYYMMDD(fileName, dirCode));
//        namingFunctionMap.put("addingFileNameWithTimestampYYMMDD", NamingFunctionUtil.addingFileNameWithTimestampYYMMDD(fileName, dirCode));
//        namingFunctionMap.put("addingFileNameWithTimestampYYYYMM", NamingFunctionUtil.addingFileNameWithTimestampYYYYMM(fileName, dirCode));
//        namingFunctionMap.put("addingFileNameWithTimestampYYMM", NamingFunctionUtil.addingFileNameWithTimestampYYMM(fileName, dirCode));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD(fileName, dirCode));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD(fileName, dirCode));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM(fileName, dirCode));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM(fileName, dirCode));
//
//        return namingFunctionMap;
//    }
//
//
//    /**
//     *
//     * @param fileName
//     * @return
//     */
//    public Map<String, String> getNamingFunctionMap(String fileName){
//
//        Map<String, String> namingFunctionMap = new HashMap<>();
//
//        namingFunctionMap.put("addingFileNameWithTimestampYYYYMMDD", NamingFunctionUtil.addingFileNameWithTimestampYYYYMMDD(fileName));
//        namingFunctionMap.put("addingFileNameWithTimestampYYMMDD", NamingFunctionUtil.addingFileNameWithTimestampYYMMDD(fileName));
//        namingFunctionMap.put("addingFileNameWithTimestampYYYYMM", NamingFunctionUtil.addingFileNameWithTimestampYYYYMM(fileName));
//        namingFunctionMap.put("addingFileNameWithTimestampYYMM", NamingFunctionUtil.addingFileNameWithTimestampYYMM(fileName));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD(fileName));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD(fileName));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM(fileName));
//        namingFunctionMap.put("replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM", NamingFunctionUtil.replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM(fileName));
//
//        return namingFunctionMap;
//    }


    /**
     *
     * @param fileName
     * @param dirCode
     * @return
     */
    public Map<String, String> getScenarioOneThree(String fileName, String dirCode){
        Map<String, String> namingFunctionMap = new HashMap<>();

        namingFunctionMap.put("sameAsFileName", NamingFunctionUtil.sameAsFileName(fileName, dirCode));
        namingFunctionMap.put("appendDirID", NamingFunctionUtil.appendDirID(fileName, dirCode));

        return namingFunctionMap;
    }

    /**
     *
     * @param fileName
     * @param dirCode
     * @return
     */
    public Map<String, String> getScenarioTwo(String fileName, String dirCode, Long timestamp){
        Map<String, String> namingFunctionMap = new HashMap<>();

        namingFunctionMap.put("replacem00withCurrentYYYYMMDirID", NamingFunctionUtil.replacem00withCurrentYYYYMMDirID(fileName, dirCode, timestamp));
        namingFunctionMap.put("replacem01withCurrentYYYYMMDirID", NamingFunctionUtil.replacem01withCurrentYYYYMMDirID(fileName, dirCode, timestamp));
        namingFunctionMap.put("replacew00withCurrentYYYYMMDDDirID", NamingFunctionUtil.replacew00withCurrentYYYYMMDDDirID(fileName, dirCode, timestamp));
        namingFunctionMap.put("replacew01withCurrentYYYYMMDDDirID", NamingFunctionUtil.replacew01withCurrentYYYYMMDDDirID(fileName, dirCode, timestamp));
        namingFunctionMap.put("replaced00withCurrentYYYYMMDDDirID", NamingFunctionUtil.replaced00withCurrentYYYYMMDDDirID(fileName, dirCode, timestamp));
        namingFunctionMap.put("replaced01withCurrentYYYYMMDDDirID", NamingFunctionUtil.replaced01withCurrentYYYYMMDDDirID(fileName, dirCode, timestamp));

        return namingFunctionMap;
    }

//    /**
//     *
//     * @param fileName
//     * @param dirCode
//     * @return
//     */
//    public Map<String, String> getScenarioThree(String fileName, String dirCode){
//        Map<String, String> namingFunctionMap = new HashMap<>();
//
//        namingFunctionMap.put("appendDirID", NamingFunctionUtil.appendDirID(fileName, dirCode));
//
//        return namingFunctionMap;
//    }

    // correspond to NamingFunctionUtil
    // refactor so that just need to create one method

}
