package com.codegym.client;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;
import java.sql.*;

public class MySQLClient {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root",
                 password = "11100001";
        Connection conn = null;
        MySQLConnect connectObj = new MySQLConnect(jdbcURL);
        MySQLExecute execute = new MySQLExecute()

        try {

        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
        }
    }
}
