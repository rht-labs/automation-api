package com.rhc.automation.api;

import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.ErrorModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Be advised that the response models for @ApiResponse currently suffer from this bug:
 * https://github.com/swagger-api/swagger-codegen/issues/3371, so they have been manually edited.
 *
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

@Api(value = "engagements", description = "the engagements API")
public interface EngagementsApi {

    @ApiOperation(value = "", notes = "", response = Engagement.class, responseContainer = "List", tags = {"engagement",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Collection of `Engagement` objects", response = Engagement.class),
            @ApiResponse(code = 400, message = "Bad Request: Invalid syntax", response = ErrorModel.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class)})
    @RequestMapping(value = "/engagements", method = RequestMethod.GET)
    ResponseEntity<List<Engagement>> engagementsGet(
            @ApiParam(value = "selects results that contain the query string, case insensitive, in `Engagement.name`") @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
            @ApiParam(value = "offset in result set from beginning") @RequestParam(value = "offset", required = false) Long offset
    );


    @ApiOperation(value = "", notes = "", response = Engagement.class, tags = {"engagement",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "`Engagement` of the given `id` deleted", response = Engagement.class),
            @ApiResponse(code = 400, message = "Bad Request: Invalid ID", response = ErrorModel.class),
            @ApiResponse(code = 404, message = "`Engagement` of the given `id` not found"),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class)})
    @RequestMapping(value = "/engagements/{id}", produces = {"application/json"}, method = RequestMethod.DELETE)
    ResponseEntity<Engagement> engagementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "", notes = "", response = Engagement.class, tags = {"engagement",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "`Engagement` of the given `id` returned", response = Engagement.class),
            @ApiResponse(code = 400, message = "Bad Request: Invalid ID", response = ErrorModel.class),
            @ApiResponse(code = 404, message = "`Engagement` of the given `id` not found"),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class)})
    @RequestMapping(value = "/engagements/{id}", method = RequestMethod.GET)
    ResponseEntity<Engagement> engagementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "", notes = "", response = Engagement.class, tags = {"engagement",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "`Engagement` saved with the given `id`", response = Engagement.class),
            @ApiResponse(code = 400, message = "Bad request: Invalid ID", response = ErrorModel.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class)})
    @RequestMapping(value = "/engagements/{id}", produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.PUT)
    ResponseEntity<Engagement> engagementsIdPut(
            @ApiParam(value = "", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "", required = true) @RequestBody Engagement body
    );


    @ApiOperation(value = "", notes = "", response = Void.class, tags = {"engagement",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Void.class),
            @ApiResponse(code = 400, message = "Bad Request: Invalid Syntax", response = ErrorModel.class),
            @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class)})
    @RequestMapping(value = "/engagements", produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<?> engagementsPost(@ApiParam(value = "`Engagement` object to save", required = true) @RequestBody Engagement body);

}
