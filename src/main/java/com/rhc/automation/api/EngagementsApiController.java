package com.rhc.automation.api;

import com.rhc.automation.exception.DuplicateEngagementIdsException;
import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.ErrorModel;
import com.rhc.automation.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

@Controller
public class EngagementsApiController implements EngagementsApi {

    @Autowired
    private EngagementService engagementService;

    public ResponseEntity<List<Engagement>> engagementsGet(
            @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "offset", required = false) Long offset
    ) {

        List<Engagement> engagementList = engagementService.engagementList( nameIncludes, size, offset );
        return new ResponseEntity<List<Engagement>>( engagementList, HttpStatus.OK );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> engagementsIdDelete( @PathVariable("id") Long id ) throws EngagementNotFoundException {
        engagementService.deleteEngagementById( id );
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT );
    }

    public ResponseEntity<Engagement> engagementsIdGet( @PathVariable("id") Long id ) throws EngagementNotFoundException, DuplicateEngagementIdsException {
        Engagement engagement = engagementService.engagement( id );
        return new ResponseEntity<Engagement>( engagement, HttpStatus.OK );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> engagementsIdPut( @PathVariable("id") Long id, @RequestBody Engagement body ) throws InvalidEngagementException {
        boolean newEngagementCreated = engagementService.addEngagement( body, id );
        if ( newEngagementCreated ) {
            return new ResponseEntity<Void>( createdHeadersWithLocation( body ), HttpStatus.CREATED );
        } else {
            return new ResponseEntity<Void>( HttpStatus.NO_CONTENT );
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> engagementsPost( @RequestBody Engagement engagement ) throws InvalidEngagementException {
        engagementService.addEngagement( engagement );
        return new ResponseEntity<Void>( createdHeadersWithLocation( engagement ), HttpStatus.CREATED );
    }

    @ExceptionHandler({InvalidEngagementException.class})
    public ResponseEntity<ErrorModel> handleInvalidEngagementException( InvalidEngagementException e ) {
        return new ResponseEntity<ErrorModel>( new ErrorModel().code( 400 ).message( e.getMessage() ), HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler({EngagementNotFoundException.class})
    public ResponseEntity<ErrorModel> handleEngagementNotFoundException( EngagementNotFoundException e ) {
        return new ResponseEntity<ErrorModel>( new ErrorModel().code( 404 ).message( e.getMessage() ), HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler({DuplicateEngagementIdsException.class})
    public ResponseEntity<ErrorModel> handleDuplicateEngagementIdsException( DuplicateEngagementIdsException e ) {
        return new ResponseEntity<ErrorModel>( new ErrorModel().code( 500 ).message( e.getMessage() ), HttpStatus.INTERNAL_SERVER_ERROR );
    }

    private HttpHeaders createdHeadersWithLocation( Engagement engagement ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add( "Location", String.format( "/engagements/%d", engagement.getId() ) );
        return responseHeaders;
    }

}
