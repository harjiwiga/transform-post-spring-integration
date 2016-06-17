package id.lsa.scb.spring.integration.transformers;

import id.lsa.scb.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * Created by harji on 5/16/16.
 */

@Component
public class AuthorizationHeader {

    @Autowired
    private PropertiesUtil propertiesUtil;

    private Logger logger = Logger.getLogger(AuthorizationHeader.class);

    private String username = propertiesUtil.getProperty("datameer.username");
    private String password = propertiesUtil.getProperty("datameer.password");

    public String contructAut(){

        String headerEntity ="Basic ";
        String combinedUsernamePassword = username+":"+password;
        byte[] base64Token = Base64.encode(combinedUsernamePassword.getBytes());
        String base64EncodedToken = new String (base64Token);
        String credential = headerEntity+base64EncodedToken;

        return credential.trim();
    }
}
