package com.rhc.automation.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rhc.automation.model.Customer;

import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Controller
public class CustomersApiController implements CustomersApi {
    private ApiService apiService;
    
    public CustomersApiController(ApiService apiService) {
        this.apiService = apiService;
    }
    public ResponseEntity<Void> addCustomer(@ApiParam(value = "Customer object that needs to be added to the store"  ) @RequestBody Customer body) {
        return apiService.add(body);
    }

    public ResponseEntity<List<Customer>> customersGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size,
        @ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset) {
        
        List<Customer> customerList = apiService.getList(size, offset, Customer.class);
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    public ResponseEntity<Customer> customersIdGet(@ApiParam(value = "Customer ID",required=true ) @PathVariable("id") Long id) {
        
        return apiService.get(id, Customer.class);
    }

    public ResponseEntity<Void> deleteCustomer(@ApiParam(value = "Customer id to delete",required=true ) @PathVariable("id") Long id) {
        
        return apiService.delete(Customer.class, id);
    }

    public ResponseEntity<Void> updateCustomer(@ApiParam(value = "Customer ID",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "Customer object that needs to be updated in the store"  ) @RequestBody Customer body) {
        
        return apiService.update(id, body);
    }

}
