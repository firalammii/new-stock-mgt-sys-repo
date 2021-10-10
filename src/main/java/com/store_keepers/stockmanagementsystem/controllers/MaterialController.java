package com.store_keepers.stockmanagementsystem.controllers;

import com.store_keepers.stockmanagementsystem.domains.Material;
import com.store_keepers.stockmanagementsystem.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("/material/add")
    public Material addMaterial(@RequestBody Material store){
        return materialService.addMaterial(store);
    }

    @GetMapping("/material/list")
    public Iterable<Material> listMaterials(){
        return materialService.listMaterials();
    }

    @GetMapping("/material/list/{id}")
    public Material findMaterialById(@PathVariable Long id){
        //Long itemId = Long.valueOf(id);
        return materialService.findMaterialById(id);
    }

}
