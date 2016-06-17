package id.lsa.scb.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by harji on 6/2/16.
 */

//(COUNTRY_CODE,DIRECTORY_PATH,FILENAME,TARGET_DATABASE,TARGET_TABLENAME,LOG_TIME,RULE_APPLIED,STATUS,STAGE,MESSAGE)
public class LogProcessMapper implements RowMapper<LogProcess> {
    @Override
    public LogProcess mapRow(ResultSet resultSet, int i) throws SQLException {
        LogProcess logProcess =new LogProcess();
        logProcess.setId(resultSet.getInt("ID"));
        logProcess.setCountryCode(resultSet.getString("COUNTRY_CODE"));
        logProcess.setDirectoryPath(resultSet.getString("DIRECTORY_PATH"));
        logProcess.setFileName(resultSet.getString("FILENAME"));
        logProcess.setTargetDatabase(resultSet.getString("TARGET_DATABASE"));
        logProcess.setTargetTableName(resultSet.getString("TARGET_TABLENAME"));
        logProcess.setLogTime(resultSet.getTimestamp("LOG_TIME"));
        logProcess.setRuleApplied(resultSet.getString("RULE_APPLIED"));
        logProcess.setStatus(resultSet.getString("STATUS"));
        logProcess.setStage(resultSet.getString("STAGE"));
        logProcess.setMessage(resultSet.getString("MESSAGE"));
        return logProcess;
    }
}
