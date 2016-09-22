package com.rhc.automation.api;

import com.rhc.automation.model.User;

import io.swagger.annotations.*;

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

    private ApiService apiService;
    
    public UsersApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addUser(@ApiParam(value = "User object that needs to be added to the store") @RequestBody User body) {
        
        return apiService.add(body);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "User id to delete", required = true) @PathVariable("id") Long id) {
        
        return apiService.delete(User.class, id);
        
    }

    public ResponseEntity<Void> updateUser(@ApiParam(value = "User ID", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "User object that needs to be updated in the store") @RequestBody User body) {
        
        return apiService.update(id, body);
    }

    public ResponseEntity<List<User>> usersGet(
            @ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
            @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<User> userList = apiService.getList(size, offset, User.class);
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    public ResponseEntity<User> usersIdGet(@ApiParam(value = "User ID", required = true) @PathVariable("id") Long id) {
        
        return apiService.get(id, User.class);
    }

}
