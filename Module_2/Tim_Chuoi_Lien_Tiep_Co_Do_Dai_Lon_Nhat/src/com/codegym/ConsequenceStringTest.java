package com.codegym;

public class ConsequenceStringTest {
    public static void main(String[] args) {
        ConsequenceString cs = new ConsequenceString();
        cs.findMaxLength("abcabcdgabxy");

        ConsequenceString cs2 = new ConsequenceString();
        cs2.findMaxLength("abcabcdgabmnsxy");

        ConsequenceString cs3 = new ConsequenceString();
        cs3.findMaxLength("abcefgjklmnedfg");

        ConsequenceString cs4 = new ConsequenceString();
        cs4.findMaxLength("abcabcdgabxyabcabcdgabmnsxyabcefgjklmnedfg");
    }
}