package com.rhc.automation.api;

import com.rhc.automation.model.Project;
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

@Api(value = "projects", description = "the projects API")
public interface ProjectsApi {

    @ApiOperation(value = "Add a new project", notes = "", response = Void.class, tags={ "project", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/projects",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addProject(

@ApiParam(value = "Project object that needs to be added to the store"  ) @RequestBody Project body

);


    @ApiOperation(value = "Deletes an project", notes = "", response = Void.class, tags={ "project", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Project value", response = Void.class) })
    @RequestMapping(value = "/projects/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProject(
@ApiParam(value = "Project id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "", notes = "Gets `Project` objects. Optional query param of **size** determines size of returned array ", response = Project.class, responseContainer = "List", tags={ "project", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Project.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Project.class) })
    @RequestMapping(value = "/projects",
        method = RequestMethod.GET)
    ResponseEntity<List<Project>> projectsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `Project` object by ID. ", response = Project.class, tags={ "project", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Project.class) })
    @RequestMapping(value = "/projects/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Project> projectsIdGet(
@ApiParam(value = "Project ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing project", notes = "", response = Void.class, tags={ "project", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Project not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/projects/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateProject(
@ApiParam(value = "Project ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "Project object that needs to be updated in the store"  ) @RequestBody Project body

);

}
