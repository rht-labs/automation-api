package com.rhc.automation.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rhc.automation.Swagger2SpringBoot;

import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.ANY)
@TestPropertySource(properties = "spring.jpa.properties.hibernate.default_schema=")
public class BaseIntegrationTest {

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
}
