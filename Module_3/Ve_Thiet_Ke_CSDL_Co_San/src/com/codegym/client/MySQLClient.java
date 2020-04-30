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
            String createTableStr = "create table if not exists shopdatabase.customers" +
                                             "(" +
                                                "customerNumber int(11) not null primary key," +
                                                "customerName varchar(50) not null," +
                                                "contactLastName varchar(50) not null," +
                                                "contactFirstName varchar(50) not null," +
                                                "phone varchar(50) not null," +
                                                "addressLine1 varchar(50) not null," +
                                                "addressLine2 varchar(50) default null," +
                                                "city varchar(50) not null," +
                                                "state varchar(50) default null," +
                                                "postalCode varchar(50) default null," +
                                                "country varchar(50) not null," +
                                                "salesRepEmployeeNumber int(11) default null," +
                                                "creditLimit decimal(10,2) default null" +
                                             ");";
            executeObj.execute(createTableStr);
            createTableStr = "create table if not exists shopdatabase.employees" +
                                    "(" +
                                        "employeeNumber int(11) not null primary key," +
                                        "lastName varchar(50) not null," +
                                        "firstName varchar(50) not null," +
                                        "extension varchar(10) not null," +
                                        "email varchar(100) not null," +
                                        "officeCode varchar(10) not null," +
                                        "reportsTo int(11) default null," +
                                        "jobTitle varchar(50) not null" +
                                    ");";
            executeObj.execute(createTableStr);

            String modifyTableStr = "alter table " +
                                                                "shopdatabase.customers add " +
                                                                           "foreign key(salesRepEmployeeNumber) references shopdatabase.employees(employeeNumber);";
            executeObj.execute(modifyTableStr);

            modifyTableStr = "alter table shopdatabase.employees" +
                                                                                        " add foreign key(reportsTo) references shopdatabase.employees(employeeNumber);";
            executeObj.execute(modifyTableStr);

            createTableStr = "create table shopdatabase.payments" +
                                    "(" +
                                        "customerNumber int(11) not null," +
                                        "checkNumber varchar(50) not null," +
                                        "primary key(customerNumber, checkNumber)," +
                                        "foreign key(customerNumber) references shopdatabase.customers(customerNumber)," +
                                        "paymentDate date not null," +
                                        "amount decimal(10,2) not null" +
                                    ");";
            executeObj.execute(createTableStr);

            createTableStr = "create table shopdatabase.orders" +
                                    "(" +
                                        "orderNumber int(11) not null primary key," +
                                        "orderDate date not null," +
                                        "requiredDate date not null," +
                                        "shippedDate date," +
                                        "status varchar(15) not null," +
                                        "comment text," +
                                        "customerNumber int(11) not null," +
                                        "foreign key(customerNumber) references shopdatabase.customers(customerNumber)" +
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
