package com.codegym;
import java.lang.Math;

public class AbsoluteNumberCalculator {
    public static int findAbsolute(int number) {
        //throw new UnsupportedOperationException("This operator has been not supported");
        //return 5;

        //return Math.abs(number);
        //Or
        return (number >= 0) ? number : -number;
    }
}