package com.errorHandling.main.Customer;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            allocationSize = 1,
            sequenceName = "customer_sequence"
    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;


    public Customer(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public  void setPassword(String encodedPassword) {
    this.password = encodedPassword;
    }
}
