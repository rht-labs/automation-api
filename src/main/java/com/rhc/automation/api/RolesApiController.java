package com.rhc.automation.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhc.automation.model.Role;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class RolesApiController implements RolesApi {
    
    private ApiService apiService;
    
    public RolesApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addRole(@ApiParam(value = "Role object that needs to be added to the store"  ) @RequestBody Role body) {
        
        return apiService.add(body);
    }

    public ResponseEntity<Void> deleteRole(@ApiParam(value = "Role id to delete",required=true ) @PathVariable("id") Long id) {
        
        return apiService.delete(Role.class, id);
    }

    public ResponseEntity<List<Role>> rolesGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<Role> roleList = apiService.getList(size, offset, Role.class);
        return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
    }

    public ResponseEntity<Role> rolesIdGet(@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id) {

        return apiService.get(id, Role.class);
    }

    public ResponseEntity<Void> updateRole(@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Role object that needs to be updated in the store"  ) @RequestBody Role body) {
        
        return apiService.update(id, body);
    }

}
