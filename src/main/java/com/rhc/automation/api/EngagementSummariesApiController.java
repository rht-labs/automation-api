package com.rhc.automation.api;

import com.rhc.automation.model.EngagementSummary;
import com.rhc.automation.model.ErrorModel;
import com.rhc.automation.repo.EngagementSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-13T20:24:12.126-07:00")

@Controller
public class EngagementSummariesApiController implements EngagementSummariesApi {

    @Autowired
    private EngagementSummaryRepository engagementSummaryRepository;

    public ResponseEntity<List<EngagementSummary>> engagementSummariesGet(
            @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "offset", required = false) Long offset
    ) {
        if ( size == null || offset == null ) {
            throw new NotImplementedException();
        } else if ( nameIncludes == null || nameIncludes.isEmpty() ) {
            List<EngagementSummary> engagementSummaries = engagementSummaryRepository.getAll();
            return new ResponseEntity<List<EngagementSummary>>( engagementSummaries, HttpStatus.OK );
        } else {
            List<EngagementSummary> engagementSummaries = engagementSummaryRepository.findByNameContainingIgnoreCase( nameIncludes );
            return new ResponseEntity<List<EngagementSummary>>( engagementSummaries, HttpStatus.OK );
        }
    }


    @ExceptionHandler({NotImplementedException.class})
    public ResponseEntity<ErrorModel> handleNotImplimentedException( NotImplementedException e ) {
        return new ResponseEntity<ErrorModel>( new ErrorModel().code( 500 ).message( "size and offset not yet implimented" ), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
