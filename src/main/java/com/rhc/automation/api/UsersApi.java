package com.rhc.automation.api;

import com.rhc.automation.model.User;
import com.rhc.automation.model.ErrorModel;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Add a new user", notes = "", response = Void.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addUser(

@ApiParam(value = "User object that needs to be added to the store"  ) @RequestBody User body

);


    @ApiOperation(value = "Deletes an user", notes = "", response = Void.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid User value", response = Void.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(
@ApiParam(value = "User id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing user", notes = "", response = Void.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "User not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(
@ApiParam(value = "User ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "User object that needs to be updated in the store"  ) @RequestBody User body

);


    @ApiOperation(value = "", notes = "Gets `User` objects. Optional query param of **size** determines size of returned array ", response = User.class, responseContainer = "List", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = User.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = User.class) })
    @RequestMapping(value = "/users",
        method = RequestMethod.GET)
    ResponseEntity<List<User>> usersGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `User` object by ID. ", response = User.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = User.class) })
    @RequestMapping(value = "/users/{id}",
        method = RequestMethod.GET)
    ResponseEntity<User> usersIdGet(
@ApiParam(value = "User ID",required=true ) @PathVariable("id") Long id


);

}
