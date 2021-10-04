package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/add")
    public Employee addEmployee (@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/list")
    public Iterable<Employee> allEmployees(){
        return employeeService.allEmployees();
    }


    @GetMapping("/employee/list/{id}")
    public Employee findEmployee(@PathVariable Long id){
        return employeeService.findEmployee(id);
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello from my local intellijIDEA project";
    }

    @GetMapping("/about")
    public String about(){
        return "this is the about page that is aimed to help store management";
    }
}
