package com.fin.shop.controllers;

import com.fin.shop.api.CustomerRequest;
import com.fin.shop.manager.CustomerManager;
import com.fin.shop.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("customer")
@Api(value = "Customer Finance Management")
public class CustomerController {

    @Autowired
    CustomerManager customerManager;

    @ApiOperation(value = "Adding customer details" , response = Customer.class)
    @PostMapping(path = "/add" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest){
       Customer customer = customerManager.addCustomer(customerRequest);
       return new ResponseEntity(customer,OK);
    }

    @ApiOperation("Getting all customer details")
    @ApiResponses(
            value = {
                   @ApiResponse(code = 200, message =  "successfully added")
            })
    @GetMapping( path = "/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCustomer(){
        List<Customer> customerList = customerManager.getCustomerList();
        return new ResponseEntity(customerList,OK);
    }

    @ApiOperation(value = "Getting customer details by id", response = Customer.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message =  "successfully added", response = Customer.class)
            })
    @GetMapping( path = "/getById/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCustomerById(@PathVariable(required = true) Long id){
        Customer customer = customerManager.getCustomer(id);
        return new ResponseEntity(customer,OK);
    }




    @ApiOperation("deleting customer details")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(required = true) Long id){
        try {
            customerManager.deleteCustomer(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(OK);
    }
}
