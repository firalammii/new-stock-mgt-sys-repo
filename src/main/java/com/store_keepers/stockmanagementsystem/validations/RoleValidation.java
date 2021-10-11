package com.store_keepers.stockmanagementsystem.validations;

public class RoleValidation {

    public static int checkRole(String role){
        if(role.equalsIgnoreCase("admin")){
            return 1;
        }
        if(role.equalsIgnoreCase("sales")){
            return 2;
        }
        if(role.equalsIgnoreCase("purchaser")){
            return 3;
        }
        return 0;
    }
}
