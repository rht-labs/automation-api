package com.rhc.automation.api;

import com.rhc.automation.model.ErrorModel;
import java.util.List;

import io.swagger.annotations.*;

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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-19T17:04:30.676-07:00")

@Controller
public class BuildToolsApiController implements BuildToolsApi {

    public ResponseEntity<List<String>> buildToolsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



) {
        // do some magic!
        return new ResponseEntity<List<String>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> setBuildTools(

@ApiParam(value = "List of build tools" ,required=true ) @RequestBody List<String> body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
