package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long>{}
