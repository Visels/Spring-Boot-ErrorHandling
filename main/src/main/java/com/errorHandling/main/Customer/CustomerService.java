package com.errorHandling.main.Customer;


import com.errorHandling.main.Security.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {


    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;



    public Customer addCustomer(Customer newCustomer){

        //TODO: encrypt the password

        String encodedPassword = passwordEncoder.encode(newCustomer.getPassword());
        newCustomer.setPassword(encodedPassword);
        customerRepository.save(newCustomer);


        return newCustomer;
    }


    //find customer by email
    public Optional findCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }

}
