package com.rhc.automation.api;

import com.rhc.automation.model.EngagementSummary;
import com.rhc.automation.model.ErrorModel;

import com.rhc.automation.service.EngagementSummaryService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-13T20:24:12.126-07:00")

@Controller
public class EngagementSummariesApiController implements EngagementSummariesApi {

    @Autowired
    private EngagementSummaryService engagementSummaryService;

    public ResponseEntity<List<EngagementSummary>> engagementSummariesGet(
            @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "offset", required = false) Long offset
    ) {
        List<EngagementSummary> engagementSummaries = engagementSummaryService.engagementSummariesList( nameIncludes, size, offset );
        return new ResponseEntity<List<EngagementSummary>>( engagementSummaries, HttpStatus.OK );
    }

}
