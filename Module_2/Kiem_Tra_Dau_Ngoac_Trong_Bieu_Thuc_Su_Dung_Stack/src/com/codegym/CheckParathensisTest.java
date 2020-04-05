package com.codegym;

public class CheckParathensisTest {
    public static void main(String[] args) {
        String argString = "(a+b)*((b-c)/(d+a))";
        String argString2 = "s * (s – a) * (s – b) * (s – c) ";
        String argString3 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String argString4 = "s * (s – a) * (s – b * (s – c)";
        String argString5 = "s * (s – a) * s – b) * (s – c)";
        String argString6 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        String argString7 = "((a + b[c - d] * a{b + c} - {c + d) + (a*b))";

        CheckParathensis checker = new CheckParathensis();

        System.out.println(checker.isError(argString));
        System.out.println(checker.isError(argString2));
        System.out.println(checker.isError(argString3));
        System.out.println(checker.isError(argString4));
        System.out.println(checker.isError(argString5));
        System.out.println(checker.isError(argString6));
        System.out.println(checker.isError(argString7));
    }
}