package com.codegym;

public class ValidatePhoneNumberClient {
    public static void main(String[] args) {
        ValidatePhoneNumber vac = new ValidatePhoneNumber();
        System.out.println("Hãy nhập 1 số điện thoại để kiểm tra: ");
        String phoneNumber = vac.getPhoneNumber();
        boolean result = vac.isValidatePhoneNumber(phoneNumber);
        System.out.println(result);
    }
}