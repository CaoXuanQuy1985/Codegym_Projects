package com.codegym;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        int x = 1;
        int y = 1;

        Calculator calculator = new Calculator();
        int expResult = 2;
        int result = calculator.add(x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testAdd2() {
        int x = Integer.MAX_VALUE;
        int y = 1;

        Calculator calculator = new Calculator();
        try {
            int result = calculator.add(x, y);
            assertFalse(true);
        } catch (Exception ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testAdd3() {
        int x = Integer.MIN_VALUE;
        int y = -1;

        Calculator calculator = new Calculator();
        try {
            int result = calculator.add(x, y);
            assertFalse(true);
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
}