package com.codegym.client;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;

import java.sql.*;

public class MySQLClient {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
    private static String user;
    private static String pass;
    private static Connection conn;

    private static final String CREATE_TABLE_CUSTOMERS = "create table if not exists database_showroom.customers" +
                                                                                    "(" +
                                                                                        "customerNumber int(11) not null primary key," +
                                                                                        "customerName varchar(50) not null," +
                                                                                        "contactLastName varchar(50) not null," +
                                                                                        "contactFirstName varchar(50) not null," +
                                                                                        "phone varchar(50) not null," +
                                                                                        "addressLine1 varchar(50) not null," +
                                                                                        "addressLine2 varchar(50) default null," +
                                                                                        "city varchar(50) not null," +
                                                                                        "state varchar(50) not null," +
                                                                                        "postalCode varchar(15) not null," +
                                                                                        "country varchar(50) not null," +
                                                                                        "creditLimit decimal(10,4) default null" +
                                                                                    ");";
    private static final String CREATE_TABLE_EMPLOYEES = "create table if not exists database_showroom.employees" +
                                                                                "(" +
                                                                                    "employeeNumber int(11) not null primary key," +
                                                                                    "lastName varchar(50) not null," +
                                                                                    "firstName varchar(50) not null," +
                                                                                    "email varchar(100) not null," +
                                                                                    "jobTitle varchar(50) not null" +
                                                                                ");";
    private static final String CREATE_TABLE_ORDERS = "create table if not exists database_showroom.orders" +
                                                                            "(" +
                                                                                "orderNumber int(11) not null primary key," +
                                                                                "orderDate date not null," +
                                                                                "requiredDate date not null," +
                                                                                "shippedDate date not null," +
                                                                                "status varchar(15) not null," +
                                                                                "comments text default null," +
                                                                                "quantityOrdered int not null," +
                                                                                "priceEach decimal(10,4) not null" +
                                                                            ");";
    private static final String CREATE_TABLE_PAYMENTS = "create table if not exists database_showroom.payments" +
                                                                                "(" +
                                                                                    "customerNumber int(11) not null," +
                                                                                    "checkNumber varchar(50) not null," +
                                                                                    "paymentDate date not null," +
                                                                                    "amount decimal(10,4) not null" +
                                                                                ");";
    private static final String CREATE_TABLE_PRODUCTIONS = "create table if not exists database_showroom.productions" +
                                                                                    "(" +
                                                                                        "productCode varchar(25) not null primary key," +
                                                                                        "productName varchar(70) not null," +
                                                                                        "productScale varchar(10) not null," +
                                                                                        "productVendor varchar(50) not null," +
                                                                                        "productDescription text not null," +
                                                                                        "quantityInStock int not null," +
                                                                                        "buyPrice decimal(10,4) not null," +
                                                                                        "MSRP decimal(10,4) not null" +
                                                                                    ");";
    private static final String CREATE_TABLE_ORDERDETAILS = "create table if not exists database_showroom.orderDetails" +
                                                                                    "(" +
                                                                                        "productCode varchar(25) not null, " +
                                                                                        "orderNumber int(11) not null, " +
                                                                                        "primary key(productCode, orderNumber), " +
                                                                                        "foreign key(productCode) references database_showroom.productions(productCode), " +
                                                                                        "foreign key(orderNumber) references database_showroom.orders(orderNumber)" +
                                                                                    ");";
    private static final String CREATE_TABLE_PRODUCTIONLINES = "create table if not exists database_showroom.productionlines" +
                                                                                            "(" +
                                                                                                "productLine varchar(50) not null primary key," +
                                                                                                "textDescription text default null," +
                                                                                                "image varchar(100) default null" +
                                                                                            ");";
    private static final String CREATE_TABLE_OFFICES = "create table if not exists database_showroom.offices" +
                                                                            "(" +
                                                                                "officeCode varchar(10) not null primary key," +
                                                                                "city varchar(50) not null," +
                                                                                "phone varchar(50) not null," +
                                                                                "addressLine1 varchar(50) not null," +
                                                                                "addressLine2 varchar(50) default null," +
                                                                                "state varchar(50) not null," +
                                                                                "country varchar(50) not null," +
                                                                                "postalCode varchar(50) not null" +
                                                                            ");";

    private static final String ADD_FOREIGN_KEY_CUSTOMERS = "alter table database_showroom.customers" +
                                                                                                " add column saleRepEmployeeNumber int(11) not null after creditLimit, " +
                                                                                                          "add foreign key(saleRepEmployeeNumber) references database_showroom.employees(employeeNumber);";

    private static final String ADD_FOREIGN_KEY_ORDERS = "alter table database_showroom.orders" +
                                                                                        " add column customerNumber int(11) not null after priceEach, " +
                                                                                            "add foreign key(customerNumber) references database_showroom.customers(customerNumber);";

    private static final String ADD_FOREIGN_KEY_PAYMENTS = "alter table database_showroom.payments " +
                                                                                            "add foreign key(customerNumber) references database_showroom.customers(customerNumber);";

    private static final String ADD_FOREIGN_KEY_EMPLOYEES = "alter table database_showroom.employees " +
                                                                                         "add column reportTo int(11) not null, " +
                                                                                            "add column officeCode varchar(10) not null, " +
                                                                                                "add foreign key(reportTo) references database_showroom.employees(employeeNumber), " +
                                                                                                    "add foreign key(officeCode) references database_showroom.offices(officeCode);";

    private static final String ADD_FOREIGN_KEY_PRODUCTS = "alter table database_showroom.productions " +
                                                                                      "add column productLine varchar(50) not null, " +
                                                                                        "add foreign key(productLine) references database_showroom.productionlines(productLine);";
    public static void main(String[] args) {
        user = "root";
        pass = "11100001";
        try {
            MySQLConnect mySQL = new MySQLConnect(jdbcURL);
            mySQL.setDBDriver();
            mySQL.setCredentials(user, pass);
            conn = mySQL.openConnection(jdbcURL);

            MySQLExecute executeObj = new MySQLExecute(conn);
            executeObj.execute(CREATE_TABLE_CUSTOMERS);
            executeObj.execute(CREATE_TABLE_EMPLOYEES);
            executeObj.execute(CREATE_TABLE_OFFICES);
            executeObj.execute(CREATE_TABLE_ORDERS);
            executeObj.execute(CREATE_TABLE_PAYMENTS);
            executeObj.execute(CREATE_TABLE_PRODUCTIONS);
            executeObj.execute(CREATE_TABLE_PRODUCTIONLINES);
            executeObj.execute(CREATE_TABLE_ORDERDETAILS);

            executeObj.execute(ADD_FOREIGN_KEY_CUSTOMERS);
            executeObj.execute(ADD_FOREIGN_KEY_ORDERS);
            executeObj.execute(ADD_FOREIGN_KEY_PAYMENTS);
            executeObj.execute(ADD_FOREIGN_KEY_EMPLOYEES);
            executeObj.execute(ADD_FOREIGN_KEY_PRODUCTS);
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
