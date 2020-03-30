package com.codegym;

public class Calendar {
    boolean isLeafYear(int year) {
        // Sprint 1: throw new UnsupportedOperationException("This operator is not supported");
        // Sprint 2: return true;

        boolean isDivisionBy400 = (year % 400 == 0);
        boolean isGreaterThan0 = (year >= 0);
        boolean isDivisionBy4 = (year % 4 == 0);
        boolean isNotDivisionBy100 = (year % 100 != 0);

        if (isGreaterThan0) {
            if (isDivisionBy400)
                return true;
            else if (isDivisionBy4 && isNotDivisionBy100) 
                return true;
        }
        return false;
    }

    public int determineTotalDateInMonth(int month, int year) {
        // Sprint 1: throw new UnsupportedOperationException("This operator is not supported");
        /* Sprint 2: if (month == 2 && year == 1980) {
            return 29;
        }
        return -1;*/

        boolean isLeafYear = isLeafYear(year);
        int totalDates = 0;
        if (month < 1 || month > 12) {
            return -1;
        } else {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDates = 30;
                    break;
                case 2:
                    if (isLeafYear)
                        totalDates = 29;
                    else
                        totalDates = 28;
                    break;
                default:
                    totalDates = 31;
                    break;
            }
        }

        return totalDates;
    }
}