package com.codegym;

public class MysqlStorage implements UserStorage {
    public void store() {
        System.out.println("Store user into database mysql");
    }
}
