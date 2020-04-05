package com.codegym;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Employee implements Comparator<Employee> {
    protected String fullName;
    protected boolean isMale;
    protected String dateBirth;

    public Employee(String fullName, boolean isMale, String dateBirth) {
        this.fullName = fullName;
        this.isMale = isMale;
        this.dateBirth = dateBirth;
    }

    protected LocalDate convertStringDateBirth(String dateBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy", Locale.ENGLISH);
        LocalDate dateObj = LocalDate.parse(dateBirth, formatter);

        return dateObj;
    }

    protected long convertToSecond(LocalDate localDate) {
        long timeInDays = localDate.toEpochDay();
        long timeInSeconds = timeInDays * 24 * 60 * 60;

        return timeInSeconds;
    }

    public abstract String toString();
}