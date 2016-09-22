package com.rhc.automation.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhc.automation.model.Project;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class ProjectsApiController implements ProjectsApi {
    
    private ApiService apiService;
    
    public ProjectsApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addProject(@ApiParam(value = "Project object that needs to be added to the store"  ) @RequestBody Project body) {
        
        return apiService.add(body);
        
    }

    public ResponseEntity<Void> deleteProject(@ApiParam(value = "Project id to delete",required=true ) @PathVariable("id") Long id) {
        
        return apiService.delete(Project.class, id);
    }

    public ResponseEntity<List<Project>> projectsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<Project> projectList = apiService.getList(size, offset, Project.class);
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
    }

    public ResponseEntity<Project> projectsIdGet(@ApiParam(value = "Project ID",required=true ) @PathVariable("id") Long id) {
        
        return apiService.get(id, Project.class);
    }

    public ResponseEntity<Void> updateProject(@ApiParam(value = "Project ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Project object that needs to be updated in the store"  ) @RequestBody Project body) {
        
        return apiService.update(id, body);
    }

}
