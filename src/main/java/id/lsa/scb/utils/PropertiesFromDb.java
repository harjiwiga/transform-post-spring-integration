package id.lsa.scb.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by harji on 5/24/16.
 */
public class PropertiesFromDb {

    private static CredentialUtil credentialUtil = CredentialUtil.getInstance();
    // JDBC driver name and database URL
    static final  String JDBC_DRIVER = credentialUtil.getValue("ADR_CONFIGURATION_DRIVER");
    static final String DB_URL = credentialUtil.getValue("ADR_CONFIGURATION_URL");

    //  Database credentials
    static final String USER = credentialUtil.getValue("ADR_CONFIGURATION_USERNAME");
    static final String PASS = credentialUtil.getValue("ADR_CONFIGURATION_PASSWORD");

    public PropertiesFromDb() {

    }

    public void assignDataProperties(String[] args, AdrUtil adrUtil) {

        Connection conn = null;
        Statement stmt = null;
        String configTableName = credentialUtil.getValue("ADR_CONFIGURATION_TABLE");

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String condition = "";
            if(!args[2].equalsIgnoreCase("all"))
                condition = "AND lower(SEQUENCE) = lower('" + args[2] + "')";

//            stmt.setMaxRows(1);
            String sql = "SELECT * FROM "+configTableName+" where lower(COUNTRY_CODE) = lower('" + args[0] + "') AND lower(LOAD_TYPE) = lower('" + args[1] + "') "+condition+" AND ACTIVE=1 ;";
            System.out.println("sqlStatement="+sql);
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            /**
             * COUNTRY_CODE,SOURCE_DIRECTORY,DIRECTORY_CODE,FILE_PATTERN,TARGET_DATABASE,INCLUDING_SUB_FOLDER,FREQUENCY,RETENTION_COUNT,ACTIVE,EXTENSIONS,SEQUENCE
             */

            /**
             * @TODO harji : implement error handling if the query not get any data
             */


//            boolean isEmpty = (rs.getRow()==0);

//            System.out.print("getRow: "+rs.getRow());
//            if (isEmpty) {
////                throw new NullPointerException("The Configuration of country id= "+countryId+" was empty");
//                System.out.println("The Configuration of country id: " + countryId + " was empty");
//                rs.close();
//                conn.close();
//                return;
//            }

            Map<String, String> mappingPathDirCode = new HashMap<>();
            String countryCode = "";
            String dirPath = "";
            String dirCode = "";
            String filePattern = "";
            String targetDatabase = "";
            boolean isActive = true;
            String sequence = "";
            String loadType = "";
            String targetTableName = "";
            adrUtil.clearAdrs();

            while (rs.next()) {
                //Retrieve by column name
                countryCode = rs.getString("COUNTRY_CODE");
                dirPath = rs.getString("DIRECTORY_PATH");
                dirCode = rs.getString("DIRECTORY_CODE");
                filePattern = rs.getString("FILE_PATTERN");
                targetDatabase = rs.getString("TARGET_DATABASE");
                isActive = rs.getBoolean("ACTIVE");
                sequence = rs.getString("SEQUENCE");
                loadType = rs.getString("LOAD_TYPE");
                targetTableName = rs.getString("TARGET_TABLENAME");

                //Display values
                Adr adr = new Adr();
                adr.setCountryCode(countryCode);
                adr.setDirectoryPath(dirPath);
                adr.setDirectoryCode(dirCode);
                adr.setFilePattern(filePattern);
                adr.setTargetDatabase(targetDatabase);
                adr.setActive(isActive);
                adr.setSequence(sequence);
                adr.setLoadType(loadType);
                adr.setTargetTablename(targetTableName);
                adr.addParam();
                adrUtil.addAdrs(adr);
            }

            String sql2 = "SELECT DIRECTORY_PATH, DIRECTORY_CODE FROM "+configTableName+";";
            rs = stmt.executeQuery(sql2);

//            while (rs.next()){
//                mappingPathDirCode.put(rs.getString("DIRECTORY_PATH"), rs.getString("DIRECTORY_CODE"));
//            }
//
//            adrUtil.setMappingPathDirCode(mappingPathDirCode);
            adrUtil.setSourceRootDir(args[3]);

            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }
}
