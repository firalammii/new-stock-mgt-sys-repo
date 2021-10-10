package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Admin;
import com.store_keepers.stockmanagementsystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/signup")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @GetMapping("/admin/list")
    public Iterable<Admin> listAllAdmins(){
        return adminService.listAllAdmins();
    }

    @GetMapping("/admin/list/{companyId}")
    public Admin findAdminByCompanyId(@PathVariable Long companyId){
        return adminService.findAdminByCompanyId(companyId);
    }
}
