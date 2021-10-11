package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.domains.Sales;
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

    public Sales addSales(Sales sales){
        return salesRepository.save(buildSales(sales));
    }


    public Sales buildSales(Sales sales){
        Sales theSales=sales;
        Material material;
        Employee employee;
        Customer customer;

        customer = customerService.findCustomerById(sales.getCustomerId());
        theSales.setCustomerFullName(customer.getFirstName()+" "+customer.getMiddleName());
        theSales.setCustomerPhoneNumber(customer.getPhoneNumber());
        theSales.setNoOfItem(customer.getNoOfItem());
        theSales.setPrice(customer.getPrice());

        employee = employeeService.findEmployee(customer.getSellerId());
        theSales.setSellerFullName(employee.getFirstName()+" "+employee.getMiddleName());

        material = materialService.findMaterialById(customer.getItemId());
        theSales.setItemCategory(material.getCategory());
        theSales.setItemName(material.getItemName());

        //updating the noOfItems in Material database
        int newNoOfItem = material.getNoOfItem()-sales.getNoOfItem();
        material.setNoOfItem(newNoOfItem);

        //updating noOfVisit for customer
        customer.setNoOfVisit(customer.getNoOfVisit()+1);

        return theSales;
    }

    public Iterable<Sales> listSales(){
        return salesRepository.findAll();
    }
}
