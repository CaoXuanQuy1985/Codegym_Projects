package com.codegym;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateFizzBuzzTest {
    private CalculateFizzBuzz fb = new CalculateFizzBuzz();
    @Test
    public void calculateFizzBuzzTest() {
        int number = 3;
        String expected = "Fizz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest2() {
        int number = 5;
        String expected = "Buzz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest3() {
        int number = 15;
        String expected = "FizzBuzz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest4() {
        int number = 75;
        String expected = "FizzBuzz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest5() {
        int number = 100;
        String expected = "Buzz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest6() {
        int number = 23;
        String expected = "Fizz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest7() {
        int number = 39;
        String expected = "Fizz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
    @Test
    public void calculateFizzBuzzTest8() {
        int number = 59;
        String expected = "Buzz";

        String resultActual = fb.checkFizzBuzz(number);
        assertEquals(expected, resultActual);
    }
}