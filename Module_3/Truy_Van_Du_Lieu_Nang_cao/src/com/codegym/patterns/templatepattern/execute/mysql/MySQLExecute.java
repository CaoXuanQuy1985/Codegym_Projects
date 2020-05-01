package com.codegym.patterns.templatepattern.execute.mysql;

import com.codegym.patterns.templatepattern.execute.ExecutionTemplate;
import java.sql.*;

public class MySQLExecute extends ExecutionTemplate {
    private static Statement stmt;
    private static Connection conn;
    private static ResultSet resultSet;

    public MySQLExecute(Connection conn) {
        MySQLExecute.conn = conn;
        try {
            stmt = conn.createStatement();
            System.out.println("Creating Statement successful !");
        } catch (SQLException ex) {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            System.err.println("Creating Statement failed, try again !!!");
        }
    }

    public static Statement getStmt() {
        return stmt;
    }

    public ResultSet execute(String queryStr) {
        try {
            if (queryStr.contains("CREATE") | queryStr.contains("create") | queryStr.contains("DROP") | queryStr.contains("drop")) {
                stmt.executeUpdate(queryStr);
            } else {
                if (stmt.execute(queryStr)) {
                    resultSet = stmt.getResultSet();
                } else {
                    resultSet = null;
                }
            }
            System.out.println("Executing query successful !");
        } catch (SQLException ex) {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            System.err.println("Executing query failed, try another query !!!");
            ex.printStackTrace();
        }

        return resultSet;
    }
}
