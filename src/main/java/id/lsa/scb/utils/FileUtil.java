package id.lsa.scb.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harji on 4/8/16.
 */
public class FileUtil {


    /**
     *
     * @param fileName
     * @param fileNamePattern
     * @return
     */
    public static boolean filePatternChecker(String fileName, String fileNamePattern){

        boolean result= false;

        result = fileName.matches(fileNamePattern);

        return result;
    }

//    /**
//     *
//     * @param fileName
//     * @return
//     */
//    public static String sLoadTypeChecker(String fileName){
//
//        String result = null;
//
//        if(fileName.matches(".*_(m)(000|001|00|01)\\..*"))
//            result = "replacem00withCurrentYYYYMMDirID";
//        else if(fileName.matches(".*_(d)(000|001|00|01)\\..*"))
//            result = "replaced00withCurrentYYYYMMDDDirID";
//        else if(fileName.matches(".*_(w)(000|001|00|01)\\..*"))
//            result = "replacew00withCurrentYYYYMMDDDirID";
//
//        return result;
//    }
//
//    /**
//     *
//     * @param fileName
//     * @return
//     */
//    public static String hLoadTypeChecker(String fileName){
//        String result = null;
//
//        if(fileName.matches(".*_m(\\d{2}|\\d{3})\\..*"))
//            result = "replacem01withCurrentYYYYMMDirID";
//        else if(fileName.matches(".*_d(\\d{2}|\\d{3})\\..*"))
//            result = "replaced01withCurrentYYYYMMDDDirID";
//        else if(fileName.matches(".*_w(\\d{2}|\\d{3})\\..*"))
//            result = "replacew01withCurrentYYYYMMDDDirID";
//
//        return result;
//    }



    /**
     *
     * @param fileName
     * @return
     */
    public static String sLoadTypeChecker(String fileName){

        String result = null;

        if(fileName.matches(".*_(m)(000|00)\\..*"))
            result = "replacem00withCurrentYYYYMMDirID";
        else if(fileName.matches(".*_(m)(001|01)\\..*"))
            result = "replacem01withCurrentYYYYMMDirID";
        else if(fileName.matches(".*_(d)(000|00)\\..*"))
            result = "replaced00withCurrentYYYYMMDDDirID";
        else if(fileName.matches(".*_(d)(001|01)\\..*"))
            result = "replaced01withCurrentYYYYMMDDDirID";
        else if(fileName.matches(".*_(w)(000|00)\\..*"))
            result = "replacew00withCurrentYYYYMMDDDirID";
        else if(fileName.matches(".*_(w)(001|01)\\..*"))
            result = "replacew01withCurrentYYYYMMDDDirID";

        return result;
    }

    /**
     *
     * @param fileName
     * @return
     */
    //TODO make sure with Guru about this case
    public static String hLoadTypeChecker(String fileName){
        String result = null;

        if(fileName.matches(".*_m(\\d{2}|\\d{3})\\..*")){
            result = "replacem01withCurrentYYYYMMDirID";
//            result = "replacem00withCurrentYYYYMMDirID";
        }
        else if(fileName.matches(".*_d(\\d{2}|\\d{3})\\..*")){
            result = "replaced01withCurrentYYYYMMDDDirID";
//            result = "replaced00withCurrentYYYYMMDDDirID";
        }
        else if(fileName.matches(".*_w(\\d{2}|\\d{3})\\..*")) {
            result = "replacew01withCurrentYYYYMMDDDirID";
//            result = "replacew00withCurrentYYYYMMDDDirID";
        }

        return result;
    }



    /**
     *
     * @param fileName
     * @return
     */
    public static String filePatternScenarioSelector(String fileName){

        String result = null;
        boolean check = false;

//        Map<String, String> scenarioRegexMap = new HashMap<>();
//        scenarioRegexMap.put("scenario1","_(\\d{4})\\.;_(\\d{2}|\\d{4})[0-1][0-9]\\.;_(\\d{2}|\\d{4})[0-1][0-9][0-3][0-9]\\.");
//        scenarioRegexMap.put("scenario2","_(m|d|w)(\\d{2}|\\d{3})\\.");
//        scenarioRegexMap.put("scenario3",".*");

        String regex = ".*_(m|d|w)(\\d{2}|\\d{3})\\..*";

//        getOut:
//        //loop scenario-regex entry set
//        for (Map.Entry<String, String> reg : scenarioRegexMap.entrySet()){
//            String[] listRegex = reg.getValue().split(";");
//            //loop regex entry set
//            for (int i = 0; i<(listRegex.length-1); i++){
//                if(fileName.matches(listRegex[i])){
//                    result = reg.getKey();
//                    check = true;
//                    break getOut;
//                }
//            }
//        }
//
//        result = check==true?result:"scenario3";

        if(fileName.matches(regex))
            result = "scenario2";
        else
            result = "scenario1_3";

        return result;
    }


    /**
     *
     * @param sasFilename
     * @return
     */
    public static String importJobNaming(String sasFilename, String dirCode, String timestamp) {
        String importJobName = null;

        importJobName = sasFilename + "_ImportJob"+"_"+timestamp+"_"+dirCode;

        return importJobName;
    }

    /**
     *
     * @param sasFilename
     * @return
     */
    public static String workBookNaming(String sasFilename, String dirCode, String timestamp) {
        String workbookName = null;

        workbookName = sasFilename + "_WorkBook"+"_"+timestamp+"_"+dirCode;

        return workbookName;
    }

    /**
     *
     * @param sasFilename
     * @return
     */
    public static String exportJobNaming(String sasFilename, String dirCode, String timestamp) {
        String exportJobName = null;

        exportJobName = sasFilename + "_ExportJob"+"_"+timestamp+"_"+dirCode;

        return exportJobName;
    }

    /**
     *
     * @param filePath
     * @param rootPath
     * @return
     */
    public static boolean priorityChecker(String filePath, String rootPath, Map<String, String> params){

        boolean result = false;
        boolean tempCheck = false;

        result = filePath.equals(rootPath);
        if(result==true){
            return result;
        }

        for(Map.Entry<String, String> param: params.entrySet()){
            if(param.getKey().equals(filePath))
                tempCheck = true;
        }

        if(tempCheck){
            result = filePath.contains(rootPath);
        }

        return result;
    }

    /**
     *
     * @param loadType
     * @param filePattern
     * @return
     */
    // get file pattern for each load type
    public static String loadTypeChecker(String loadType, String filePattern){

        String filePatternUsed = filePattern;
        Pattern pattern = Pattern.compile(filePattern);
        Matcher matcher_d = pattern.matcher("_d01.");
        Matcher matcher_d2 = pattern.matcher("_d001.");
        Matcher matcher_d3 = pattern.matcher("_d00.");
        Matcher matcher_d4 = pattern.matcher("_d000.");

        Matcher matcher_m = pattern.matcher("_m01.");
        Matcher matcher_m2 = pattern.matcher("_m001.");
        Matcher matcher_m3 = pattern.matcher("m_00.");
        Matcher matcher_m4 = pattern.matcher("m_000.");

        Matcher matcher_w = pattern.matcher("_w01.");
        Matcher matcher_w2 = pattern.matcher("_w001.");
        Matcher matcher_w3 = pattern.matcher("_w00.");
        Matcher matcher_w4 = pattern.matcher("_w000.");

        if(loadType.toLowerCase().equals("s") && (matcher_d.matches() || matcher_d2.matches())) filePatternUsed = "_(d)(000|001|00|01)\\.";
        else if(loadType.toLowerCase().equals("s") && (matcher_m.matches() || matcher_m2.matches())) filePatternUsed = "_(m)(000|001|00|01)\\.";
        else if(loadType.toLowerCase().equals("s") && (matcher_w.matches() || matcher_w2.matches())) filePatternUsed = "_(w)(000|001|00|01)\\.";
        else if(loadType.toLowerCase().equals("s") && ((matcher_d.matches() && matcher_m.matches() && matcher_w.matches()) ||
                (matcher_d2.matches() && matcher_m2.matches() && matcher_w2.matches()))) filePatternUsed = "_(m|d|w)(000|001|00|01)\\.";

        return filePatternUsed;
    }

    /**
     *
     * @param filePath
     * @param sourceDirectory
     * @return
     */
    public static boolean priorityConfigChecker(String filePath, String sourceDirectory){

        boolean result = false;
        result = filePath.contains(sourceDirectory);
        return result;
    }

}
