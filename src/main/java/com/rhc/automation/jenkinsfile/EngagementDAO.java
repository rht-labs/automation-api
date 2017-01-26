/*
 * Copyright (C) 2016 Original Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
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
import com.rhc.automation.model.Project.EnvironmentTypeEnum;

import java.util.ArrayList;
import java.util.List;

public final class EngagementDAO {


    public static Application getApplicationFromBuildProject( final Engagement engagement, final String applicationName ) {
        for ( OpenShiftCluster cluster : engagement.getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( EnvironmentTypeEnum.BUILD ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            return app;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Project getBuildProjectForApplication( final Engagement engagement, final String applicationName ) {
        for ( OpenShiftCluster cluster : engagement.getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( EnvironmentTypeEnum.BUILD ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            return project;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static List<Project> getPromotionProjectsForApplication( final Engagement engagement, final String applicationName ) {
        List<Project> projects = new ArrayList<>();

        for ( OpenShiftCluster cluster : engagement.getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( EnvironmentTypeEnum.PROMOTION ) ) {
                    for ( Application app : project.getApps() ) {
                        if ( app.getName() != null && app.getName().equals( applicationName ) ) {
                            projects.add( project );
                        }
                    }
                }
            }
        }
        return projects;
    }


    /**
     * There should only be a single build project declared across all clusters. It is invalid to have more than one.
     */
    public static OpenShiftCluster getClusterWithBuildProject( final Engagement engagement ) {
        for ( OpenShiftCluster cluster : engagement.getOpenshiftClusters() ) {
            for ( Project project : cluster.getOpenshiftResources().getProjects() ) {
                if ( project.getEnvironmentType().equals( EnvironmentTypeEnum.BUILD ) ) {
                    return cluster;
                }
            }
        }
        return null;
    }

    public static OpenShiftCluster getBuildCluster( Engagement engagement ) {
        return engagement.getOpenshiftClusters().get( 0 );
    }
}
