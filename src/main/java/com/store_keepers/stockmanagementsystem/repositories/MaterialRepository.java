package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.Materials;
import org.springframework.data.repository.CrudRepository;


public interface MaterialRepository extends CrudRepository<Materials, Long> {
}
