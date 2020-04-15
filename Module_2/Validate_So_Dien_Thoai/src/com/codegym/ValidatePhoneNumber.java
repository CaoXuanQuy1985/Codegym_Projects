package com.codegym;

import java.util.regex.*;
import java.util.Scanner;

public class ValidatePhoneNumber {
    private static Scanner sc;
    private static final String REGEX_PHONE = "\\(\\d{2}\\)\\-\\(0[0-9]{9}\\)";
    private Pattern pattern;
    private Matcher matcher;

    public ValidatePhoneNumber() {
        this.pattern = Pattern.compile(REGEX_PHONE);
    }

    public boolean isValidatePhoneNumber(String account) {
        this.matcher = this.pattern.matcher(account);

        return this.matcher.matches();
    }

    public String getPhoneNumber() {
        sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        return getPhoneNumber();
    }
}