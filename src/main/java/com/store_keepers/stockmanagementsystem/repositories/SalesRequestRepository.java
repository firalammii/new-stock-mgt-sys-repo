package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.sellingObject.SalesRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRequestRepository extends CrudRepository<SalesRequest, Long> {
}
