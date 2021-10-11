package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer/list")
    public Iterable<Customer> listCustomer(){
        return customerService.listCustomer();
    }

    @GetMapping("/customer/list/{phoneNumber}")
    public Customer listCustomerByPhoneNumber(@PathVariable String phoneNumber){
        return customerService.findCustomerByPhoneNumber(phoneNumber);
    }
}
