package com.rhc.automation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.Customer;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.ImageRegistry;
import com.rhc.automation.model.OpenshiftCluster;
import com.rhc.automation.model.OpenshiftResources;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;
import com.rhc.automation.service.ImageRegistryRepository;
import com.rhc.automation.service.OpenshiftClusterRepository;
import com.rhc.automation.service.OpenshiftResouresRepository;
import com.rhc.automation.service.ProjectRepository;
import com.rhc.automation.service.ApplicationRepository;
import com.rhc.automation.service.CustomerRepository;
import com.rhc.automation.service.UserService;
import com.rhc.automation.service.EngagementRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.rhc.automation")
public class Swagger2SpringBoot implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Swagger2SpringBoot.class);

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    @Bean
    public CommandLineRunner startUp(UserService userService, ImageRegistryRepository imageRegistryRepository,
            ApplicationRepository applicationRepository, ProjectRepository projectRepository,
            OpenshiftResouresRepository openshiftResourcesRepository, 
            OpenshiftClusterRepository openshiftClusterRepository, EngagementRepository engagementRepository,
            CustomerRepository customerRepository) {
        return (args) -> {
            User user = new User();
            user.setEmail("kevin@mcanoy.com");
            user.setFirstName("Kevin");
            user.setLastName("mcanoy");
            userService.addUser(user);

            PageRequest pageRequest = new PageRequest(0, 100);
            
            for (User foundUser : userService.getUsers(pageRequest).getContent()) {
                log.info(foundUser.toString());
            }

            Role role = new Role();
            role.setName("Admin");

            userService.addRole(role);

            Role anotherRole = new Role();
            anotherRole.setName("Editor");

            userService.addRole(anotherRole);

            for (Role foundRole : userService.getRoles(pageRequest)) {
                log.info(foundRole.toString());
            }

            RoleMapping userRole = new RoleMapping();
            userRole.setUser(user);
            userRole.addRolesItem(role);
            userRole.addRolesItem(anotherRole);

            userService.addRoleMapping(userRole);

            for (RoleMapping foundRoles : userService.getRoleMappings(pageRequest)) {
                log.info(foundRoles.toString());
            }

            ImageRegistry imageRegistry = new ImageRegistry();
            imageRegistry.setHost("http://www.mcanoy.com");

            imageRegistryRepository.save(imageRegistry);

            for (ImageRegistry im : imageRegistryRepository.findAll()) {
                log.info(im.toString());
            }

            Application application = new Application();
            application.setBaseImage("baseimage");
            application.setBaseImageTag("basetag");
            application.setContextDir("contextDir");
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

            applicationRepository.save(application);

            for (Application foundApp : applicationRepository.findAll()) {
                log.info(foundApp.toString());
            }
            
            Project project = new Project();
            project.setName("basicName");
            project.setDisplayName("Display Name");
            project.setBuildEnvironment(true);
            project.setPromotionEnvironment(false);
            List<Application> apps = new ArrayList<>();
            apps.add(application);
            project.setApps(apps);
            List<RoleMapping> roles = new ArrayList<>();
            roles.add(userRole);
            project.setUserToRole(roles);
            
            projectRepository.save(project);
            
            for(Project foundProject : projectRepository.findAll()) {
                log.info(foundProject.toString());
            }
            
            OpenshiftResources openshiftResource = new OpenshiftResources();
            openshiftResource.addProjectsItem(project);
            
            openshiftResourcesRepository.save(openshiftResource);
            
            for(OpenshiftResources foundResource : openshiftResourcesRepository.findAll()) {
                log.info(foundResource.toString());
            }
            
            OpenshiftCluster openshiftCluster = new OpenshiftCluster();
            openshiftCluster.setLabels(labels);
            openshiftCluster.setImageRegistry(imageRegistry);
            openshiftCluster.setOpenshiftHostEnv("env1");
            openshiftCluster.setOpenshiftResourcesToCreate(openshiftResource);
            
            openshiftClusterRepository.save(openshiftCluster);
            
            for(OpenshiftCluster foundCluster : openshiftClusterRepository.findAll()) {
                log.info(foundCluster.toString());;
            }
            
            Engagement engagement = new Engagement();
            engagement.setEndDate(LocalDate.now().plusWeeks(8));
            engagement.setStartDate(LocalDate.now());
            engagement.setName("firstengage");
            List<OpenshiftCluster> clusterList = new ArrayList<>();
            clusterList.add(openshiftCluster);
            engagement.setOpenshiftCluster(clusterList);
            List<User> team = new ArrayList<>(1);
            team.add(user);
            engagement.setTeam(team);
            
            engagementRepository.save(engagement);
            
            for(Engagement foundEngagement : engagementRepository.findAll()) {
                log.info(foundEngagement.toString());
            }
            
            Customer customer = new Customer();
            List<Engagement> engagementList = new ArrayList<>();
            engagementList.add(engagement);
            customer.setEngagements(engagementList);
            customer.setName("YBD-IT");
            
            customerRepository.save(customer);
            
            for(Customer foundCustomer : customerRepository.findAll()) {
                log.info(foundCustomer.toString());
            }
            
        };
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}