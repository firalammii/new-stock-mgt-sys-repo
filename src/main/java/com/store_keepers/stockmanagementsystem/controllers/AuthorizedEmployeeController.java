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
        return authorizedEmployee1.getRole();
    }

    @PostMapping("/authorizedEmployee/login")
    public String authenticator(@RequestBody AuthorizedEmployee authorizedEmployee){
        return authorizedEmployeeService.authenticator(authorizedEmployee.getCompanyId(), authorizedEmployee.getPassword());
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
