package com.codegym;

public class Employee extends AbstractGenericData<Employee>{
    public Employee(Integer key) {
        super(key);
    }
    public String toString() {
        return "Employee[" + this.key + "]";
    }
}