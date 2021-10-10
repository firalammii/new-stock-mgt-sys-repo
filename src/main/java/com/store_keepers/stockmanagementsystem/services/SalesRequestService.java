package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.repositories.SalesRequestRepository;
import com.store_keepers.stockmanagementsystem.sellingObject.SalesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRequestService {

    @Autowired
    private SalesRequestRepository salesRequestRepository;

    @Autowired
    private MaterialService materialService;


    public SalesRequest sell(SalesRequest salesRequest){

        doSelling(salesRequest);
        return salesRequestRepository.save(salesRequest);
    }

    public void doSelling(SalesRequest salesRequest){

        Material material = materialService.findMaterialById(salesRequest.getMaterialId());
        material.setNoOfItem(salesRequest.getNoOfItemsSold());

    }
}
