package com.errorHandling.main.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Long, Customer> {

    Optional<Customer> findByEmail(String email);

}
