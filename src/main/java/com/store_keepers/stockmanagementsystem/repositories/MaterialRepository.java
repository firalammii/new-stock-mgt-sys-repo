package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.Material;
import org.springframework.data.repository.CrudRepository;


public interface MaterialRepository extends CrudRepository<Material, Long>{}
