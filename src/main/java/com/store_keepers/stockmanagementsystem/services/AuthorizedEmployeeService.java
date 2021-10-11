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

    public AuthorizedEmployee createAuthorizedEmployee(AuthorizedEmployee authorizedEmployee){
        //validation because admin has to be member of company employee
        Employee employee = employeeService.findEmployee(authorizedEmployee.getCompanyId());
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
        for(Long id = 1L; id <= authorizedEmployeeRepository.count(); id++){
            existingAuthorizedEmployee = authorizedEmployeeRepository.findById(id).get();
            if(existingAuthorizedEmployee.getCompanyId().equals(companyId)){
                return existingAuthorizedEmployee;
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
        AuthorizedEmployee authorizedEmployee = findAuthorizedEmployeeByCompanyId(companyId);
        if(authorizedEmployee.equals(null)){
            return null;
        }
        if(!(password.equals(authorizedEmployee.getPassword()))){
            return null;
        }

        return authorizedEmployee.getRole();
    }

}
