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

public class ReleasePipelineOriginalJenkinsfileGenerator implements ReleasePipelineDialectSpecificGenerator {

    @Override
    public String initializeScript() {
        StringBuilder script = new StringBuilder();
        script.append( "node {\n" );
        return script.toString();
    }

    @Override
    public String generateCodeCheckoutStage( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        script.append( "  stage ('Code Checkout') {\n " );
        script.append( String.format( "    %s\n", CommonJenkinsfileScriptsGenerator.createCodeCheckoutScript() ) );
        script.append( "  }\n\n" );
        return script.toString();
    }

    @Override
    public String generateBuildAppStage( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        Application app = engagement.getApplicationFromBuildProject( applicationName );

        // s2i builds here assume there is no app build, only a container image build
        if ( app.getBuildTool().equals( "s2i" ) ) {
            return script.toString();
        }

        script.append( "  stage ('Build App') {\n" );
        script.append( CommonJenkinsfileScriptsGenerator.createBuildAppScript( app ) );
        script.append( "  }\n\n" );
        return script.toString();
    }

    @Override
    public String generateBuildImageAndDeployToDevStage( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        script.append( "\n  stage ('Build Image and Deploy to Dev') {\n" );
        script.append( String.format( "      %s", CommonJenkinsfileScriptsGenerator.createBuildImageScript( engagement, applicationName ) ) );
        script.append( "  }\n" );
        return script.toString();
    }

    @Override
    public String generateAllPromotionStages( final Engagement engagement, final String applicationName ) {
        StringBuilder script = new StringBuilder();
        OpenShiftCluster srcCluster = engagement.getBuildCluster();
        Project srcProject = engagement.getBuildProjectForApplication( applicationName );

        for ( OpenShiftCluster cluster : engagement.getOpenshiftClusters() ) {
            for ( Project project : engagement.getPromotionProjectsForApplication( applicationName ) ) {
                script.append( "\n  stage ('Deploy to " ).append( project.getName() ).append( "') {\n" );
                script.append( String.format( "      %s", CommonJenkinsfileScriptsGenerator.createPromotionStageScript( engagement, cluster, project, srcCluster, srcProject, applicationName ) ) );
                script.append( "  }\n" );
                srcProject = project;
            }
            srcCluster = cluster;
        }
        return script.toString();
    }


    @Override
    public String finalizeScript() {
        StringBuilder script = new StringBuilder();

        script.append( "}\n" );
        return script.toString();
    }
}
