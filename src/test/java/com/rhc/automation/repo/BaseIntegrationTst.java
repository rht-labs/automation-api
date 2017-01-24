package com.rhc.automation.repo;

import com.rhc.automation.Swagger2SpringBoot;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

/**
 * Simple naming error to avoid naming conventions for surefire/failsafe
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles({"hsql"})
@TestPropertySource(locations = "classpath:test.properties")
public class BaseIntegrationTst {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    EngagementRepository engagementRepository;
    @Autowired
    EngagementSummaryRepository engagementSummaryRepository;

    @MockBean
    private DocumentationPluginsBootstrapper documentationPluginsBootstrapper;

    @MockBean
    private WebMvcRequestHandlerProvider webMvcRequestHandlerProvider;

    @MockBean
    private Swagger2SpringBoot swagger2SpringBoot;

    @Before
    public void beforeTest() {
        engagementRepository.deleteAll();
    }
}
