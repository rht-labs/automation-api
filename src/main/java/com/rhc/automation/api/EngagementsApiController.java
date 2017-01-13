package com.rhc.automation.api;

import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.ErrorModel;
import com.rhc.automation.service.EngagementService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

@Controller
public class EngagementsApiController implements EngagementsApi {

    @Autowired
    private EngagementService engagementService;

    public ResponseEntity<List<Engagement>> engagementsGet(
            @ApiParam(value = "selects results that contain the query string, case insensitive, in `Engagement.name`") @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
            @ApiParam(value = "offset in result set from beginning") @RequestParam(value = "offset", required = false) Long offset
    ) {

        List<Engagement> engagementList = engagementService.getEngagementList();
        return new ResponseEntity<List<Engagement>>(engagementList, HttpStatus.OK);
    }

    public ResponseEntity<Engagement> engagementsIdDelete(@ApiParam(value = "", required = true) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Engagement>(HttpStatus.OK);
    }

    public ResponseEntity<Engagement> engagementsIdGet(@ApiParam(value = "", required = true) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Engagement>(HttpStatus.OK);
    }

    public ResponseEntity<Engagement> engagementsIdPut(
            @ApiParam(value = "", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "", required = true) @RequestBody Engagement body
    ) {
        // do some magic!
        return new ResponseEntity<Engagement>(HttpStatus.OK);
    }

    public ResponseEntity<?> engagementsPost(@ApiParam(value = "`Engagement` object to save", required = true) @RequestBody Engagement engagement) {

        try {
            engagementService.addEngagement(engagement);
        } catch (InvalidEngagementException e) {
            ErrorModel errorModel = new ErrorModel().code(400).message("The following fields are missing or invalid: " + engagement.determineInvalidFields().toString());
            return new ResponseEntity<ErrorModel>(errorModel, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
