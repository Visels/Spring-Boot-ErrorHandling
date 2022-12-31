package com.errorHandling.main.Controller;


import com.errorHandling.main.Customer.Customer;
import com.errorHandling.main.Customer.CustomerService;
import com.errorHandling.main.Response.ResponseHandler;
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


    // getting customer
    @GetMapping(path = "/find/{id}")
    public ResponseEntity getCustomer (@PathVariable("id") String email) {

        return ResponseHandler.responseBuilder(
                "Customer details as requested",
                HttpStatus.OK,
                customerService.findCustomerByEmail(email)
        );
    }


    //adding new customer
    @PostMapping(path = "/add")
    public ResponseEntity addCustomer(@RequestBody Customer newCustomer){

        return ResponseHandler.responseBuilder(
                "Customer added successfully",
                HttpStatus.ACCEPTED,
                customerService.addCustomer(newCustomer)
        );
    }
}
