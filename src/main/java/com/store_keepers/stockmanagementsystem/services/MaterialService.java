package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    private int minimumStockBalance = 10;

    @Autowired
    private MaterialRepository materialRepository;

    public Material addMaterial(Material store) {
        for(Long i=1L; i <= materialRepository.count(); i++){
            if(materialRepository.findById(i).equals(store)){
                return null;
            }
        }
        //no duplication of materials with the same properties
        //String purchaser = store.getPurchaser().getFirstName(); for reporting
        return materialRepository.save(store);
    }

    public Iterable<Material> listMaterials() {
        return materialRepository.findAll();
    }

    public Material findMaterialById(Long id) {
        if(materialRepository.existsById(id)){
            return materialRepository.findById(id).get();
        }
        return null;
    }

    public String checkMinimumStockBalance(){

        Material material;

        for(Long id = 1L; id <= materialRepository.count(); id++){
            material = findMaterialById(id);
            if(material.getNoOfItem() <= minimumStockBalance){

                return "minimum stock balance is reached for Material: " + material.getItemName();
            }
        }
        return null;
    }

}
