package com.amigoscode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoscode.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
