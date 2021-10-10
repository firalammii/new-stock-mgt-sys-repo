package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.repositories.EmployeeRepository;
import com.store_keepers.stockmanagementsystem.validations.AgeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){

        //Age validation
        int age = AgeValidation.calculateAge(employee.getBirthDate());
        if(age > 40 || age < 18){
            return null;
        }
       // validation for unique phone number, not to increase the id automatically
        Employee employeeExists;
        String phoneNumExists;
        for(Long id=1L; id <= employeeRepository.count(); id++){
            employeeExists = findEmployee(id);
            //exists= findEmployee(id).getPhoneNumber();
            //phoneNumExists = employeeExists.getPhoneNumber();
            if(employeeExists.getPhoneNumber().equals(employee.getPhoneNumber())){
                return null;
            }
        }

        return employeeRepository.save(employee);

    }

    public Iterable<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployee(Long Id) {
        boolean isPresent =  employeeRepository.findById(Id).isPresent();
        if(isPresent){
            return employeeRepository.findById(Id).get();
        }
        return null;
    }

}

