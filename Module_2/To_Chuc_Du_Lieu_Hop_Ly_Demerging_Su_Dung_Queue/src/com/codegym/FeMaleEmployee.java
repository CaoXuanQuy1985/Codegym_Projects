package com.codegym;

import java.time.LocalDate;

class FeMaleEmployee extends Employee {

    public FeMaleEmployee(String fullName, boolean isMale, String dateBirth) {
        super(fullName, isMale, dateBirth);
    }

    public int compare(Employee male1, Employee male2) {
        LocalDate localDate1 = male1.convertStringDateBirth(male1.dateBirth);
        LocalDate localDate2 = male2.convertStringDateBirth(male2.dateBirth);

        long timeInSeconds1 = male1.convertToSecond(localDate1);
        long timeInSeconds2 = male2.convertToSecond(localDate2);

        return (timeInSeconds1 < timeInSeconds2) ? (-1) : ((timeInSeconds1 == timeInSeconds2) ? 0 : 1);
    }


    public String toString() {
        return "Employee: " + this.fullName + ", Sex: FeMale, Date of Birth: " + this.dateBirth;
    }
}