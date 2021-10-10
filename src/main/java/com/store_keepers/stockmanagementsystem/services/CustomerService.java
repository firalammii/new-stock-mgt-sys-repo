package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    public Customer listCustomerByPhoneNumber(String phoneNumber) {
        Customer customer;
        for(Long id=1L; id <= customerRepository.count(); id++){
            customer = customerRepository.findById(id).get();
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }

        }
        return null;
    }
}
