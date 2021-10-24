package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{}
