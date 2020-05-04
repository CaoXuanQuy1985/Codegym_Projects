package com.codegym.client;

import com.codegym.library.LibraryDBQuery;
import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;
import java.sql.*;

public class MySQLClient {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
    private static String user;
    private static String pass;
    private static Connection conn;

    public static void main(String[] args) {
        MySQLExecute executeObj = null;
        ResultSet rset = null;
        Statement stmt = null;
        user = "root";
        pass = "11100001";
        try {
            LibraryDBQuery dbQuery = new LibraryDBQuery();
            dbQuery.connect();
            executeObj = new MySQLExecute(new LibraryDBQuery().getConn());

            // Hien Thi Tat ca cac dong co ten la Huong
            String query_1 = "select id, name, age, course, money from student.students where name = 'Huong';";
            rset = executeObj.execute(query_1);

            //Lay ra tong so tien cua Huong
            String query_2 = "select name, sum(money) as totalMoney from student.students where name = 'Huong' group by name";

            try {
                while (rset.next()) {
                    System.out.print(rset.getInt("id") + "       ");
                    System.out.print(rset.getString("name") + "      ");
                    System.out.print(rset.getInt("age") + "       ");
                    System.out.print(rset.getString("course") + "     ");
                    System.out.println(rset.getFloat("money"));
                }

                rset = executeObj.execute(query_2);
                while (rset.next()) {
                    System.out.print(rset.getString("name") + "      ");
                    System.out.print(rset.getFloat("totalMoney"));
                }

                //Lay ra ten danh sach tat ca hoc vien khong trungf lap
                String query_3 = "select distinct name from student.students;";
                rset = executeObj.execute(query_3);
                while (rset.next()) {
                    System.out.println(rset.getString("name") + "      ");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
    }
}
