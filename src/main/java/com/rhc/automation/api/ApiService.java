package com.rhc.automation.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.rhc.automation.model.Application;
import com.rhc.automation.model.AutomationModel;
import com.rhc.automation.model.Customer;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.OpenShiftCluster;
import com.rhc.automation.model.Project;
import com.rhc.automation.model.Role;
import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.model.User;
import com.rhc.automation.service.CustomerService;
import com.rhc.automation.service.OpenShiftService;
/**
 * The APIs that we are building all call the same actions. Add, Update, Delete, Get, Get List. Since they are functionally 
 * very similar we can put the reusable code here and distinguish by class type. This will leave the generated code only
 * minimally altered
 * 
 * Model objs needs to implement AutomationModel class
 * @author kmcanoy
 *
 */
import com.rhc.automation.service.UserService;
@Component("apiService")
public class ApiService {
    Logger LOG = LoggerFactory.getLogger(ApiService.class);

    private OpenShiftService openShiftService;
    private CustomerService customerService;
    private UserService userService;
    
    @Value("${automation.global.default.pagesize}")
    private Integer defaultPageSize;
    
    public ApiService(OpenShiftService openShiftService, CustomerService customerService, UserService userService) {
        this.openShiftService = openShiftService;
        this.customerService = customerService;
        this.userService = userService;
    }
    
    public ResponseEntity<Void> add(AutomationModel model) {
        LOG.debug("Adding model: {}", model);
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.OK);

        if (model.getId() == null) {
            String path = findServiceAndAdd(model);

            UriComponents uriComponents = UriComponentsBuilder.newInstance().path(path)
                    .buildAndExpand(model.getId());

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());
            response = new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        return response;
    } 
    
    public ResponseEntity<Void> update(Long id, AutomationModel model) {
        
        HttpStatus status = HttpStatus.OK;
        
        if(model.getId().longValue() != id.longValue()) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            try {
                findServiceAndUpdate(model);
            } catch (NotFoundException nfe) {
                status = HttpStatus.NOT_FOUND;
            } catch (ValidationException ve) {
                status = HttpStatus.METHOD_NOT_ALLOWED;
            }
        }
        return new ResponseEntity<Void>(status);
    }
    
    public <T> ResponseEntity<Void> delete(Class<T> type, Long id) {

        HttpStatus status = HttpStatus.OK;
        AutomationModel model = findServiceAndGet(type, id);

        if (model == null) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            findServiceAndDelete(type, id);
        }

        return new ResponseEntity<Void>(status);
    }
    
    public <T> ResponseEntity<T> get(Long id,  Class<T> klazz) {
        AutomationModel model = findServiceAndGet(klazz, id);
        
        HttpStatus status = HttpStatus.OK;
        
        if(model == null) {
            status = HttpStatus.NOT_FOUND;
        }
        
        return new ResponseEntity<T>(klazz.cast(model), status);
    }

    public <T extends AutomationModel> List<T> getList(Integer size, Long offset, Class<T> klazz) {
        
        if(offset == null) {
            offset = 0L;
        }
        
        if(size == null) {
            size = defaultPageSize;
        }

        PageRequest pageRequest = new PageRequest(offset.intValue(), size);
        
        return findServiceAndGetList(pageRequest, klazz);
    }
    
    private <T> List<T> findServiceAndGetList(PageRequest pageRequest, Class<T> type) {
        
        List<T> modelList = new ArrayList<>();
        
        if(type == Application.class) {
            Page<Application> applicationPage = openShiftService.getApplications(pageRequest);
            for(Application app : applicationPage.getContent()) {
                modelList.add(type.cast(app));
            }   
        } else if(type == OpenShiftCluster.class) {
            Page<OpenShiftCluster> clusterPage = openShiftService.getOpenShiftCluster(pageRequest);
            for(OpenShiftCluster cluster : clusterPage.getContent()) {
                modelList.add(type.cast(cluster));
            }   
        } else if(type == Project.class) {
            Page<Project> projectPage = openShiftService.getProjects(pageRequest);
            for(Project project : projectPage.getContent()) {
                modelList.add(type.cast(project));
            }   
        } else if(type == Customer.class) {
            Page<Customer> customerPage = customerService.getCustomers(pageRequest);
            for(Customer customer : customerPage.getContent()) {
                modelList.add(type.cast(customer));
            }   
        } else if(type == Engagement.class) {
            Page<Engagement> engagementPage = customerService.getEngagements(pageRequest);
            for(Engagement engagement : engagementPage.getContent()) {
                modelList.add(type.cast(engagement));
            }   
        } else if(type == Role.class) {
            Page<Role> rolePage = userService.getRoles(pageRequest);
            for(Role role : rolePage.getContent()) {
                modelList.add(type.cast(role));
            }   
        } else if(type == User.class) {
            Page<User> userPage = userService.getUsers(pageRequest);
            for(User user : userPage.getContent()) {
                modelList.add(type.cast(user));
            }   
        } else if(type == RoleMapping.class) {
            Page<RoleMapping> roleMappingPage = userService.getRoleMappings(pageRequest);
            for(RoleMapping roleMapping : roleMappingPage.getContent()) {
                modelList.add(type.cast(roleMapping));
            }   
        }
        
        return modelList;
    }
    
    private void findServiceAndUpdate(AutomationModel model) throws NotFoundException, ValidationException {
        
        if(model instanceof Application) {
            openShiftService.updateApplication((Application) model);
        } else if(model instanceof OpenShiftCluster) {
            openShiftService.updateOpenShiftCluster((OpenShiftCluster) model);
        } else if(model instanceof Project) {
            openShiftService.updateProject((Project) model);
        } else if(model instanceof Customer) {
            customerService.updateCustomer((Customer) model);
        } else if(model instanceof Engagement) {
            customerService.updateEngagement((Engagement) model);
        } else if(model instanceof Role) {
            userService.updateRole((Role) model);
        } else if(model instanceof User) {
            userService.updateUser((User) model);
        } else if(model instanceof RoleMapping) {
            userService.updateRoleMapping((RoleMapping) model);
        }
    }
    
    private String findServiceAndAdd(AutomationModel model) {
        String location = "";
        
        if(model instanceof Application) {
            openShiftService.addApplication((Application) model);
            location = "/applications/{id}";
        } else if(model instanceof OpenShiftCluster) { 
            openShiftService.addOpenShiftCluster((OpenShiftCluster) model);
            location = "/openshift_clusters/{id}";
        } else if(model instanceof Project) { 
            openShiftService.addProject((Project) model);
            location = "/projets/{id}";
        } else if(model instanceof Customer) {
            customerService.addCustomer((Customer) model);
            location = "/customers/{id}";
        } else if(model instanceof Engagement) {
            customerService.addEngagement((Engagement) model);
            location = "/engagements/{id}";
        } else if(model instanceof Role) {
            userService.addRole((Role) model);
            location = "/roles/{id}";
        } else if(model instanceof User) {
            userService.addUser((User) model);
            location = "/users/{id}";
        } else if(model instanceof RoleMapping) {
            userService.addRoleMapping((RoleMapping) model);
            location = "role_mappings/{id}";
        }
        
        return location;
    }
    
    private AutomationModel findServiceAndGet(Class<?> type, Long id) {
        AutomationModel model = null;
        
        if(type == Application.class) {
            model = openShiftService.getApplication(id);
        } else if(type == OpenShiftCluster.class) { 
            model = openShiftService.getOpenShiftCluster(id);
        } else if(type == Project.class) { 
            model = openShiftService.getProject(id);
        } else if(type == Customer.class) {
            model = customerService.getCustomer(id);
        } else if(type == Engagement.class) {
            model = customerService.getEngagement(id);
        } else if(type == Role.class) {
            model = userService.getRole(id);
        } else if(type == User.class) {
            model = userService.getUser(id);
        } else if(type == RoleMapping.class) {
            model = userService.getRoleMapping(id);
        }
        
        return model;
    }
    
    private <T> void findServiceAndDelete(Class<T> type, Long id) {
        
        if(type == Application.class) {
            openShiftService.deleteApplication(id);
        } else if(type == OpenShiftCluster.class) {
            openShiftService.deleteOpenShiftCluster(id);
        } else if(type == Project.class) {
            openShiftService.deleteProject(id);
        } else if(type == Customer.class) {
            customerService.deleteCustomer(id);
        } else if(type == Engagement.class) {
            customerService.deleteEngagement(id);
        } else if(type == Role.class) {
            userService.deleteRole(id);
        } else if(type == User.class) {
            userService.deleteUser(id);
        } else if(type == RoleMapping.class) {
            userService.deleteRoleMapping(id);
        }
        
    }
}
