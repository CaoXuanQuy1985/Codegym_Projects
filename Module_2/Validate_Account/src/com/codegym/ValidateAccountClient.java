package com.codegym;

public class ValidateAccountClient {
    public static void main(String[] args) {
        ValidateAccountChecker vac = new ValidateAccountChecker();
        String account = vac.getAccount();
        boolean result = vac.isValidateAccount(account);

        System.out.println(result);
    }
}