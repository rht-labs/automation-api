package com.rhc.automation.api;

import com.rhc.automation.model.Role;
import com.rhc.automation.model.ErrorModel;

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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class RolesApiController implements RolesApi {

    public ResponseEntity<Void> addRole(

@ApiParam(value = "Role object that needs to be added to the store"  ) @RequestBody Role body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRole(
@ApiParam(value = "Role id to delete",required=true ) @PathVariable("id") Long id


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Role>> rolesGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



) {
        // do some magic!
        return new ResponseEntity<List<Role>>(HttpStatus.OK);
    }

    public ResponseEntity<Role> rolesIdGet(
@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id


) {
        // do some magic!
        return new ResponseEntity<Role>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateRole(
@ApiParam(value = "Role ID",required=true ) @PathVariable("id") Long id


,
        

@ApiParam(value = "Role object that needs to be updated in the store"  ) @RequestBody Role body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
