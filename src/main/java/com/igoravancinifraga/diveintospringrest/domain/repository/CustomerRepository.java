package com.igoravancinifraga.diveintospringrest.domain.repository;

import com.igoravancinifraga.diveintospringrest.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByNameContaining(String name);
    Optional<Customer> findByEmail(String email);
}
