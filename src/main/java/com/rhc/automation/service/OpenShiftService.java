package com.rhc.automation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.OpenShiftResources;
import com.rhc.automation.model.Project;

public interface OpenShiftService {

    void addOpenShiftResources(OpenShiftResources openshiftResource);
    void updateOpenShiftResources(OpenShiftResources openshiftResource);
    void deleteOpenShiftResources(Long openshiftResourceId);
    OpenShiftResources getOpenShiftResources(Long openshiftResourceId);
    Page<OpenShiftResources> getOpenShiftResources(Pageable pager);
    
    void addOpenShiftCluster(OpenShiftCluster openshiftCluster);
    void updateOpenShiftCluster(OpenShiftCluster openshiftCluster);
    void deleteOpenShiftCluster(Long openshiftClusterId);
    OpenShiftCluster getOpenShiftCluster(Long openshiftClusterId);
    Page<OpenShiftCluster> getOpenShiftCluster(Pageable pager);
    
    void addProject(Project project);
    void updateProject(Project project);
    void deleteProject(Long projectId);
    Project getProject(Long projectId);
    Page<Project> getProjects(Pageable pager);
    
    
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(Long applicationId);
    Application getApplication(Long applicationId);
    Page<Application> getApplications(Pageable pager);
}
