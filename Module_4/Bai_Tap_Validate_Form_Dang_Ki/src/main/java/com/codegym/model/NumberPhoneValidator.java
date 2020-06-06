package com.codegym.model;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberPhoneValidator implements ConstraintValidator<ValidNumberPhone, String> {

    private String number;

    public NumberPhoneValidator() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void initialize(final ValidNumberPhone constraintAnnotation) {}

    @Override
    public boolean isValid(String phoneNumber, final ConstraintValidatorContext context) {
        return validatePhoneNumber(phoneNumber);
    }

    public boolean validatePhoneNumber(final String phoneNumber) {
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            return false;
        }
        if (!phoneNumber.startsWith("0")) {
            return false;
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            return false;
        }

        return true;
    }
}
