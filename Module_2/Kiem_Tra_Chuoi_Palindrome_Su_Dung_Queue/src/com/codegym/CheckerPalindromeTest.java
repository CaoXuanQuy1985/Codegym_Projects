package com.codegym;

public class CheckerPalindromeTest {
    public static void main(String[] args) {
        CheckerPalindrome check = new CheckerPalindrome();

        //System.out.println(check.isPalindrome("Able was I ere I saw Elba"));
        System.out.println("Hãy nhập 1 chuối để kiểm tra tính Palindrome: ");
        String input = check.getString();
        System.out.println(check.isPalindrome(input));
    }
}