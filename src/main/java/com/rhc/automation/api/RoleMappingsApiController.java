package com.rhc.automation.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhc.automation.model.RoleMapping;
import com.rhc.automation.service.UserService;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class RoleMappingsApiController implements RoleMappingsApi {
    
    private ApiService apiService;
    
    public RoleMappingsApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addRoleMapping(@ApiParam(value = "RoleMapping object that needs to be added to the store"  ) 
        @RequestBody RoleMapping body) {
        
        return apiService.add(body);
    }

    public ResponseEntity<Void> deleteRoleMapping(@ApiParam(value = "RoleMapping id to delete",required=true ) @PathVariable("id") Long id) {
        
        return apiService.delete(RoleMapping.class, id);
    }

    public ResponseEntity<List<RoleMapping>> roleMappingsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<RoleMapping> roleMappingList = apiService.getList(size, offset, RoleMapping.class);
        return new ResponseEntity<List<RoleMapping>>(roleMappingList, HttpStatus.OK);
    }

    public ResponseEntity<RoleMapping> roleMappingsIdGet(@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id) {
        
        return apiService.get(id, RoleMapping.class);
    }

    public ResponseEntity<Void> updateRoleMapping(@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "RoleMapping object that needs to be updated in the store"  ) @RequestBody RoleMapping body) {
        
        return apiService.update(id, body);
    }

}
