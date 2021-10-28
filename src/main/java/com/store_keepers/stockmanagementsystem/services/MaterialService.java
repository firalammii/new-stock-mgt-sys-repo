package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private AuthorizedEmployeeService authorizedEmployeeService;

    public Material addMaterial(Material material) {
        Long sellerId = authorizedEmployeeService.findWhoLoggedIn();
        material.setPurchaser(sellerId);

        return materialRepository.save(material);
    }

    public Iterable<Material> listMaterials() {
        return materialRepository.findAll();
    }

    public Material findMaterialById(Long id) {
        boolean isPresent =  materialRepository.findById(id).isPresent();
        if(isPresent){
            return materialRepository.findById(id).get();
        }

        return null;
    }

}
