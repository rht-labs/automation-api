package com.rhc.automation.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Api(value = "app_info", description = "the role_mappings API")
public interface AppInfoApi {

    @ApiOperation(value = "", notes = "Gets Basic App Info. ", response = String.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = String.class) })
    @RequestMapping(value = "/appinfo", method = RequestMethod.GET)
    ResponseEntity<String> getAppInfo();


}
