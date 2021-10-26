package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.AuthorizedEmployee;
import com.store_keepers.stockmanagementsystem.services.AuthorizedEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizedEmployeeController {

    @Autowired
    private AuthorizedEmployeeService authorizedEmployeeService;

    @PostMapping("/authorizedEmployee/signup")
    public String createAuthorizedEmployee(@RequestBody AuthorizedEmployee authorizedEmployee){

        AuthorizedEmployee authorizedEmployee1 = authorizedEmployeeService.createAuthorizedEmployee(authorizedEmployee);

        return authorizedEmployee1.getRole() + " " + authorizedEmployee1.getFirstName() +
                " " + authorizedEmployee1.getMiddleName();
    }

    @PostMapping("/authorizedEmployee/login")
    public String authenticator(@RequestBody AuthorizedEmployee authorizedEmployee){

        Long companyId = authorizedEmployee.getCompanyId();
        String password = authorizedEmployee.getPassword();

        return authorizedEmployeeService.authenticator(companyId, password);
    }

    @GetMapping("/authorizedEmployee/list")
    public Iterable<AuthorizedEmployee> listAllAdmins(){

        return authorizedEmployeeService.listAllAdmins();
    }

    @GetMapping("/authorizedEmployee/list/{companyId}")
    public AuthorizedEmployee findAuthorizedEmployeeByCompanyId(@PathVariable Long companyId){

        return authorizedEmployeeService.findAuthorizedEmployeeByCompanyId(companyId);
    }
}
