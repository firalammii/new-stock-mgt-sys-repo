package com.store_keepers.stockmanagementsystem.repositories;

import com.store_keepers.stockmanagementsystem.domains.AuthorizedEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizedEmployeeRepository extends CrudRepository<AuthorizedEmployee, Long> {
}
