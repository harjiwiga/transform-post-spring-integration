package id.lsa.scb.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by charly on 31/05/16.
 *
 */
public class NamingFunctionUtil {


    //TODO
    // refactor so that just need to create one method
    // correspond to NamingFunctionUtil

    /**
     * e.g :
     * input    : account_201311.sas7bdat
     * output   : account_201311
     *
     * @param fileName
     * @return
     */
    public static String sameAsFileName(String fileName, String dir_id){

        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }

        return fileName;

    }

    /**
     * e.g :
     * input    : account.sas7bdat, 001
     * output   : account_01
     *
     * @param fileName
     * @param dir_id
     * @return
     */
    public static String appendDirID(String fileName, String dir_id){

        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }

        String newFilename = fileName.concat("_"+dir_id);

        return newFilename;

    }

    /**
     * e.g :
     * input    : account_m03.sas
     * output   : account_201603_m01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replacem00withCurrentYYYYMMDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
//        if(i==0){
//            cal.add(Calendar.MONTH, i);
//        }
//        else if(i>0){
//            cal.add(Calendar.MONTH, -i);
//        }
//
//        Date today = cal.getTime();
//        String tmStamp = formatter.format(today);

//        String newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account_m03.sas
     * output   : account_201604_m01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replacem01withCurrentYYYYMMDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
//
//        String tmStamp = null;
//        String newFilename = null;
//
//        if(i>0){
//            cal.add(Calendar.MONTH, 1);
//            cal.add(Calendar.MONTH, -i);
//            Date today = cal.getTime();
//            tmStamp = formatter.format(today);
//            newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
//        }
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account_w02.sas
     * output   : account_20160519_w01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replacew00withCurrentYYYYMMDDDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        if(i==0){
//            cal.add(Calendar.DATE, i);
//        }
//        else if(i>0){
//            cal.add(Calendar.DATE, -(i*7));
//        }
//
//        Date today = cal.getTime();
//        String tmStamp = formatter.format(today);
//
//        String newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account_w02.sas
     * output   : account_20160526_w01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replacew01withCurrentYYYYMMDDDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        String newFilename = null;
//        if(i>0){
//            cal.add(Calendar.DATE, -(i*7));
//            cal.add(Calendar.DATE, 7);
//            Date today = cal.getTime();
//            String tmStamp = formatter.format(today);
//            newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
//        }
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_d01.sas
     * output   : account_20160601_d01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaced00withCurrentYYYYMMDDDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        if(i==0){
//            cal.add(Calendar.DATE, i);
//        }
//        else if(i>0){
//            cal.add(Calendar.DATE, -i);
//        }
//
//        Date today = cal.getTime();
//        String tmStamp = formatter.format(today);
//
//        String newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_d01.sas
     * output   : account_20160602_d01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaced01withCurrentYYYYMMDDDirID(String filename, String dir_id, Long timestamp){
        int pos = filename.lastIndexOf(".");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        String mainFilename=null;
        String endWith= null;
        char id = 0;
        pos = filename.lastIndexOf("_");

        if (pos > 0) {
            mainFilename = filename.substring(0, pos);
            endWith = filename.substring(pos+1, filename.length());
            id = endWith.charAt(0);
            endWith = endWith.substring(1);
        }

//        Integer i = Integer.valueOf(endWith);
        //========
//        int i = Integer.parseInt(endWith.trim());
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//
//        String newFilename = null;
//        if(i>0){
//            cal.add(Calendar.DATE, -i);
//            cal.add(Calendar.DATE, 1);
//            Date today = cal.getTime();
//            String tmStamp = formatter.format(today);
//            newFilename = mainFilename.concat("_"+id+tmStamp+"_"+dir_id);
//        }
        //========

        String date = new java.text.SimpleDateFormat("yyyymmdd").format(new java.util.Date (timestamp*1000));
        String newFilename = mainFilename.concat("_"+id+date+"_"+dir_id);

//        Timestamp timestampConvert = new java.sql.Timestamp(timestamp);
//        String newFilename = mainFilename.concat("_"+id+timestampConvert.toString()+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input   : account
     * output  : account_20160601
     *
     * @param filename
     * @return
     */
    public static String addingFileNameWithTimestampYYYYMMDD(String filename){
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account, 01
     * output   : account_20160601_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String addingFileNameWithTimestampYYYYMMDD(String filename, String dir_id){
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account
     * output   : account_160601
     *
     * @param filename
     * @return
     */
    public static String addingFileNameWithTimestampYYMMDD(String filename) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account, 01
     * output   : account_160601_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String addingFileNameWithTimestampYYMMDD(String filename, String dir_id) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account
     * output   : account_201606
     *
     * @param filename
     * @return
     */
    public static String addingFileNameWithTimestampYYYYMM(String filename) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account, 01
     * output   : account_201606_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String addingFileNameWithTimestampYYYYMM(String filename, String dir_id) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account
     * output   : account_1606
     *
     * @param filename
     * @return
     */
    public static String addingFileNameWithTimestampYYMM(String filename) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account, 01
     * output   : account_1606_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String addingFileNameWithTimestampYYMM(String filename, String dir_id) {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }


    /**
     * e.g:
     * input    : account_xywsk
     * output   : account_20160601
     *
     * @param filename
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD(String filename){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_xywsk, 01
     * output   : account_20160601_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMMDD(String filename, String dir_id){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_xywsk
     * output   : account_160601
     *
     * @param filename
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD(String filename){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_xywsk
     * output   : account_160601-01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMMDD(String filename, String dir_id){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account_xywsk
     * output   : account_201606
     *
     * @param filename
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM(String filename){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_xywsk
     * output   : account_201606_01
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYYYMM(String filename, String dir_id){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }

    /**
     * e.g :
     * input    : account_xywsk
     * output   : account_1606
     *
     * @param filename
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM(String filename){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp);

        return newFilename;
    }

    /**
     * e.g:
     * input    : account_xywsk
     * output   : account_1606
     *
     * @param filename
     * @param dir_id
     * @return
     */
    public static String replaceWordFileNameAfterTheLastUnderscoreWithTimestampYYMM(String filename, String dir_id){

        int pos = filename.lastIndexOf("_");
        if (pos > 0) {
            filename = filename.substring(0, pos);
        }
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");

        String tmStamp = formatter.format(today);

        String newFilename = filename.concat("_"+tmStamp+"_"+dir_id);

        return newFilename;
    }


    // correspond to NamingFunctionUtil
    // refactor so that just need to create one method

}
