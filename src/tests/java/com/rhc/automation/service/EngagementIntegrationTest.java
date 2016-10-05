package com.rhc.automation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.OpenShiftResources;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;

public class EngagementIntegrationTest extends BaseIntegrationTest {
    
    @Autowired
    private EngagementRepository engagementRepository;

    @Test
    public void saveEngagementLegit() {
        User user = new User();
        user.setEmail("chef@tophat.com");
        user.setFirstName("Chef");
        user.setLastName("Tophat");
        user.setUserName("cheffy");

        Role role = new Role();
        role.setName("Admin");

        Role anotherRole = new Role();
        anotherRole.setName("Editor");
        
        RoleMapping userRole = new RoleMapping();
        userRole.setUser(user);
        userRole.addRolesItem(role);
        userRole.addRolesItem(anotherRole);

        Application application = new Application();
        application.setBaseImage("baseimage");
        application.setBaseImageTag("basetag");
        application.addBuildApplicationCommandsItem("run");
        application.addBuildImageCommandsItem("deploy");
        application.setBuildTool("mvn");
        application.setContextDir("contextDir");
        application.addDeployImageCommandsItem("deployimage");
        application.setName("awesome");
        application.setScmRef("scmref");
        application.setScmType("scmtype");
        application.setScmUrl("http://github.com/rhc");
        
        Map<String, String> envs = new HashMap<>();
        envs.put("a", "b");
        
        Map<String, String> labels = new HashMap<>();
        labels.put("c", "d");
        
        application.setLabels(labels);
        application.setEnvironmentVariables(envs);

        Project project = new Project();
        project.setName("basicName");
        project.setDisplayName("Display Name");
        project.setBuildEnvironment(true);
        project.setPromotionEnvironment(false);
        project.addAppsItem(application);
        List<RoleMapping> roles = new ArrayList<>();
        roles.add(userRole);
        project.setUserToRole(roles);
        
        OpenShiftResources openshiftResource = new OpenShiftResources();
        openshiftResource.addProjectsItem(project);
        
        OpenShiftCluster openShiftCluster = new OpenShiftCluster();
        openShiftCluster.setLabels(labels);
        openShiftCluster.setImageRegistry("http://www.mcanoy.com");
        openShiftCluster.setOpenshiftHostEnv("env1");
        openShiftCluster.setOpenshiftResources(openshiftResource);
        openShiftCluster.setUserId(String.valueOf(user.getId()));
        
        Engagement engagement = new Engagement();
        engagement.setEndDate(LocalDate.now().plusWeeks(8));
        engagement.setStartDate(LocalDate.now());
        engagement.setName("firstengage");
        engagement.addOpenshiftClustersItem(openShiftCluster);
        List<User> team = new ArrayList<>(1);
        team.add(user);
        engagement.setTeam(team);
        
        engagementRepository.save(engagement);
        
        Assert.assertNotNull("Engagement was not saved", engagement.getId());
    }
}
