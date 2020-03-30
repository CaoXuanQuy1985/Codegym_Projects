package com.codegym;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationCalendarTest {
    private static ApplicationCalendar app = new ApplicationCalendar();

    @Test
    public void findNextDateTest() {
        int dateToCheck = 1;
        int monthToCheck = 1;
        int yearToCheck = 2018;
        
        String expectedResult = "02/01/2018";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void findNextDateTest2() {
        int dateToCheck = 31;
        int monthToCheck = 1;
        int yearToCheck = 2018;
        
        String expectedResult = "01/02/2018";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void findNextDateTest3() {
        int dateToCheck = 30;
        int monthToCheck = 4;
        int yearToCheck = 2018;
        
        String expectedResult = "01/05/2018";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void findNextDateTest4() {
        int dateToCheck = 28;
        int monthToCheck = 2;
        int yearToCheck = 2018;
        
        String expectedResult = "01/03/2018";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void findNextDateTest5() {
        int dateToCheck = 29;
        int monthToCheck = 2;
        int yearToCheck = 2020;
        
        String expectedResult = "01/03/2020";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void findNextDateTest6() {
        int dateToCheck = 31;
        int monthToCheck = 12;
        int yearToCheck = 2020;
        
        String expectedResult = "01/01/2021";
        String resultActual = app.findNextDate(dateToCheck, monthToCheck, yearToCheck);

        assertEquals(expectedResult, resultActual);
    }
}