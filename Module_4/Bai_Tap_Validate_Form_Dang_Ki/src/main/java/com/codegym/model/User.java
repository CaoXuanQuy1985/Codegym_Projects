package com.codegym.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
    private int age;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @ValidNumberPhone
    @NotNull
    @NotEmpty
    private String phoneNumber;

    public User() {}

    public User(Long id, @NotNull @NotEmpty @Size(min = 5, max = 45) String firstName, @NotNull @NotEmpty @Size(min = 5, max = 45) String lastName, @Min(18) int age, @NotNull @NotEmpty String email, @NotNull @NotEmpty String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
