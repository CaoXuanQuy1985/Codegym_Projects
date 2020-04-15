package com.codegym;

public class ValidateClassNameClient {
    public static void main(String[] args) {
        ValidateClassName vac = new ValidateClassName();
        String className = vac.getClassName();
        boolean result = vac.isValidateClass(className);
        System.out.println(result);
    }
}