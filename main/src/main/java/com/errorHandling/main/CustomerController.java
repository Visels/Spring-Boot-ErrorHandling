package com.errorHandling.main;


import com.errorHandling.main.Customer.Customer;
import com.errorHandling.main.Customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/customer")
@AllArgsConstructor
public class CustomerController {


    private String USER_EMAIL_NOT_FOUND = "The user %s does not exist";

    CustomerService customerService;

    @GetMapping(path = "/find/{id}")
    public ResponseEntity getCustomer (@PathVariable("id") String email) {

        Optional<Customer> foundCustomer = customerService.findCustomerByEmail(email);

        return new ResponseEntity(foundCustomer, HttpStatus.OK);



    }

}
