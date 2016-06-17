package id.lsa.scb.spring.integration.handlers;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by harji on 5/18/16.
 */

@Component
public class FileHandler {

    public File handleFile(File input) {
        System.out.println("Copying file: " + input.getAbsolutePath() + "with length :" + input.length());

        // check the file is fully available (full file was copied and no part files processed ...
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(input);

            System.out.println("***********  Stream available now");

        }
        catch (IOException e) {
            System.out.println("##########  Stream not available now");
        }
        finally {
            try {

                stream.close();
            }catch(Exception e) {

            }
        }


        return input;
    }

}
