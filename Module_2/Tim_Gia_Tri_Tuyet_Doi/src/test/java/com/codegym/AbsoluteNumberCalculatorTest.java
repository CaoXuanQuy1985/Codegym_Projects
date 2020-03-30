package com.codegym;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class AbsoluteNumberCalculatorTest {
    @Test
    public void testFindAbsolute() {
        int number = -5;
        int expectedResult = 5;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindAbsolute2() {
        int number = 1;
        int expectedResult = 1;

        int resultActual = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void testFindAbsolute3() {
        int number = 0;
        int expectedResult = 0;

        int resultActual = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expectedResult, resultActual);
    }
}