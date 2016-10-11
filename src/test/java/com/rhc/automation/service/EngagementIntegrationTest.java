package com.rhc.automation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.EdgeRoute;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.OpenShiftResources;
import com.rhc.automation.model.Port;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.Route;
import com.rhc.automation.model.User;
import com.rhc.automation.model.Route.RouteTypeEnum;
import com.rhc.automation.model.Service;

public class EngagementIntegrationTest extends BaseIntegrationTest {
    
    @Autowired
    private EngagementRepository engagementRepository;

    @Test
    public void saveEngagementLegit() {
        
        Engagement engagement = createEngagement();
        
        engagementRepository.save(engagement);
        
        Assert.assertNotNull("Engagement was not saved", engagement.getId());
        
    }
    
    @Test
    public void getEngagements() {
        Engagement engagementsave = createEngagement();
        engagementRepository.save(engagementsave);
        
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
        Assert.assertEquals("There should be 1 project", 1, projects.size());
        
        List<Application> apps = projects.get(0).getApps();
        Assert.assertNotNull("No Apps", apps);
        Assert.assertEquals("There should be 1 app", 1, apps.size());
        
        List<Route> routes = apps.get(0).getRoutes();
        Assert.assertNotNull("No Routes", apps);
        Assert.assertEquals("There should be 1 route", 1, routes.size());
        
        Route route = routes.get(0);
        Assert.assertEquals("Improper Route", route.getRouteType(), Route.RouteTypeEnum.EDGE);
        Assert.assertEquals("Improper Hostname on route", "erhostname", route.getHostname());
        
        
        
    }
    
    private Engagement createEngagement() {
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
        
        Port port = new Port();
        port.setPort(8080);
        port.setProtocol("tcp");
        port.setTargetPort(80);
        
        List<Port> portList = new ArrayList<>();
        portList.add(port);
        
        Service service = new Service();
        service.setPorts(portList);
        
        EdgeRoute edgeRoute = new EdgeRoute();
        edgeRoute.setCaCert("caCert");
        edgeRoute.setCert("cert");
        edgeRoute.setHostname("erhostname");
        edgeRoute.setInsecurePolicy("insecure");
        edgeRoute.setKey("key");
        edgeRoute.setName("name");
        edgeRoute.setPath("path");
        edgeRoute.setPort(99);
        edgeRoute.setRouteType(RouteTypeEnum.EDGE);
        edgeRoute.setService(service);

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
        application.addRoutesItem(edgeRoute);
        
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
        
        Engagement engagement = new Engagement();
        engagement.setEndDate(LocalDate.now().plusWeeks(8));
        engagement.setStartDate(LocalDate.now());
        engagement.setName("firstengage");
        engagement.addOpenshiftClustersItem(openShiftCluster);
        List<User> team = new ArrayList<>(1);
        team.add(user);
        engagement.setTeam(team);
        
        return engagement;
    }
}
