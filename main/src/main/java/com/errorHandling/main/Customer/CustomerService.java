package com.errorHandling.main.Customer;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {


    CustomerRepository customerRepository;


    public Customer addCustomer(Customer newCustomer){
        customerRepository.save(newCustomer);

        return newCustomer;
    }


    //find customer by email
    public Optional findCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }

}
