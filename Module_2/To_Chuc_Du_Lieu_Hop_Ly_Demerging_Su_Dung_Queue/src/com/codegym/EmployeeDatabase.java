package com.codegym;

import java.util.Queue;
import java.util.LinkedList;

public class EmployeeDatabase<T extends Employee> {
    private LinkedList<T> listEmployee;
    private Queue<T> queueMale;
    private Queue<T> queueFemale;

    public EmployeeDatabase() {
        this.listEmployee = new LinkedList<T>();
        this.queueMale = new LinkedList<T>();
        this.queueFemale = new LinkedList<T>();
    }

    public void insertEmployeeToDatabase(T elem) {
        this.listEmployee.addLast(elem);
    }

    public LinkedList<T> sortDateBirth(Employee employee) {
        listEmployee.sort(employee);

        return listEmployee;
    }

    public LinkedList<T> demergingListEmployee() {
        LinkedList<T> resultList = new LinkedList<>();
        for (T emp : this.listEmployee) {
            if (emp.isMale) {
                this.queueMale.offer(emp);
            } else {
                this.queueFemale.offer(emp);
            }
        }

        while(!this.queueFemale.isEmpty()) {
            resultList.add(this.queueFemale.poll());
        }
        while(!this.queueMale.isEmpty()) {
            resultList.add(this.queueMale.poll());
        }

        for (T obj : resultList){
            System.out.println(obj);
        }
        System.out.println();

        return resultList;
    }

    public void showDatabase() {
        for (T obj : this.listEmployee) {
            System.out.println(obj);
        }
        System.out.println();
    }
}