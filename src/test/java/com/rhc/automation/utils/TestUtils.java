package com.rhc.automation.utils;

import com.rhc.automation.jenkinsfile.PipelineDialect;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
    public static final String APPLICATION_NAME = "cool-application-name";
    public static final String NO_BUILD_TOOL_FILE = "engagements/singleClusterMultiProjectNoBuildTool.json";
    public static final String S2I_BUILD_FILE = "engagements/singleClusterMultiProjectWithS2I.json";
    public static final String CUSTOM_BUILD_IMAGE_FILE = "engagements/singleClusterMultiProjectWithCustomBuildImageCommands.json";
    public static final String MVN_BUILD_FILE = "engagements/singleClusterMultiProjectWithMvn.json";
    public static final String FABRIC8_BUILD_FILE = "engagements/singleClusterMultiProjectWithFabric8.json";
    public static final String UNSUPPORTED_BUILD_TOOL_FILE = "engagements/singleClusterMultiProjectWithUnsupportedBuildTool.json";
    public static final String LABS_ENV_FILE = "engagements/labs-env.json";


    public static String getPipelineScriptFromFileWithoutWhitespace( String fileName, PipelineDialect dialect ) throws IOException {
        switch ( dialect ) {
            case JENKINSFILE_ORIGINAL:
                return removeWhiteSpace( getJenkinsfileOriginalPipelineScriptFromFile( fileName ) );
            case JENKINSFILE_DECLARATIVE:
                return removeWhiteSpace( getJenkinsfileDeclativePipelineScriptFromFile( fileName ) );
            default:
                return removeWhiteSpace( getJenkinsfileOriginalPipelineScriptFromFile( fileName ) );
        }
    }

    public static String getJenkinsfileOriginalPipelineScriptFromFile( String fileName ) throws IOException {
        return IOUtils.toString( TestUtils.class.getClassLoader().getResourceAsStream( "jenkinsfile/original/" + fileName ) );
    }

    public static String getJenkinsfileDeclativePipelineScriptFromFile( String fileName ) throws IOException {
        return IOUtils.toString( TestUtils.class.getClassLoader().getResourceAsStream( "jenkinsfile/declarative/" + fileName ) );
    }

    public static String removeWhiteSpace( String input ) {
        return input.replaceAll( "\\s+", "" );
    }

    public static String getStringFromFile( String fileName ) throws IOException {
        InputStream stream = TestUtils.class.getClassLoader().getResourceAsStream( fileName );
        if ( stream == null ) {
            throw new RuntimeException( "could not find file: " + fileName );
        }
        return IOUtils.toString( stream );
    }
}
