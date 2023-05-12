package com.fin.shop.manager;

import com.fin.shop.api.CustomerRequest;
import com.fin.shop.model.Customer;
import com.fin.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomerList(){
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();
        return customerList;
    }

    public Customer getCustomer(Long id){
        Optional<Customer> customer =  customerRepository.findById(id);
        return customer.get();
    }

    public Customer addCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setAddress(customerRequest.getAddress());
        customer.setDate(new Date());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        Customer customer1 = customerRepository.save(customer);
        return customer1;
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
