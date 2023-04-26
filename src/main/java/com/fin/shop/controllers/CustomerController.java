package com.fin.shop.controllers;

import com.fin.shop.api.CustomerRequest;
import com.fin.shop.manager.CustomerManager;
import com.fin.shop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerManager customerManager;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequest customerRequest){
       Customer customer = customerManager.addCustomer(customerRequest);
       return new ResponseEntity(customer,OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCustomer(){
        List<Customer> customerList = customerManager.getCustomerList();
        return new ResponseEntity(customerList,OK);
    }

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
