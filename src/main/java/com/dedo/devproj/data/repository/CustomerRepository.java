package com.dedo.devproj.data.repository;

import com.dedo.devproj.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
