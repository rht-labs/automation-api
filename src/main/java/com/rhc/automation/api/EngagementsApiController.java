package com.rhc.automation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.rhc.automation.model.Engagement;
import com.rhc.automation.service.CustomerService;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class EngagementsApiController implements EngagementsApi {
    private ApiService apiService;
    
    public EngagementsApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    public ResponseEntity<Void> addEngagement(
            @ApiParam(value = "Engagement object that needs to be added to the store") @RequestBody Engagement body) {

        return apiService.add(body);
    }

    public ResponseEntity<Void> deleteEngagement(@ApiParam(value = "Engagement id to delete",required=true ) 
            @PathVariable("id") Long id) {

        return apiService.delete(Engagement.class, id);
    }

    public ResponseEntity<List<Engagement>> engagementsGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<Engagement> engagementList = apiService.getList(size, offset, Engagement.class);
        
        return new ResponseEntity<List<Engagement>>(engagementList,HttpStatus.OK);
    }

    public ResponseEntity<Engagement> engagementsIdGet(@ApiParam(value = "Engagement ID",required=true ) @PathVariable("id") Long id) {
        
        return apiService.get(id, Engagement.class);
    }

    public ResponseEntity<Void> updateEngagement(@ApiParam(value = "Engagement ID",required=true ) @PathVariable("id") Long id,
            @ApiParam(value = "Engagement object that needs to be updated in the store"  ) @RequestBody Engagement body) {
        
        return apiService.update(id, body);
    }

}
