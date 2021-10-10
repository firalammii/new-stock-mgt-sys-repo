package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Sales;
import com.store_keepers.stockmanagementsystem.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Sales addSales(Sales sales){
        return salesRepository.save(sales);
    }
}
