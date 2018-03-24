package com.vanhack.ezequiel.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

    public static String convertToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try{
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            return json;
        }catch(JsonProcessingException e){
            return null;
        }
    }

    public static Object convertToObject(String json, Class classType){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json, classType);
        }catch(IOException e){
            return null;
        }
    }

    private void parseJsonAndDiscoverTheClass(String json) throws IOException {
        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(json);

        Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {

            Map.Entry<String,JsonNode> field = fieldsIterator.next();
            System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
        }
    }
}
