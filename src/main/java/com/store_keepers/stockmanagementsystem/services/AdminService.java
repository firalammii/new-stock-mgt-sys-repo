package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.controllers.EmployeeController;
import com.store_keepers.stockmanagementsystem.domains.Admin;
import com.store_keepers.stockmanagementsystem.domains.Employee;
import com.store_keepers.stockmanagementsystem.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EmployeeService employeeService ;

    public Admin createAdmin(Admin admin){
        //validation because admin has to be member of company employee
        Employee employee = employeeService.findEmployee(admin.getCompanyId());
        if(employee == null){
            return null;
        }

        //Admin has to be assigned "Admin" in employee table in role column
        if( !(employee.getRole().equals("Admin"))){
            return null;
        }

        //no need for double registration if admin already exists in admins table
        Long adminID = admin.getCompanyId();
        Admin existingAdmin = findAdminByCompanyId(adminID);

        //if existingAdmin = null then this admin is entry
        //if existingAdmin contains sth, then this admin already exists
        if(existingAdmin != null){
            return null;
        }

        //if all good then admin building and saving
        Admin theAdmin = buildAdmin(employee, admin);
        return adminRepository.save(theAdmin);
    }

    public Admin findAdminByCompanyId( Long companyId) {

        Admin existingAdmin;
        for(Long id=1L; id <= adminRepository.count(); id++){
            existingAdmin = adminRepository.findById(id).get();
            if(existingAdmin.getCompanyId().equals(companyId)){
                return existingAdmin;
            }
        }
        return null;
    }

    public Admin buildAdmin(Employee employee, Admin admin){

        Admin theAdmin = new Admin();

        theAdmin.setFirstName(employee.getFirstName());
        theAdmin.setMiddleName(employee.getMiddleName());
        theAdmin.setLastName(employee.getLastName());
        theAdmin.setEmail(employee.getEmail());
        theAdmin.setPhoneNumber(employee.getPhoneNumber());
        theAdmin.setPassword(admin.getPassword());
        theAdmin.setCompanyId(admin.getCompanyId());

        return theAdmin;
    }

    public Iterable<Admin> listAllAdmins(){
        return adminRepository.findAll();
    }

}
