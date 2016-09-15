package com.rhc.automation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserService customerService;

    public ResponseEntity<Void> addRoleMapping(@ApiParam(value = "RoleMapping object that needs to be added to the store"  ) 
        @RequestBody RoleMapping body) {
        
        customerService.addRoleMapping(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRoleMapping(@ApiParam(value = "RoleMapping id to delete",required=true ) @PathVariable("id") Long id) {
        
        HttpStatus status = HttpStatus.OK;
        RoleMapping roleMapping = customerService.getRoleMapping(id);
        
        if(roleMapping == null) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            customerService.deleteRoleMapping(id);
        }
        return new ResponseEntity<Void>(status);
    }

    public ResponseEntity<List<RoleMapping>> roleMappingsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        PageRequest pageRequest = new PageRequest(offset.intValue(), size);
        Page<RoleMapping> roleMappings = customerService.getRoleMappings(pageRequest);
        return new ResponseEntity<List<RoleMapping>>(roleMappings.getContent(), HttpStatus.OK);
    }

    public ResponseEntity<RoleMapping> roleMappingsIdGet(@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id) {
        
        HttpStatus status = HttpStatus.OK;
        RoleMapping roleMapping = customerService.getRoleMapping(id); 
        
        if(roleMapping == null) {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<RoleMapping>(roleMapping, status);
    }

    public ResponseEntity<Void> updateRoleMapping(@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "RoleMapping object that needs to be updated in the store"  ) @RequestBody RoleMapping body) {
        
        body.setId(id);
        HttpStatus status = HttpStatus.OK;
        try {
            customerService.updateRoleMapping(body); 
         } catch (NotFoundException nfe) {
             status = HttpStatus.NOT_FOUND;
         } catch(ValidationException ve) {
             status = HttpStatus.METHOD_NOT_ALLOWED;
         }

        return new ResponseEntity<Void>(status);
    }

}
