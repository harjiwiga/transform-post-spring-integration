package id.lsa.scb.utils;

import java.util.UUID;

/**
 * Created by harjiwigaasmoko on 4/9/16.
 */
public class AppUtil {

    public static String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid);
    }
}
