package com.rhc.automation.api;

import com.rhc.automation.model.Engagement;
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

@Api(value = "engagements", description = "the engagements API")
public interface EngagementsApi {

    @ApiOperation(value = "Add a new engagement", notes = "", response = Void.class, tags={ "engagement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/engagements",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addEngagement(

@ApiParam(value = "Engagement object that needs to be added to the store"  ) @RequestBody Engagement body

);


    @ApiOperation(value = "Deletes an engagement", notes = "", response = Void.class, tags={ "engagement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Engagement value", response = Void.class) })
    @RequestMapping(value = "/engagements/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEngagement(
@ApiParam(value = "Engagement id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "", notes = "Gets `Engagement` objects. Optional query param of **size** determines size of returned array ", response = Engagement.class, responseContainer = "List", tags={ "engagement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Engagement.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Engagement.class) })
    @RequestMapping(value = "/engagements",
        method = RequestMethod.GET)
    ResponseEntity<List<Engagement>> engagementsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `Engagement` object by ID. ", response = Engagement.class, tags={ "engagement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Engagement.class) })
    @RequestMapping(value = "/engagements/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Engagement> engagementsIdGet(
@ApiParam(value = "Engagement ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing engagement", notes = "", response = Void.class, tags={ "engagement", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Engagement not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/engagements/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateEngagement(
@ApiParam(value = "Engagement ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "Engagement object that needs to be updated in the store"  ) @RequestBody Engagement body

);

}
