package com.codegym;

public class ApplicationCalendar {
    private static Calendar calendar = new Calendar();
    private int[] arrayIntDateMonth = new int[3];

    private int[] analyzeDateString(String strDate) {
        String[] arrayStrDateMonth = new String[3];

        arrayStrDateMonth = strDate.split("/");
        for (int i = 0; i < arrayIntDateMonth.length; i++) {
            arrayIntDateMonth[i] = Integer.parseInt(arrayStrDateMonth[i]);
        }

        return arrayIntDateMonth;
    }

    private String formatDateMonth(int nextDate, int nextMonth, int nextYear) {
        String resultDate;
        String nextDateStr = String.valueOf(nextDate);  
        String nextMonthStr = String.valueOf(nextMonth);

        if (nextDate >= 1 && nextDate <= 9){         
            nextDateStr = "0" + String.valueOf(nextDate);           
        } 
        if (nextMonth >= 1 && nextMonth <= 9) {
            nextMonthStr = "0" + String.valueOf(nextMonth);
        }           
        resultDate = nextDateStr + "/" + nextMonthStr + "/" + nextYear;

        return resultDate;
    }

    public String findNextDate(int dateNow, int monthNow, int yearNow) {
        // Sprint 1: throw new UnsupportedOperationException("This operator is not supported");

        int lastDateInMonth = calendar.determineTotalDateInMonth(monthNow, yearNow);
        int nextDate = dateNow,
             nextMonth = monthNow,
             nextYear = yearNow;

        if (monthNow == 12) {
            if (dateNow == lastDateInMonth) {
                nextDate = 1;
                nextMonth = 1;
                nextYear = yearNow + 1;
            } else {
                nextDate = dateNow + 1;
            }
        } else {
            if (dateNow == lastDateInMonth) {
                nextDate = 1;
                nextMonth = monthNow + 1;
            } else {
                nextDate = dateNow + 1;
            }
        }

        return formatDateMonth(nextDate, nextMonth, nextYear);
    }

    public static void main(String[] args) {
        System.out.println("Hãy nhập chuỗi ngày tháng năm để tìm ngày (tháng / năm) tiếp theo");
        System.out.println("Hướng dẫn nhập theo mẫu sau: dd/mm/yyy, ví dụ: 02/12/2020");
        String inputData = User.getInputData();

        User user = new User(inputData);

        ApplicationCalendar app = new ApplicationCalendar();
        app.analyzeDateString(user.getDataUser());
        int dateNow = app.arrayIntDateMonth[0];
        int monthNow = app.arrayIntDateMonth[1];
        int yearNow = app.arrayIntDateMonth[2];

        String nextDate = app.findNextDate(dateNow, monthNow, yearNow);
        System.out.println("Ngày (tháng / năm) tiếp theo của ngày mà bạn vừa nhập vào là: ");
        System.out.println(nextDate);
    }
}