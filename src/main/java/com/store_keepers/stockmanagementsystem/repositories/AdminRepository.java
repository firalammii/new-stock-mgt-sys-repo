package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
