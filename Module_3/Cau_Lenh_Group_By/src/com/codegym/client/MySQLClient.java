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
        MySQLExecute executeObj = null;
        ResultSet rset = null;
        Statement stmt = null;
        user = "root";
        pass = "11100001";
        try {
            MySQLConnect mySQL = new MySQLConnect(jdbcURL);
            mySQL.setDBDriver();
            mySQL.setCredentials(user, pass);
            conn = mySQL.openConnection(jdbcURL);

            executeObj = new MySQLExecute(conn);
            stmt = MySQLExecute.getStmt();

            //Để biết được có bao nhiêu trạng thái của đơn hàng. Thực hiện ...
            String queryStr_1 = "select status from classicmodels.orders group by status;";
            rset = executeObj.execute(queryStr_1);
            System.out.println("status");

            // muốn biết có bao nhiêu đơn đặt hàng trong mỗi trạng thái ....
            String queryStr_2 = "select status, count(*) as totalOrder from classicmodels.orders group by status";
            rset = executeObj.execute(queryStr_2);
            while (rset.next()) {
                System.out.print(rset.getString("status") + "       ");
                System.out.println(rset.getInt("totalOrder"));
            }
            System.out.println();

            // tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng ....
            String queryStr_3 = "select status, sum(quantityOrdered * priceEach) as totalMoney " +
                                        "from classicmodels.orders inner join classicmodels.orderdetails using(orderNumber) " +
                                        "group by status;";
            rset = executeObj.execute(queryStr_3);
            while (rset.next()) {
                System.out.print(rset.getString("status") + "       ");
                System.out.println(rset.getFloat("totalMoney"));
            }
            System.out.println();

            // tính tổng tiền của từng đơn hàng ...
            String queryStr_4 = "select orderNumber, sum(quantityOrdered * priceEach) from classicmodels.orderdetails group by orderNumber";
            rset = executeObj.execute(queryStr_4);
            while (rset.next()) {
                System.out.print(rset.getString("orderNumber") + "       ");
                System.out.println(rset.getFloat("sum(quantityOrdered * priceEach)"));
            }
            System.out.println();

        } catch (SQLException ex) {
            ex.printStackTrace();
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
