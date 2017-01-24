package com.rhc.automation.api;

import com.rhc.automation.exception.EngagementNotFoundException;
import com.rhc.automation.exception.InvalidEngagementException;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.model.ErrorModel;
import com.rhc.automation.repo.EngagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T13:59:49.822-08:00")

@Controller
public class EngagementsApiController implements EngagementsApi {

    @Autowired
    private EngagementRepository engagementRepository;

    public ResponseEntity<List<Engagement>> engagementsGet(
            @RequestParam(value = "nameIncludes", required = false) String nameIncludes,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "offset", required = false) Long offset
    ) {

        if ( size == null || offset == null ) {
            throw new NotImplementedException();
        } else if ( nameIncludes == null || nameIncludes.isEmpty() ) {
            List<Engagement> engagementList = engagementRepository.getAll();
            return new ResponseEntity<List<Engagement>>( engagementList, HttpStatus.OK );
        } else {
            List<Engagement> engagementList = engagementRepository.findByNameContainingIgnoreCase( nameIncludes );
            return new ResponseEntity<List<Engagement>>( engagementList, HttpStatus.OK );
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> engagementsIdDelete( @PathVariable("id") Long id ) throws EngagementNotFoundException {
        engagementRepository.delete( id );
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT );
    }

    public ResponseEntity<Engagement> engagementsIdGet( @PathVariable("id") Long id ) throws EngagementNotFoundException {
        Engagement engagement = engagementRepository.findById( id );
        return new ResponseEntity<Engagement>( engagement, HttpStatus.OK );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> engagementsIdPut( @PathVariable("id") Long id, @RequestBody Engagement body ) throws InvalidEngagementException {
        boolean newEngagementCreated = engagementRepository.save( body, id );
        if ( newEngagementCreated ) {
            return new ResponseEntity<Void>( createdHeadersWithLocation( body ), HttpStatus.CREATED );
        } else {
            return new ResponseEntity<Void>( HttpStatus.NO_CONTENT );
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> engagementsPost( @RequestBody Engagement engagement ) throws InvalidEngagementException {
        engagementRepository.save( engagement );
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

    @ExceptionHandler({NotImplementedException.class})
    public ResponseEntity<ErrorModel> handleNotImplimentedException( NotImplementedException e ) {
        return new ResponseEntity<ErrorModel>( new ErrorModel().code( 500 ).message( "size and offset not yet implimented" ), HttpStatus.INTERNAL_SERVER_ERROR );
    }

    private HttpHeaders createdHeadersWithLocation( Engagement engagement ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add( "Location", String.format( "/engagements/%d", engagement.getId() ) );
        return responseHeaders;
    }

}
