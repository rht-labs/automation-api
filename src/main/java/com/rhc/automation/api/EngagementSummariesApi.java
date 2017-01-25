package com.rhc.automation.api;

import com.rhc.automation.model.EngagementSummary;
import com.rhc.automation.model.ErrorModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@javax.annotation.Generated( value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-13T20:24:12.126-07:00" )

@Api( value = "engagement-summaries", description = "the engagement-summaries API" )
public interface EngagementSummariesApi {

    @ApiOperation( value = "", notes = "", response = EngagementSummary.class, responseContainer = "List", tags = { "engagement-summary", } )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Collection of `EngagementSummary` objects", response = EngagementSummary.class ),
            @ApiResponse( code = 500, message = "Unexpected Server Error", response = ErrorModel.class ) } )
    @RequestMapping( value = "/engagement-summaries", produces = { "application/json" }, method = RequestMethod.GET )
    ResponseEntity<List<EngagementSummary>> engagementSummariesGet(
            @ApiParam( value = "selects results that contain the query string, case insensitive, in `EngagementSummary.name`" ) @RequestParam( value = "nameIncludes", required = false ) String nameIncludes,
            @ApiParam( value = "number of results to return" ) @RequestParam( value = "size", required = false ) Integer size,
            @ApiParam( value = "offset in result set from beginning" ) @RequestParam( value = "offset", required = false ) Long offset
    );

}
