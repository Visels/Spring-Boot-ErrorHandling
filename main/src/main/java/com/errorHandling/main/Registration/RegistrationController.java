package com.errorHandling.main.Registration;


import com.errorHandling.main.Customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/")
public class RegistrationController {

    RegistrationService registrationService;

    @PostMapping(path = "register")
    public ResponseEntity signupUser(@RequestBody RegistrationRequest request){
       Customer registeredCustomer = registrationService.registerCustomer(request);

        return new ResponseEntity(registeredCustomer, HttpStatus.ACCEPTED);
    }
}
