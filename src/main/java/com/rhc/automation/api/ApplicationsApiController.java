package com.rhc.automation.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhc.automation.model.Application;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class ApplicationsApiController implements ApplicationsApi {
    private ApiService apiService;
    
    public ApplicationsApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addApplication(
            @ApiParam(value = "Application object that needs to be added to the store"  ) @RequestBody Application body) {
        
        return apiService.add(body);
    }

    public ResponseEntity<List<Application>> applicationsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {

        List<Application> apps = apiService.getList(size, offset, Application.class);
        return new ResponseEntity<List<Application>>(apps, HttpStatus.OK);
    }

    public ResponseEntity<Application> applicationsIdGet(@ApiParam(value = "Application ID",required=true ) @PathVariable("id") Long id) {
        
        return apiService.get(id, Application.class);
    }

    public ResponseEntity<Void> deleteApplication(@ApiParam(value = "Application id to delete",required=true ) @PathVariable("id") Long id) {
        
        return apiService.delete(Application.class, id);
    }

    public ResponseEntity<Void> updateApplication(@ApiParam(value = "Application ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Application object that needs to be updated in the store"  ) @RequestBody Application body) {
        
        return apiService.update(id, body);
    }

}
