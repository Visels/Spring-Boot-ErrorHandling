package com.errorHandling.main.Registration;


import com.errorHandling.main.Customer.Customer;
import com.errorHandling.main.Customer.CustomerRepository;
import com.errorHandling.main.Customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private String EMAIL_NOT_VALID_MESSAGE = "The email %s is not valid";

    CustomerService customerService;


    public Customer registerCustomer(RegistrationRequest request){

        //check email validity
        EmailValidator emailValidator = new EmailValidator();

        boolean isEmailValid = emailValidator.check(request.getEmail());


        if(!isEmailValid) {
            throw new IllegalStateException(String.format(EMAIL_NOT_VALID_MESSAGE, request.getEmail()));
        }


         return   customerService.addCustomer(new Customer(
                    request.getEmail(),
                    request.getFirstName(),
                    request.getLastName(),
                    request.getPassword()
            ));




    }


}
