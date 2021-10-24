package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Sales;
import com.store_keepers.stockmanagementsystem.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/sales/add")
    public String addSales(@RequestBody Sales sales){
        Sales sales1 = salesService.addSales(sales);

        return sales1.getItemName()+" is sold to "+
                sales1.getCustomerFullName()+" at price: "+
                sales1.getPrice()+" by "+ sales1.getSellerFullName();
    }

    @GetMapping("/sales/list")
    public Iterable<Sales> listSales(){
        return salesService.listSales();
    }

}
