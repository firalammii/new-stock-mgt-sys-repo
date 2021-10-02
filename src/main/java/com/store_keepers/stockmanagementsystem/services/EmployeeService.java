package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){

        //validation for unique phone number, not to increase the id automatically
        String exists;
        for(Long i=1L; i<= employeeRepository.count(); i++){
            exists= findEmployee(i).getPhoneNumber();
            if(exists.equals(employee.getPhoneNumber())){
                return null;
            }
        }
        return employeeRepository.save(employee);

    }

    public Iterable<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployee(Long Id) {
        return employeeRepository.findById(Id).get();
    }

}

