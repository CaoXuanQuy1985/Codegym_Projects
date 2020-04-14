package com.codegym;

import java.util.regex.*;
import java.util.*;

public class ValidateEmailChecker {
    private static Scanner sc;
    private static final String REXGEX_VALIDATE_EMAIL = "^[^.]([^\\.]|[^\\.]\\.?[^\\.]){1,62}[^.]@[^\\.]\\.(com|org|net|in|us|info)$";
    private Pattern pattern;
    private Matcher matcher;

    public ValidateEmailChecker() {
        this.pattern = Pattern.compile(REXGEX_VALIDATE_EMAIL);
        
    }

    public boolean isValidateEmail(String emailAddress) {
        this.matcher = this.pattern.matcher(emailAddress);
        return this.matcher.matches();
    }

    public String getEmailAddress() {
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }
        System.out.println("Invalid");
        return getEmailAddress();
    }
}