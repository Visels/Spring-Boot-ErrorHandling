package com.errorHandling.main.Registration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.NoRepositoryBean;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class RegistrationRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String password;


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
}
