package com.rhc.automation.api;

import com.rhc.automation.model.OpenShiftCluster;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T12:23:04.865-07:00")

@Api(value = "openshift_clusters", description = "the openshift_clusters API")
public interface OpenshiftClustersApi {

    @ApiOperation(value = "Add a new openshift_cluster", notes = "", response = Void.class, tags={ "openshift_cluster", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/openshift_clusters",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addOpenShiftCluster(

@ApiParam(value = "OpenShiftCluster object that needs to be added to the store"  ) @RequestBody OpenShiftCluster body

);


    @ApiOperation(value = "Deletes an openshift_cluster", notes = "", response = Void.class, tags={ "openshift_cluster", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid OpenShiftCluster value", response = Void.class) })
    @RequestMapping(value = "/openshift_clusters/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteOpenShiftCluster(
@ApiParam(value = "OpenShiftCluster id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "", notes = "Gets `OpenShiftCluster` objects. Optional query param of **size** determines size of returned array ", response = OpenShiftCluster.class, responseContainer = "List", tags={ "openshift_cluster", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = OpenShiftCluster.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = OpenShiftCluster.class) })
    @RequestMapping(value = "/openshift_clusters",
        method = RequestMethod.GET)
    ResponseEntity<List<OpenShiftCluster>> openshiftClustersGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `OpenShiftCluster` object by ID. ", response = OpenShiftCluster.class, tags={ "openshift_cluster", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = OpenShiftCluster.class) })
    @RequestMapping(value = "/openshift_clusters/{id}",
        method = RequestMethod.GET)
    ResponseEntity<OpenShiftCluster> openshiftClustersIdGet(
@ApiParam(value = "OpenShiftCluster ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing openshift_cluster", notes = "", response = Void.class, tags={ "openshift_cluster", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "OpenShiftCluster not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/openshift_clusters/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateOpenShiftCluster(
@ApiParam(value = "OpenShiftCluster ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "OpenShiftCluster object that needs to be updated in the store"  ) @RequestBody OpenShiftCluster body

);

}
