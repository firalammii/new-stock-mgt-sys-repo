package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private AuthorizedEmployeeService authorizedEmployeeService;

    public Customer createCustomer(Customer customer) {
        if(customerRepository.count() != 0){
            Customer customer1 = findCustomerByPhoneNumber(customer.getPhoneNumber());
            if(customer1 != null){
                return customer1;
            }
        }
        Material material = materialService.findMaterialById(customer.getItemId());
        customer.setItemName(material.getItemName());
        return customerRepository.save(customer);
    }

    public Iterable<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        Customer customer;
        for(Long id=1L; id <= customerRepository.count(); id++){
            customer = findCustomerById(id);

            if(customer != null){
                if(phoneNumber.equals(customer.getPhoneNumber())){
                    return customer;
                }
            }
        }
        return null;
    }
    public Customer findCustomerById(Long id){
        boolean isPresent =  customerRepository.findById(id).isPresent();
        if(isPresent){
            return customerRepository.findById(id).get();
        }
        return null;
    }

}
