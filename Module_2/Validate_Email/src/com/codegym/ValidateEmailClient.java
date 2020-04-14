package com.codegym;

public class ValidateEmailClient {
    public static void main(String[] args) {
        String test = "mysite..1234@yahoo.com";
        ValidateEmailChecker vec = new ValidateEmailChecker();

        System.out.println("Hãy nhập 1 địa chỉ email để check xem có hợp lệ hay không");
        String inputEmail = vec.getEmailAddress();
        boolean result = vec.isValidateEmail(inputEmail);
        System.out.println(result);
    }
}