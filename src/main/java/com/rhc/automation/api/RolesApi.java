package com.rhc.automation.api;

import com.rhc.automation.model.Role;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Api(value = "roles", description = "the roles API")
public interface RolesApi {

    @ApiOperation(value = "Add a new role", notes = "", response = Void.class, tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/roles",
        produces = { "role/json" }, 
        consumes = { "role/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addRole(

@ApiParam(value = "Role object that needs to be added to the store"  ) @RequestBody Role body

);


    @ApiOperation(value = "Deletes an role", notes = "", response = Void.class, tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Role value", response = Void.class) })
    @RequestMapping(value = "/roles/{id}",
        produces = { "role/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRole(
@ApiParam(value = "Role id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "", notes = "Gets `Role` objects. Optional query param of **size** determines size of returned array ", response = Role.class, responseContainer = "List", tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Role.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Role.class) })
    @RequestMapping(value = "/roles",
        method = RequestMethod.GET)
    ResponseEntity<List<Role>> rolesGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `Role` object by ID. ", response = Role.class, tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Role.class) })
    @RequestMapping(value = "/roles/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Role> rolesIdGet(
@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing role", notes = "", response = Void.class, tags={ "role", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Role not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/roles/{id}",
        produces = { "role/json" }, 
        consumes = { "role/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRole(
@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "Role object that needs to be updated in the store"  ) @RequestBody Role body

);

}
