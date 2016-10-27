package com.rhc.automation;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BaseTest {
    private static ObjectMapper mapper;
    
    @BeforeClass
    public static void initJsonMapper() {
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                        .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                        .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }
    
    protected <T> String getJsonString(Class<T> clazz, String jsonFile) {
        String json = null;
        try {
            Object obj = getJsonData(clazz, jsonFile);
            json = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return json;
        
    }
    
    protected <T>T getJsonData(Class<T> clazz, String jsonFile) throws JsonParseException, JsonMappingException, IOException {
        InputStream stream = getClass().getResourceAsStream(jsonFile);
        T data = mapper.readValue(stream, clazz);
        return data;
    }
}
