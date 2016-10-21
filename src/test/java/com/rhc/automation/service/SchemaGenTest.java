package com.rhc.automation.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rhc.automation.Swagger2SpringBoot;

import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
@TestPropertySource(locations="classpath:schema_gen.properties")
@Ignore
public class SchemaGenTest {

    @MockBean
    private DocumentationPluginsBootstrapper documentationPluginsBootstrapper;
    
    @MockBean
    private WebMvcRequestHandlerProvider webMvcRequestHandlerProvider;
    
    @MockBean
    private Swagger2SpringBoot swagger2SpringBoot;
    
    /**
     * just need to start spring boot and have spring.jpa.hibernate.ddl-auto=create run
     * note: in your postgres you need to drop the schema for this to work.
     * hibernate will output the ddl it generates and this can be used to update 
     * Flyway
     * Don't forget to remove the ignore annotation above
     * DROP SCHEMA automation CASCADE;
     */
    @Test
    public void generateSchema() {
        //nothing
    }
}
