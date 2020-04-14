package com.codegym;

import java.util.regex.*;
import java.util.Scanner;

public class ValidateAccountChecker {
    private static Scanner sc;
    private static final String REGEX_ACCOUNT = "^[a-z_0-9]{6,}$";
    private Pattern pattern;
    private Matcher matcher;

    public ValidateAccountChecker() {
        this.pattern = Pattern.compile(REGEX_ACCOUNT);
    }

    public boolean isValidateAccount(String account) {
        this.matcher = this.pattern.matcher(account);

        return this.matcher.matches();
    }

    public String getAccount() {
        sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        return getAccount();
    }
}