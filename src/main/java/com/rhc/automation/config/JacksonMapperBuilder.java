package com.rhc.automation.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JacksonMapperBuilder {

    public static Jackson2ObjectMapperBuilder get() {
        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
        b.propertyNamingStrategy( PropertyNamingStrategy.SNAKE_CASE );
        b.featuresToEnable( DeserializationFeature.READ_ENUMS_USING_TO_STRING, SerializationFeature.WRITE_ENUMS_USING_TO_STRING );
        b.serializationInclusion( JsonInclude.Include.NON_NULL );
        b.serializationInclusion( JsonInclude.Include.NON_EMPTY );
        b.featuresToDisable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS );
        return b;
    }
}
