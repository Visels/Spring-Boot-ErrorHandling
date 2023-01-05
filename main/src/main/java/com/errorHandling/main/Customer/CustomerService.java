package com.errorHandling.main.Customer;


import com.errorHandling.main.Security.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerService {



    private String USER_ALREADY_EXISTS = "The user %s already exists";
    CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public Customer addCustomer(Customer newCustomer){

        //check if customer already exists

        boolean customerAlreadyExists = customerRepository.findByEmail(newCustomer.getEmail()).isPresent();

        if(customerAlreadyExists){
            throw new IllegalStateException(String.format(USER_ALREADY_EXISTS, newCustomer.getEmail()));
        }

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
