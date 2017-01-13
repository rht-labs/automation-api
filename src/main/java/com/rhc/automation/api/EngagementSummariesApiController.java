package com.rhc.automation.api;

import com.rhc.automation.model.EngagementSummary;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

@Controller
public class EngagementSummariesApiController implements EngagementSummariesApi {

    public ResponseEntity<List<EngagementSummary>> engagementSummariesGet(
            @ApiParam(value = "selects results that contain the query string, case insensitive, in `EngagementSummary.name`") @RequestParam(value = "nameIncludes", required = false) String nameInclude,
            @ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
            @ApiParam(value = "offset in result set from beginning") @RequestParam(value = "offset", required = false) Long offset
    ) {
        // do some magic!
        return new ResponseEntity<List<EngagementSummary>>(HttpStatus.OK);
    }

}
