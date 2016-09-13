package com.rhc.automation.api;

import com.rhc.automation.model.Customer;
import com.rhc.automation.model.ErrorModel;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-08T13:44:26.455-07:00")

@Api(value = "customers", description = "the customers API")
public interface CustomersApi {

    @ApiOperation(value = "Add a new customer", notes = "", response = Void.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addCustomer(

@ApiParam(value = "Customer object that needs to be added to the store"  ) @RequestBody Customer body

);


    @ApiOperation(value = "", notes = "Gets `Customer` objects. Optional query param of **size** determines size of returned array ", response = Customer.class, responseContainer = "List", tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Customer.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Customer.class) })
    @RequestMapping(value = "/customers",
        method = RequestMethod.GET)
    ResponseEntity<List<Customer>> customersGet(@ApiParam(value = "number of results to return") @RequestParam(value = "size", required = false) Integer size



,@ApiParam(value = "offset in list") @RequestParam(value = "offset", required = false) Long offset



);


    @ApiOperation(value = "", notes = "Gets an `Customer` object by ID. ", response = Customer.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = Customer.class) })
    @RequestMapping(value = "/customers/{id}",
        method = RequestMethod.GET)
    ResponseEntity<Customer> customersIdGet(
@ApiParam(value = "Customer ID",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Deletes a customer", notes = "", response = Void.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid customer value", response = Void.class) })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(
@ApiParam(value = "Customer id to delete",required=true ) @PathVariable("id") Long id


);


    @ApiOperation(value = "Update an existing customer", notes = "", response = Void.class, tags={ "customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Customer not found", response = Void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCustomer(
@ApiParam(value = "Customer ID",required=true ) @PathVariable("id") Long id


,

@ApiParam(value = "Customer object that needs to be updated in the store"  ) @RequestBody Customer body

);

}
