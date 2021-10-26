package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.AuthorizedEmployee;
import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.repositories.AuthorizedEmployeeRepository;
import com.store_keepers.stockmanagementsystem.validations.RoleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedEmployeeService {

    @Autowired
    private AuthorizedEmployeeRepository authorizedEmployeeRepository;

    @Autowired
    private EmployeeService employeeService ;

    @Autowired
    private MaterialService materialService;

    private  Long sellerId;
    private Employee employee;

    public AuthorizedEmployee createAuthorizedEmployee(AuthorizedEmployee authorizedEmployee){
        //validation because admin has to be member of company employee
        employee = employeeService.findEmployee(authorizedEmployee.getCompanyId());
        if(employee == null){
            return null;
        }

        //Admin has to be assigned "Admin" in employee table in role column
        int checkRole = RoleValidation.checkRole(employee.getRole());
        if( !(checkRole == 1 || checkRole == 2 || checkRole == 3)){
            return null;
        }
        //no need for double registration if admin already exists in admins table
        Long authorizedEmployeeCompanyId = authorizedEmployee.getCompanyId();
        AuthorizedEmployee existingAuthorizedEmployee = findAuthorizedEmployeeByCompanyId(authorizedEmployeeCompanyId);

        //if existingAdmin = null then this admin is entry
        //if existingAdmin contains sth, then this admin already exists
        if(existingAuthorizedEmployee != null){
            return null;
        }

        //if all good then admin building and saving

        AuthorizedEmployee theAuthorizedEmployee = buildAuthorizedEmployee(employee, authorizedEmployee);
        return authorizedEmployeeRepository.save(theAuthorizedEmployee);
    }

    public AuthorizedEmployee findAuthorizedEmployeeByCompanyId(Long companyId) {

        AuthorizedEmployee existingAuthorizedEmployee;
        boolean exists;
        for(Long id = 1L; id <= authorizedEmployeeRepository.count(); id++){
             exists = authorizedEmployeeRepository.existsById(id);
             if(exists){
                 existingAuthorizedEmployee = authorizedEmployeeRepository.findById(id).get();
                 if(companyId.equals(existingAuthorizedEmployee.getCompanyId())){
                     return existingAuthorizedEmployee;
                 }
             }
        }

        return null;

    }

    public AuthorizedEmployee buildAuthorizedEmployee(Employee employee, AuthorizedEmployee authorizedEmployee){

        AuthorizedEmployee theAuthorizedEmployee = new AuthorizedEmployee();

        theAuthorizedEmployee.setFirstName(employee.getFirstName());
        theAuthorizedEmployee.setMiddleName(employee.getMiddleName());
        theAuthorizedEmployee.setLastName(employee.getLastName());
        theAuthorizedEmployee.setEmail(employee.getEmail());
        theAuthorizedEmployee.setPhoneNumber(employee.getPhoneNumber());
        theAuthorizedEmployee.setPassword(authorizedEmployee.getPassword());
        theAuthorizedEmployee.setCompanyId(authorizedEmployee.getCompanyId());
        theAuthorizedEmployee.setRole(employee.getRole());

        return theAuthorizedEmployee;
    }

    public Iterable<AuthorizedEmployee> listAllAdmins(){
        return authorizedEmployeeRepository.findAll();
    }

    public String authenticator(Long companyId, String password){

        String error;
        String res;

        AuthorizedEmployee authorizedEmployee = findAuthorizedEmployeeByCompanyId(companyId);
        if(authorizedEmployee == null){
            error = "authorization";
            return error;
        }
        if(!(password.equals(authorizedEmployee.getPassword()))){
            error = "password";
            return error;
        }

// if the execution achieved here it implies the employee authorized to work with the database

        res = authorizedEmployee.getRole();
        res = res.toLowerCase();

        sellerId = companyId; //trace the seller while login to automatically fill the fields

        return res;
    }

    public Long findWhoLoggedIn(){
        return sellerId;
    }


}
