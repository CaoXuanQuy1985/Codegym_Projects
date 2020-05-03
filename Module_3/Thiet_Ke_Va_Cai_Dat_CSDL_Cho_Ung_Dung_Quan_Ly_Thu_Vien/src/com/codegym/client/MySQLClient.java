package com.codegym.client;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;
import java.sql.*;

public class MySQLClient {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
    private static String user;
    private static String pass;
    private static Connection conn;

   /* public static void main(String[] args) {
        MySQLExecute executeObj = null;
        ResultSet rset = null;
        Statement stmt = null;
        user = "root";
        pass = "11100001";
        try {
           *//* MySQLConnect mySQL = new MySQLConnect(jdbcURL);
            mySQL.setDBDriver();
            mySQL.setCredentials(user, pass);
            conn = mySQL.openConnection(jdbcURL);

            executeObj = new MySQLExecute(conn);
            stmt = MySQLExecute.getStmt();*//*

        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rset != null)
                    rset.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }*/
}
