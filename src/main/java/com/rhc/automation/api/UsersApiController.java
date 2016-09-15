package com.rhc.automation.api;

import com.rhc.automation.model.User;
import com.rhc.automation.service.UserService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private UserService customerService;

    public ResponseEntity<Void> addUser(@ApiParam(value = "User object that needs to be added to the store") @RequestBody User body) {
        customerService.addUser(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "User id to delete", required = true) @PathVariable("id") Long id) {
        HttpStatus status = HttpStatus.OK;
        User user = customerService.getUser(id);
        
        if(user == null) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            customerService.deleteUser(id);
        }
        return new ResponseEntity<Void>(status);
    }

    public ResponseEntity<Void> updateUser(@ApiParam(value = "User ID", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "User object that needs to be updated in the store") @RequestBody User body) {
        
        body.setId(id);
        HttpStatus status = HttpStatus.OK;
        try {
            customerService.updateUser(body); 
         } catch (NotFoundException nfe) {
             status = HttpStatus.NOT_FOUND;
         } catch(ValidationException ve) {
             status = HttpStatus.METHOD_NOT_ALLOWED;
         }

        return new ResponseEntity<Void>(status);
    }

    public ResponseEntity<List<User>> usersGet(
            @ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
            @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset

    ) {
        PageRequest pageRequest = new PageRequest(offset.intValue(), size);
        Page<User> users = customerService.getUsers(pageRequest);
        return new ResponseEntity<List<User>>(users.getContent(), HttpStatus.OK);
    }

    public ResponseEntity<User> usersIdGet(@ApiParam(value = "User ID", required = true) @PathVariable("id") Long id) {
        HttpStatus status = HttpStatus.OK;
        User user = customerService.getUser(id); 
        
        if(user == null) {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<User>(user, status);
    }

}
