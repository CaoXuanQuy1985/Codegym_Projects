package com.codegym;

public class DatabaseClient {
    public static void main(String[] args) {
        EmployeeDatabase<Employee> database = new EmployeeDatabase<Employee>();

        MaleEmployee male1 = new MaleEmployee("male1", true, "21 01 1985");
        MaleEmployee male2 = new MaleEmployee("male2", true, "10 02 1980");
        MaleEmployee male3 = new MaleEmployee("male3", true, "01 02 1990");
        MaleEmployee male4 = new MaleEmployee("male4", true, "12 05 1975");

        FeMaleEmployee female1 = new FeMaleEmployee("female1", false, "18 03 1987");
        FeMaleEmployee female2 = new FeMaleEmployee("female2", false, "12 07 1982");
        FeMaleEmployee female3 = new FeMaleEmployee("female3", false, "11 08 1998");
        FeMaleEmployee female4 = new FeMaleEmployee("female4", false, "12 03 1972");

        database.insertEmployeeToDatabase(male1);
        database.insertEmployeeToDatabase(male2);
        database.insertEmployeeToDatabase(male3);
        database.insertEmployeeToDatabase(male4);

        database.insertEmployeeToDatabase(female1);
        database.insertEmployeeToDatabase(female2);
        database.insertEmployeeToDatabase(female3);
        database.insertEmployeeToDatabase(female4);

        database.showDatabase();
        database.sortDateBirth(male1);
        System.out.println("Sau khi sap xep databse tro thanh: ");
        database.showDatabase();
        System.out.println("Sắp xếp nhân viên nữ lên trước nhân viên nam mà vẫn giữ nguyên thuộc tính ngày tháng nắm sinh đã được sắp xép từ trước");
        database.demergingListEmployee();
    }
}