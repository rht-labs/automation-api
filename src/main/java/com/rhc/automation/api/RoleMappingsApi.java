package com.rhc.automation.api;

import com.rhc.automation.model.RoleMapping;
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

@Api(value = "role_mappings", description = "the role_mappings API")
public interface RoleMappingsApi {

    @ApiOperation(value = "Add a new role_mapping", notes = "", response = Void.class, tags={ "role_mapping", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/role_mappings",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addRoleMapping(

@ApiParam(value = "RoleMapping object that needs to be added to the store"  ) @RequestBody RoleMapping body

);


    @ApiOperation(value = "Deletes an role_mapping", notes = "", response = Void.class, tags={ "role_mapping", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid RoleMapping value", response = Void.class) })
    @RequestMapping(value = "/role_mappings/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRoleMapping(
@ApiParam(value = "RoleMapping id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "", notes = "Gets `RoleMapping` objects. Optional query param of **size** determines size of returned array ", response = RoleMapping.class, responseContainer = "List", tags={ "role_mapping", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RoleMapping.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = RoleMapping.class) })
    @RequestMapping(value = "/role_mappings",
        method = RequestMethod.GET)
    ResponseEntity<List<RoleMapping>> roleMappingsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `RoleMapping` object by ID. ", response = RoleMapping.class, tags={ "role_mapping", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = RoleMapping.class) })
    @RequestMapping(value = "/role_mappings/{id}",
        method = RequestMethod.GET)
    ResponseEntity<RoleMapping> roleMappingsIdGet(
@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing role_mapping", notes = "", response = Void.class, tags={ "role_mapping", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "RoleMapping not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/role_mappings/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRoleMapping(
@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "RoleMapping object that needs to be updated in the store"  ) @RequestBody RoleMapping body

);

}
