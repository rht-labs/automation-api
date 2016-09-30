package com.rhc.automation.api;

import com.rhc.automation.model.ErrorModel;
import java.util.List;

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

@Api(value = "build_tools", description = "the build_tools API")
public interface BuildToolsApi {

    @ApiOperation(value = "", notes = "Get a list of build tools ", response = String.class, responseContainer = "List", tags={ "build_tools", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/build_tools",
        method = RequestMethod.GET)
    ResponseEntity<List<String>> buildToolsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "Sets the list of supported build tools", notes = "", response = Void.class, tags={ "build_tools", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Void.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/build_tools",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> setBuildTools(

@ApiParam(value = "List of build tools" ,required=true ) @RequestBody List<String> body

);

}
