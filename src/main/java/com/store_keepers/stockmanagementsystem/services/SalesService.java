package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.domains.Sales;
import com.store_keepers.stockmanagementsystem.repositories.CustomerRepository;
import com.store_keepers.stockmanagementsystem.repositories.MaterialRepository;
import com.store_keepers.stockmanagementsystem.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthorizedEmployeeService authorizedEmployeeService;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public Sales addSales(Sales sales){

        Employee employee;
        Customer customer;
        Material material;

        Long sellerId = authorizedEmployeeService.findWhoLoggedIn();
        employee = employeeService.findEmployee(sellerId);
        sales.setSellerFullName(employee.getFirstName()+" "+employee.getMiddleName());

        customer = customerService.findCustomerById(sales.getCustomerId());
        sales.setCustomerFullName(customer.getFirstName()+" "+customer.getMiddleName());
        sales.setCustomerPhoneNumber(customer.getPhoneNumber());

        material = materialService.findMaterialById(sales.getItemId());
        sales.setItemCategory(material.getCategory());
        sales.setItemName(material.getItemName());

        //updating the noOfItems in Material database
        int newNoOfItem = material.getNoOfItem()-sales.getQuantity();
        material.setNoOfItem(newNoOfItem);
        materialRepository.save(material);

        //updating noOfVisit for customer
        customer.setNoOfVisit(customer.getNoOfVisit()+1);
        customer.setQuantity(sales.getQuantity());
        customer.setPrice(sales.getPrice());
        customerRepository.save(customer);

        return salesRepository.save(sales);
    }

    public Iterable<Sales> listSales(){
        return salesRepository.findAll();
    }
}
