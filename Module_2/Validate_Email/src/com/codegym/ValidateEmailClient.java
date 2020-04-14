package com.codegym;

public class ValidateEmailClient {
    public static void main(String[] args) {
        String test = "cun.kin1985@gmail.com"; // Valid
        String test2 = "a@gmail.com";                // Valid
        String test3 = "abc@hotmail.com";         // Invalid
        String test4 = "@hotmail.com";    // Invalid
        String test5 = "abc@gmail";    // Invalid
        String test6 = "@#abc@gmail.com";    // Invalid
        ValidateEmailChecker vec = new ValidateEmailChecker();

        System.out.println("Hãy nhập 1 địa chỉ email để check xem có hợp lệ hay không");
        String inputEmail = vec.getEmailAddress();
        boolean result = vec.isValidateEmail(inputEmail);
        System.out.println(result);
    }
}