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
    public Sales addSales(@RequestBody Sales sales){
        return salesService.addSales(sales);
    }

    @GetMapping("/sales/list")
    public Iterable<Sales> listSales(){
        return salesService.listSales();
    }

}
