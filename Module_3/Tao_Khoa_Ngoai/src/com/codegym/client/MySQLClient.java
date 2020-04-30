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

            String createTableStr = "create table if not exists classicmodels.my_customer" +
                                             "(" +
                                                 "customer_id int not null auto_increment primary key," +
                                                 "name varchar(25)," +
                                                 "address varchar(40), " +
                                                 "email varchar(30)" +
                                             ");";
            executeObj.execute(createTableStr);
            createTableStr = "create table if not exists classicmodels.my_order" +
                                    "(" +
                                        "order_id int not null auto_increment," +
                                        "staff varchar(40) not null," +
                                        "primary key(order_id)," +
                                        "customer_id int not null," +
                                        " foreign key(customer_id) references classicmodels.my_customer(customer_id)" +
                                    ");";
            System.out.println(createTableStr);
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
