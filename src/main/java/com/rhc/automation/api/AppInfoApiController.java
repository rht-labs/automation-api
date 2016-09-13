package com.rhc.automation.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AppInfoApiController implements AppInfoApi {

    @Value("${automationapi.message}")
    private String appName;
    
    @Override
    public ResponseEntity<String> getAppInfo() {
        return new ResponseEntity<String>(appName, HttpStatus.OK);
    }

 

}
