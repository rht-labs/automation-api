package com.rhc.automation.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhc.automation.config.JacksonMapperBuilder;
import com.rhc.automation.model.Engagement;

import java.io.IOException;
import java.io.InputStream;

public class ObjectMother {

    private static ObjectMapper mapper = JacksonMapperBuilder.get().build();

    public static Engagement getBasicValidEngagement( String name ) {
        Engagement engagement = new Engagement();
        engagement.setName( name );
        return engagement;
    }

    public static Engagement getBasicValidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setName( "basic valid engagement" );
        return engagement;
    }

    public static Engagement getBasicInvalidEngagement() {
        Engagement engagement = new Engagement();
        engagement.setName( "basic invalid engagement: no ID" );
        return engagement;
    }

    public static Engagement getEngagementFromJsonFile( String jsonFile ) throws IOException {
        Engagement engagement = getJsonData( Engagement.class, jsonFile );
        return engagement;
    }

    protected static <T> String getJsonString( Class<T> clazz, String jsonFile ) {
        String json = null;
        try {
            Object obj = getJsonData( clazz, jsonFile );
            json = mapper.writeValueAsString( obj );
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        return json;

    }

    protected static  <T> T getJsonData( Class<T> clazz, String jsonFile ) throws JsonParseException, JsonMappingException, IOException {
        InputStream stream = ObjectMother.class.getClassLoader().getResourceAsStream( jsonFile );
        T data = mapper.readValue( stream, clazz );
        return data;
    }

}
