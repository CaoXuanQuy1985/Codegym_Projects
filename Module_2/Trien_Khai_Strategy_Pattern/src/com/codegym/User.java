package com.codegym;

public class User {
    public static void main(String[] args) {
        User user = new User();
        UserController control = new UserController(new XMLStorage());
        UserController control2 = new UserController(new MysqlStorage());

        control.store();
        control2.store();
    }
}


