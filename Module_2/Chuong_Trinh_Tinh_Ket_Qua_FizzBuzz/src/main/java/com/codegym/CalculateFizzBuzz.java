package com.codegym;

public class CalculateFizzBuzz {
    private static int[] arrayDiv;

    private boolean isNumberExist(int number, int numberToCheck) {
        int[] arrayDiv = new int[2];

        arrayDiv[0] = number / 10;
        arrayDiv[1] = number % 10;

        if (arrayDiv[0] == numberToCheck || arrayDiv[1] == numberToCheck) {
            return true;
        }
        return false;
    }

    String checkFizzBuzz(int number) {
        // Sprint 1: throw new UnsupportedOperationException("This operator is not supported");

        String result = "";
        boolean isDivisionBy3 = (number % 3 ==  0);
        boolean isDivisionBy5 = number % 5 == 0;

        if (isDivisionBy3 || isNumberExist(number, 3)) {
            result = "Fizz";
            if (isDivisionBy5 || isNumberExist(number, 5)) {
                result = "FizzBuzz";
                return result;
            }
        } 
        else if (isDivisionBy5 || isNumberExist(number, 5)) {
            result = "Buzz";
        }
        else {
            result += number;
        }

        return result;
    }
}