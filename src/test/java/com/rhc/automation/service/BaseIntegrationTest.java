package com.rhc.automation.service;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.rhc.automation.Swagger2SpringBoot;

import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.ANY)
@TestPropertySource(properties = "spring.jpa.properties.hibernate.default_schema=")
public abstract class BaseIntegrationTest {
    
    private static ObjectMapper mapper;
    
    @BeforeClass
    public static void initJsonMapper() {
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                        .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                        .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    @MockBean
    private DocumentationPluginsBootstrapper documentationPluginsBootstrapper;
    
    @MockBean
    private WebMvcRequestHandlerProvider webMvcRequestHandlerProvider;
    
    @MockBean
    private Swagger2SpringBoot swagger2SpringBoot;
    
    @Autowired
    private TestEntityManager entityManager;
    
    public TestEntityManager getTestEntityManager() {
        return entityManager;
    }
    
    protected <T>T getJsonData(Class<T> clazz, String jsonFile) throws JsonParseException, JsonMappingException, IOException {
        InputStream stream = getClass().getResourceAsStream(jsonFile);
        T data = mapper.readValue(stream, clazz);
        return data;
    }
}
