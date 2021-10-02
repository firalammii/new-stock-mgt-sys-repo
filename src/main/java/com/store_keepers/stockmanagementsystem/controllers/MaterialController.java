package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Materials;
import com.store_keepers.stockmanagementsystem.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("/materials/add")
    public Materials addMaterial(@RequestBody Materials store){
        return materialService.addMaterial(store);
    }

    @GetMapping("/materials/list")
    public Iterable<Materials> materialList(){
        return materialService.showMaterials();
    }

    @GetMapping("/materials/list/{id}")
    public Materials findMaterial(@PathVariable Long id){
        return materialService.findMaterial(id);
    }
}
