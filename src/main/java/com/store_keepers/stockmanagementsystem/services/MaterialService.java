package com.store_keepers.stockmanagementsystem.services;

import com.store_keepers.stockmanagementsystem.domains.Materials;
import com.store_keepers.stockmanagementsystem.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public Materials addMaterial(Materials store) {
        for(Long i=1L; i <= materialRepository.count(); i++){
            if(materialRepository.findById(i).equals(store)){
                return null;
            }
        }
        //no duplication of materials with the same properties
        //String purchaser = store.getPurchaser().getFirstName(); for reporting
        return materialRepository.save(store);
    }

    public Iterable<Materials> showMaterials() {
        return materialRepository.findAll();
    }


    public Materials findMaterial(Long id) {
        if(materialRepository.existsById(id)){
            return materialRepository.findById(id).get();
        }
        return null;
    }

}
