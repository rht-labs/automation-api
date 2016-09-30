package com.rhc.automation.api;

import com.rhc.automation.model.Application;
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

@Api(value = "applications", description = "the applications API")
public interface ApplicationsApi {

    @ApiOperation(value = "Add a new application", notes = "", response = Void.class, tags={ "application", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/applications",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addApplication(

@ApiParam(value = "Application object that needs to be added to the store"  ) @RequestBody Application body

);


    @ApiOperation(value = "", notes = "Gets `Application` objects. Optional query param of **size** determines size of returned array ", response = Application.class, responseContainer = "List", tags={ "application", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Application.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Application.class) })
    @RequestMapping(value = "/applications",
        method = RequestMethod.GET)
    ResponseEntity<List<Application>> applicationsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `Application` object by ID. ", response = Application.class, tags={ "application", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Application.class) })
    @RequestMapping(value = "/applications/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Application> applicationsIdGet(
@ApiParam(value = "Application ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Deletes an application", notes = "", response = Void.class, tags={ "application", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Application value", response = Void.class) })
    @RequestMapping(value = "/applications/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteApplication(
@ApiParam(value = "Application id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing application", notes = "", response = Void.class, tags={ "application", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Application not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/applications/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateApplication(
@ApiParam(value = "Application ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "Application object that needs to be updated in the store"  ) @RequestBody Application body

);

}
