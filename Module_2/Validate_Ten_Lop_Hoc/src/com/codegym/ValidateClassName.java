package com.codegym;

import java.util.regex.*;
import java.util.Scanner;

public class ValidateClassName {
    private static Scanner sc;
    private static final String REGEX_CLASS = "^[CAP][0-9]{4}[GKIKLM]$";
    private Pattern pattern;
    private Matcher matcher;

    public ValidateClassName() {
        this.pattern = Pattern.compile(REGEX_CLASS);
    }

    public boolean isValidateClass(String account) {
        this.matcher = this.pattern.matcher(account);

        return this.matcher.matches();
    }

    public String getClassName() {
        sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        return getClassName();
    }
}