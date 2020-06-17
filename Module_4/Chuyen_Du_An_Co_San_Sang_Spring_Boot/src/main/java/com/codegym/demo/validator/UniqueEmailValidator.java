package com.codegym.demo.validator;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class UniqueEmailValidator implements ConstraintValidator<com.codegym.demo.validator.UniqueEmail, Customer> {
    @Autowired
    private CustomerService customerService;

    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
        return customerService
                .findAll()
                .stream()
                .filter(c -> isSameEmail(value, c))
                .allMatch(c -> isSameId(value, c));
    }

    private boolean isSameEmail(Customer c1, Customer c2) {
        return Objects.equals(c1.getEmail(), c2.getEmail());
    }

    private boolean isSameId(Customer c1, Customer c2) {
        return Objects.equals(c1.getId(), c2.getId());
    }
}