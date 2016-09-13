package com.rhc.automation.api;

import com.rhc.automation.model.RoleMapping;
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
public class RoleMappingsApiController implements RoleMappingsApi {

    public ResponseEntity<Void> addRoleMapping(

@ApiParam(value = "RoleMapping object that needs to be added to the store"  ) @RequestBody RoleMapping body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteRoleMapping(
@ApiParam(value = "RoleMapping id to delete",required=true ) @PathVariable("id") Long id


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<RoleMapping>> roleMappingsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



) {
        // do some magic!
        return new ResponseEntity<List<RoleMapping>>(HttpStatus.OK);
    }

    public ResponseEntity<RoleMapping> roleMappingsIdGet(
@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id


) {
        // do some magic!
        return new ResponseEntity<RoleMapping>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateRoleMapping(
@ApiParam(value = "RoleMapping ID",required=true ) @PathVariable("id") Long id


,
        

@ApiParam(value = "RoleMapping object that needs to be updated in the store"  ) @RequestBody RoleMapping body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
