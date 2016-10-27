package com.rhc.automation.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.PVCAssociation;
import com.rhc.automation.model.PersistentVolumeClaim;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.Route;

public class EngagementIntegrationTest extends BaseIntegrationTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private EngagementRepository engagementRepository;

    @Test
    public void saveEngagementLegit() throws Exception {
        
        Engagement engagement = createEngagement();
        
        engagementRepository.save(engagement);
        
        Assert.assertNotNull("Engagement was not saved", engagement.getId());
        
    }
    
    @Test
    public void getEngagements() throws Exception {
        Engagement engagementsave = createEngagement();
        entityManager.persist(engagementsave);
        
        PageRequest pageRequest = new PageRequest(0, 10);
        
        Page<Engagement> engagements = engagementRepository.findAll(pageRequest);
        
        Assert.assertEquals(1, engagements.getContent().size());
        
        Long id = engagements.getContent().get(0).getId();
        
        Engagement engagement = engagementRepository.findOne(id);
        
        Assert.assertNotNull("Should have found an engagment by id", engagement);
        
        Assert.assertEquals(id, engagement.getId());
        
        Assert.assertEquals("No OpenShift Cluster", 1, engagement.getOpenshiftClusters().size());
        Assert.assertNotNull("No OpenShift Resource", engagement.getOpenshiftClusters().get(0).getOpenshiftResources());
        
        List<Project> projects = engagement.getOpenshiftClusters().get(0).getOpenshiftResources().getProjects();
        Assert.assertNotNull("No Project", projects);
        Assert.assertEquals("There should be 9 project", 9, projects.size());
        
        List<Application> apps = projects.get(0).getApps();
        Assert.assertNotNull("No Apps", apps);
        Assert.assertEquals("There should be 2 app", 1, apps.size());
        
        List<PVCAssociation> pvcAssociations = apps.get(0).getPvcAssociations();
        Assert.assertNotNull("No PVC Assocations", pvcAssociations);
        Assert.assertEquals("There should be 2 PVC Associations", 2, pvcAssociations.size());
        
        List<PersistentVolumeClaim> pvcs = projects.get(0).getPersistentVolumeClaims();
        Assert.assertNotNull("No persistent volume claims");
        Assert.assertEquals("there should be 2 persistent volume claims", 2, pvcs.size());
        
    }
    
    public Engagement createEngagement() throws Exception {
        Engagement eng = getJsonData(Engagement.class, "/deep_engagement.json");
        return eng;
    }
}
