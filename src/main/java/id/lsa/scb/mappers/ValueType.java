package id.lsa.scb.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * Created by harjiwigaasmoko on 4/9/16.
 */
public class ValueType {

    private String type;

    public ValueType(String type){
        this.type = type.toUpperCase();
    }

    public ValueType(Class clazz){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //dynamic format from java reader each column of sas7bdat
    public String getJson(){
        String jsonType = "{\"type\":\""+this.getType()+"\"}";
        return jsonType;
    }

}
