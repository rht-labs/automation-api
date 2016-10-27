package com.rhc.automation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rhc.automation.api.NotFoundException;
import com.rhc.automation.model.OpenShiftResources;
import com.rhc.automation.model.PVCAssociation;
import com.rhc.automation.model.PersistentVolume;
import com.rhc.automation.model.PersistentVolumeClaim;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.Application;
import com.rhc.automation.model.GroupRoleMapping;
import com.rhc.automation.model.LabelSelector;
import com.rhc.automation.model.OpenShiftCluster;

@Component("openshiftService")
@Transactional
public class OpenShiftServiceImpl implements OpenShiftService {

    private OpenShiftResouresRepository openShiftResourcesRespository;
    private OpenShiftClusterRepository openShiftClusterRepository;
    private ProjectRepository projectRepository;
    private ApplicationRepository applicationRepository;
    private PVCAssociationRepository pvcAssRepository;
    private PersistentVolumeClaimRepository pvcRepository;
    private PersistentVolumeRepository pvRepository;
    private ClaimTypeRepository claimTypeRepository;
    private LabelSelectorRepository labelSelectorRepository;
    
    private UserService userService;
    
    public OpenShiftServiceImpl(OpenShiftResouresRepository openshiftResourcesRespository,
            OpenShiftClusterRepository openshiftClusterRepository, ProjectRepository projectRepository, ApplicationRepository applicationRepository,
            PVCAssociationRepository pvcAssRepository, ClaimTypeRepository claimTypeRepository, LabelSelectorRepository labelSelectorRepository, 
            PersistentVolumeClaimRepository pvcRepository, PersistentVolumeRepository pvRepository, UserService userService) {
        this.openShiftResourcesRespository = openshiftResourcesRespository;
        this.openShiftClusterRepository = openshiftClusterRepository;
        this.projectRepository = projectRepository;
        this.applicationRepository = applicationRepository;
        this.pvcAssRepository = pvcAssRepository;
        this.pvcRepository = pvcRepository;
        this.pvRepository = pvRepository;
        this.userService = userService;
        this.claimTypeRepository = claimTypeRepository;
        this.labelSelectorRepository = labelSelectorRepository;
    }
    
    @Override
    public void addOpenShiftResources(OpenShiftResources openShiftResources) {
        
        for(Project project : openShiftResources.getProjects()) {
            if(project.getId() == null || project.getId() == 0) {
                project.setId(null);
                addProject(project);
            }
            
        }
        
        openShiftResourcesRespository.save(openShiftResources);
    }

    @Override
    public void updateOpenShiftResources(OpenShiftResources openShiftResources) {
        OpenShiftResources current = openShiftResourcesRespository.findOne(openShiftResources.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("OpenShiftResources with id %d, not found", openShiftResources.getId()));
        }
        
        openShiftResourcesRespository.save(current);
    }

    @Override
    public void deleteOpenShiftResources(Long openshiftResourcesId) {
        openShiftResourcesRespository.delete(openshiftResourcesId);
        
    }

    @Override
    public OpenShiftResources getOpenShiftResources(Long openshiftResourcesId) {
        return openShiftResourcesRespository.findOne(openshiftResourcesId);
    }

    @Override
    public Page<OpenShiftResources> getOpenShiftResources(Pageable pager) {
        return openShiftResourcesRespository.findAll(pager);
    }

    @Override
    public void addOpenShiftCluster(OpenShiftCluster openShiftCluster) {
        
        OpenShiftResources resources = openShiftCluster.getOpenshiftResources();
        if(resources != null && (resources.getId() == null ||  resources.getId() == 0)) {
            resources.setId(null);
            addOpenShiftResources(resources);
        }
        
        if(!openShiftCluster.getPersistentVolumes().isEmpty()) {
            pvRepository.save(openShiftCluster.getPersistentVolumes());
        }
        
        
        openShiftClusterRepository.save(openShiftCluster);
    }

    @Override
    public void updateOpenShiftCluster(OpenShiftCluster openshiftCluster) {
        OpenShiftCluster current = openShiftClusterRepository.findOne(openshiftCluster.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("OpenShiftCluster with id %d, not found", openshiftCluster.getId()));
        }
        
        openShiftClusterRepository.save(openshiftCluster);
    }

    @Override
    public void deleteOpenShiftCluster(Long openshiftClusterId) {
        openShiftClusterRepository.delete(openshiftClusterId);
    }

    @Override
    public OpenShiftCluster getOpenShiftCluster(Long openshiftClusterId) {
        return openShiftClusterRepository.findOne(openshiftClusterId);
    }

    @Override
    public Page<OpenShiftCluster> getOpenShiftCluster(Pageable pager) {
        return openShiftClusterRepository.findAll(pager);
    }
    
    @Override
    public void addProject(Project project) {
        for(Application application : project.getApps()) {
            if(application.getId() == null || application.getId() == 0) {
                application.setId(null);
                addApplication(application);
            }
        }
        
        for(GroupRoleMapping groupRoleMapping : project.getGroupToRole()) {
            if(groupRoleMapping.getId() == null || groupRoleMapping.getId() == 0) {
                groupRoleMapping.setId(null);
                userService.addGroupMapping(groupRoleMapping);
            }
        }
        
        for(RoleMapping roleMapping : project.getUserToRole()) {
            if(roleMapping.getId() == null || roleMapping.getId() == 0) {
                roleMapping.setId(null);
                userService.addRoleMapping(roleMapping);
            }
        }
        
        for(PersistentVolumeClaim pvc :project.getPersistentVolumeClaims()) {
            if(pvc.getSelector() != null) {
                labelSelectorRepository.save(pvc.getSelector());
            }
            pvcRepository.save(pvc);
        }
        
        projectRepository.save(project);
        
    }

    @Override
    public void updateProject(Project project) {
        Project current = projectRepository.findOne(project.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Project with id %d, not found", project.getId()));
        }
        
        projectRepository.save(project);
        
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.delete(projectId);
        
    }

    @Override
    public Project getProject(Long projectId) {
        return projectRepository.findOne(projectId);
    }

    @Override
    public Page<Project> getProjects(Pageable pager) {
        return projectRepository.findAll(pager);
    }
    
    @Override
    public void addApplication(Application application) {
        for(PVCAssociation pvc : application.getPvcAssociations()) {
            if(pvc.getClaimType() != null) {
                claimTypeRepository.save(pvc.getClaimType());
            }
            pvcAssRepository.save(pvc);
        }
        applicationRepository.save(application);
    }

    @Override
    public void updateApplication(Application application) {
        Application current = applicationRepository.findOne(application.getId());
        
        if(current == null) {
            throw new NotFoundException(404, String.format("Application with id %d, not found", application.getId()));
        }
        
        applicationRepository.save(current);
    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.delete(applicationId);
        
    }

    @Override
    public Application getApplication(Long applicationId) {
        return applicationRepository.findOne(applicationId);
    }

    @Override
    public Page<Application> getApplications(Pageable pager) {
        return applicationRepository.findAll(pager);
    }

}
