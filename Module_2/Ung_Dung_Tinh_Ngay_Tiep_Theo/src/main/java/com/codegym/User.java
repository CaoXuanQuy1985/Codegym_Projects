package com.codegym;

import java.util.Scanner;

public class User {
    private static Scanner sc;
    private String dataUser;

    public User(String dataUser) {
        this.dataUser = dataUser;
    }

    public String getDataUser() {
        return this.dataUser;
    }

    public void setDataUser(String dataUser) {
        this.dataUser = dataUser;
    }

    public static String getInputData() {
        sc = new Scanner(System.in);
        
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }

        return null;
    }
}