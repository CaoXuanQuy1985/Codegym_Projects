package com.codegym.client;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;
import java.sql.*;

public class MySQLClient {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
    private static String user;
    private static String pass;
    private static Connection conn;

    public static void main(String[] args) {
        user = "root";
        pass = "11100001";
        try {
            MySQLConnect mySQL = new MySQLConnect(jdbcURL);
            mySQL.setDBDriver();
            mySQL.setCredentials(user, pass);
            conn = mySQL.openConnection(jdbcURL);

            MySQLExecute executeObj = new MySQLExecute(conn);
            String createTableStr = "create table if not exists account_bank.customers" +
                                             "(" +
                                                "customer_number int(11) not null primary key," +
                                                "fullName varchar(50) not null," +
                                                "address varchar(30) not null," +
                                                "email varchar(30)," +
                                                "phone varchar(11) not null" +
                                             ");";
            executeObj.execute(createTableStr);

            createTableStr = "create table if not exists account_bank.accounts" +
                                    "(" +
                                        "account_number int(11) not null primary key," +
                                        "account_type varchar(20) not null," +
                                        "account_date date not null," +
                                        "balance decimal(10,4) not null," +
                                        "customer_number int(11) not null," +
                                        "foreign key(customer_number) references account_bank.customers(customer_number)" +
                                    ");";
            executeObj.execute(createTableStr);

            createTableStr = "create table if not exists account_bank.transitions" +
                                    "(" +
                                        "tran_number int(11) not null primary key," +
                                        "tran_date date not null," +
                                        "amounts decimal(10,4) not null," +
                                        "descriptions text," +
                                        "account_number int(11) not null," +
                                        "foreign key(account_number) references account_bank.accounts(account_number)" +
                                    ");";
            executeObj.execute(createTableStr);
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
