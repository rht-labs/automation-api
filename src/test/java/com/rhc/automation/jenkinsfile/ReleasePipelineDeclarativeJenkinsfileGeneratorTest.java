package com.rhc.automation.jenkinsfile;

import com.rhc.automation.model.Engagement;
import com.rhc.automation.utils.ObjectMother;
import com.rhc.automation.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ReleasePipelineDeclarativeJenkinsfileGeneratorTest {

    @Test
    public void shouldCorrectlyCreateSingleClusterMultiProjectS2IBuild() throws IOException {
        // given
        Engagement engagement = ObjectMother.getEngagementFromJsonFile( TestUtils.S2I_BUILD_FILE );

        // when
        String jenkinsfile = ReleasePipelineGenerator.generate( engagement, "jenkins", PipelineDialect.JENKINSFILE_DECLARATIVE );

        // then
        Assert.assertEquals( TestUtils.getPipelineScriptFromFileWithoutWhitespace( "singleClusterScriptS2I", PipelineDialect.JENKINSFILE_DECLARATIVE ), TestUtils.removeWhiteSpace( jenkinsfile ) );

    }

    @Test
    public void shouldCorrectlyCreateSingleClusterMultiProjectScriptWithMvn() throws IOException {
        // given
        Engagement engagement = ObjectMother.getEngagementFromJsonFile( TestUtils.MVN_BUILD_FILE );

        // when
        String jenkinsfile = ReleasePipelineGenerator.generate( engagement, TestUtils.APPLICATION_NAME, PipelineDialect.JENKINSFILE_DECLARATIVE );

        // then
        Assert.assertEquals( TestUtils.getPipelineScriptFromFileWithoutWhitespace( "singleClusterScriptMvn3", PipelineDialect.JENKINSFILE_DECLARATIVE ), TestUtils.removeWhiteSpace( jenkinsfile ) );
    }
}
