package com.codegym;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalendarTest {
    private static Calendar calendar = new Calendar();
    @Test
    public void isLeafYearTest() {
        int yearToCheck = 1904;
        boolean expectedResult = true;

        boolean resultActual = calendar.isLeafYear(yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void isLeafYearTest2() {
        int yearToCheck = 2019;
        boolean expectedResult = false;

        boolean resultActual = calendar.isLeafYear(yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void isLeafYearTest3() {
        int yearToCheck = 0;
        boolean expectedResult = true;

        boolean resultActual = calendar.isLeafYear(yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void isLeafYearTest4() {
        int yearToCheck = -2020;
        boolean expectedResult = false;

        boolean resultActual = calendar.isLeafYear(yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void determineTotalDateInMonthTest() {
        int monthToCheck = 2;
        int yearToCheck = 1980;
        int expectedResult = 29;

        int resultActual = calendar.determineTotalDateInMonth(monthToCheck, yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void determineTotalDateInMonthTest2() {
        int monthToCheck = 7;
        int yearToCheck = 1980;
        int expectedResult = 31;

        int resultActual = calendar.determineTotalDateInMonth(monthToCheck, yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void determineTotalDateInMonthTest3() {
        int monthToCheck = 2;
        int yearToCheck = 1999;
        int expectedResult = 28;

        int resultActual = calendar.determineTotalDateInMonth(monthToCheck, yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void determineTotalDateInMonthTest4() {
        int monthToCheck = 2;
        int yearToCheck = 2004;
        int expectedResult = 29;

        int resultActual = calendar.determineTotalDateInMonth(monthToCheck, yearToCheck);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void determineTotalDateInMonthTest5() {
        int monthToCheck = -2;
        int yearToCheck = 2004;
        int expectedResult = -1;

        int resultActual = calendar.determineTotalDateInMonth(monthToCheck, yearToCheck);
        assertEquals(expectedResult, resultActual);
    }
}