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

import com.rhc.automation.model.Role;
import com.rhc.automation.service.UserService;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class RolesApiController implements RolesApi {
    
    @Autowired
    private UserService customerService;

    public ResponseEntity<Void> addRole(@ApiParam(value = "Role object that needs to be added to the store"  ) @RequestBody Role body) {
        
        customerService.addRole(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRole(@ApiParam(value = "Role id to delete",required=true ) @PathVariable("id") Long id) {
        HttpStatus status = HttpStatus.OK;
        
        Role role = customerService.getRole(id);
        if(role == null) {
            status = HttpStatus.BAD_REQUEST;
        }
        
        return new ResponseEntity<Void>(status);
    }

    public ResponseEntity<List<Role>> rolesGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        PageRequest pageRequest = new PageRequest(offset.intValue(), size);
        Page<Role> roles = customerService.getRoles(pageRequest);
        return new ResponseEntity<List<Role>>(roles.getContent(), HttpStatus.OK);
    }

    public ResponseEntity<Role> rolesIdGet(@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id) {
        HttpStatus status = HttpStatus.OK;
        
        Role role = customerService.getRole(id);
        if(role == null) {
            status = HttpStatus.NOT_FOUND;
        }
        
        return new ResponseEntity<Role>(role, status);
    }

    public ResponseEntity<Void> updateRole(@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Role object that needs to be updated in the store"  ) @RequestBody Role body) {
        
        body.setId(id);
        HttpStatus status = HttpStatus.OK;
        try {
            customerService.updateRole(body); 
         } catch (NotFoundException nfe) {
             status = HttpStatus.NOT_FOUND;
         } catch(ValidationException ve) {
             status = HttpStatus.METHOD_NOT_ALLOWED;
         }

        return new ResponseEntity<Void>(status);
    }

}
