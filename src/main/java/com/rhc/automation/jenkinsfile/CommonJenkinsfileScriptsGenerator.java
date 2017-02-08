/*
 * Copyright (C) 2016 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rhc.automation.jenkinsfile;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.Project;

import java.util.List;

public class CommonJenkinsfileScriptsGenerator {

    public static String createCodeCheckoutScript() {
        return "checkout scm";
    }

    public static String createBuildAppScript( final Application app ) {
        StringBuilder script = new StringBuilder();
        if ( app.getContextDir() == null || app.getContextDir().isEmpty() ) {
            script.append( createBuildCommands( app ) );
        } else {
            script.append( "  dir( '" ).append( app.getContextDir() ).append( "' ) {\n  " );
            script.append( createBuildCommands( app ) );
            script.append( "  }\n" );
        }
        return script.toString();
    }

    public static String createBuildImageScript( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        Application app = engagement.getApplicationFromBuildProject( applicationName );
        if ( isS2IBinaryBuild( app ) ) {
            script.append( "    echo 'Found label \"provider=fabric8\" or \"s2i=binary\", we are generating the s2i binary build commands'\n" );
            script.append( String.format( "    sh 'oc login %s --token=\"${env.OPENSHIFT_API_TOKEN}\" --insecure-skip-tls-verify'%n", engagement.getBuildCluster().getOpenshiftHostEnv() ) );
            script.append( String.format( "    sh 'oc start-build %s --from-dir=. --follow -n %s'", applicationName, engagement.getBuildProjectForApplication( applicationName ).getName() ) );
        } else if ( app.getBuildImageCommands() == null || app.getBuildImageCommands().isEmpty() ) {
            script.append( "    echo 'No buildImageCommands, using default OpenShift image build and deploy'\n" );
            script.append( createDefaultOpenShiftBuildAndDeployScript( engagement, applicationName ) );
        } else {
            script.append( "    echo 'Found buildImageCommands, executing in shell'\n" );
            List<String> commands = app.getBuildImageCommands();
            for ( String command : commands ) {
                script.append( "  sh '" ).append( command ).append( "' \n" );
            }
        }
        return script.toString();
    }

    public static String createPromotionStageScript( final Engagement engagement, final OpenShiftCluster destCluster,
                                                     final Project destProject, final OpenShiftCluster srcCluster, final Project srcProject, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        script.append( "    input 'Deploy to " ).append( destProject.getName() ).append( "?'\n" );

        Application app = engagement.getApplicationFromBuildProject( applicationName );

        if ( app.getDeployImageCommands() == null || app.getDeployImageCommands().isEmpty() ) {

            // TODO this where we can support image tags that aren't latest
            script.append( String.format(
                    "    openshiftTag apiURL: '%s', authToken: \"${env.OPENSHIFT_API_TOKEN}\", destStream: '%s', destTag: 'latest', destinationAuthToken: \"${env.OPENSHIFT_API_TOKEN}\", destinationNamespace: '%s', namespace: '%s', srcStream: '%s', srcTag: 'latest'%n",
                    srcCluster.getOpenshiftHostEnv(), applicationName, destProject.getName(), srcProject.getName(),
                    applicationName ) );
            script.append( String.format(
                    "    openshiftVerifyDeployment apiURL: '%s', authToken: \"${env.OPENSHIFT_API_TOKEN}\", depCfg: '%s', namespace: '%s'%n",
                    srcCluster.getOpenshiftHostEnv(), applicationName, destProject.getName() ) );

        } else {
            for ( String command : app.getDeployImageCommands() ) {
                script.append( "  sh '" ).append( command ).append( "' \n" );
            }
        }

        return script.toString();
    }

    public static String createBuildCommands( final Application app ) {
        StringBuilder script = new StringBuilder();

        if ( GeneratorConstants.SUPPORTED_BUILD_TOOLS.contains( app.getBuildTool() ) ) {
            script.append( "    echo 'Using build tool: " ).append( app.getBuildTool() ).append( "'\n" );
            script.append( createListOfShellCommandsScript( app, app.getBuildTool() ) );
        } else {
            throw new RuntimeException(
                    app.getBuildTool() + " is currently unsupported. Please select one of " + GeneratorConstants.SUPPORTED_BUILD_TOOLS );
        }

        return script.toString();
    }

    public static String createListOfShellCommandsScript( final Application app, final String tool ) {
        StringBuilder script = new StringBuilder();

        if ( app.getBuildApplicationCommands() == null || app.getBuildApplicationCommands().isEmpty() ) {
            if ( app.getBuildTool().equals( "s2i" ) ) {
                // do nothing. s2i should not have build commands
                // worth mentioning here that I realize s2i is broad. we're
                // covering the case of just s2i assemble, like with Jenkins. if
                // you have a better naming convention, feel free to open a PR
            } else {
                // but every other build tool should
                throw new RuntimeException( "app.buildApplicationCommands cannot be empty" );
            }

        } else {
            if ( app.getBuildTool().equals( "s2i" ) ) {
                throw new RuntimeException( "s2i builds should not have build commands" );
            }
            if ( !tool.equals( "sh" ) ) {
                script.append( "    def toolHome = tool '" ).append( tool ).append( "'\n" );
                if ( tool.contains( "mvn" ) ) {
                    script.append( "    env.JAVA_HOME = tool 'java-1.8'\n" );
                }
            }
            List<String> commands = app.getBuildApplicationCommands();
            for ( String command : commands ) {
                script.append( "    sh \"" );
                if ( !tool.equals( "sh" ) ) {
                    script.append( "${toolHome}/bin/" );
                }
                script.append( command ).append( "\"\n" );
            }

        }

        return script.toString();
    }

    public static String createDefaultOpenShiftBuildAndDeployScript( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();

        Project buildProject = engagement.getBuildProjectForApplication( applicationName );
        OpenShiftCluster buildProjectCluser = engagement.getClusterWithBuildProject();

        script.append( String.format(
                "    openshiftBuild apiURL: '%s', authToken: \"${env.OPENSHIFT_API_TOKEN}\", bldCfg: '%s', checkForTriggeredDeployments: 'true', namespace: '%s', showBuildLogs: 'true'%n",
                buildProjectCluser.getOpenshiftHostEnv(), applicationName, buildProject.getName() ) );

        script.append( String.format(
                "    openshiftVerifyDeployment apiURL: '%s', authToken: \"${env.OPENSHIFT_API_TOKEN}\", depCfg: '%s', namespace: '%s'%n",
                buildProjectCluser.getOpenshiftHostEnv(), applicationName, buildProject.getName() ) );

        return script.toString();
    }

    public static boolean isS2IBinaryBuild( final Application app ) {
        if ( app.getLabels().containsKey( "provider" ) && app.getLabels().get( "provider" ).equals( "fabric8" ) ) {
            return true;
        }
        if ( app.getLabels().containsKey( "s2i" ) && app.getLabels().get( "s2i" ).equals( "binary" ) ) {
            return true;
        }

        return false;
    }
}
