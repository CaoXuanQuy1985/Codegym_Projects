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

            //lấy customerNumber, customerName, phone, paymentDate, amount từ hai bảng customers và payments
            // với điều kiện là các khách hàng sống ở thành phố Las Vegas
            String queryStr_1 = "select c.customerNumber, c.customerName, c.phone, p.paymentDate, p.amount " +
                                        "from classicmodels.customers c inner join classicmodels.payments p " +
                                        "on p.customerNumber = c.customerNumber " +
                                        "where c.city = 'Las Vegas';";
            rset = executeObj.execute(queryStr_1);
            System.out.println("customerNumber      customerName     paymentDate    amount");
            while (rset.next()) {
                System.out.print(rset.getString("customerNumber") + "          ");
                System.out.print(rset.getString("customerName") + "          ");
                System.out.print(rset.getDate("paymentDate") + "               ");
                System.out.println(rset.getFloat("amount"));
            }
            System.out.println();

            // tìm tất cả các đơn hàng thuộc từng khách hàng
            String queryStr_2 = "select c.customerNumber, c.customerName, p.orderNumber " +
                    "from classicmodels.customers c left join classicmodels.orders p " +
                    "on p.customerNumber = c.customerNumber ";
            rset = executeObj.execute(queryStr_2);
            System.out.println("customerNumber      customerName     orderNumber");
            while (rset.next()) {
                System.out.print(rset.getString("customerNumber") + "          ");
                System.out.print(rset.getString("customerName") + "          ");
                System.out.println(rset.getString("orderNumber") + "               ");
            }
            System.out.println();

            // tìm tất cả khách hàng chưa đặt hàng bất kỳ sản phẩm nào
            String queryStr_3 = "select c.customerNumber, c.customerName, p.orderNumber " +
                    "from classicmodels.customers c left join classicmodels.orders p " +
                    "on p.customerNumber = c.customerNumber where p.orderNumber is null;";
            rset = executeObj.execute(queryStr_3);
            System.out.println("customerNumber      customerName     orderNumber");
            while (rset.next()) {
                System.out.print(rset.getString("customerNumber") + "          ");
                System.out.print(rset.getString("customerName") + "          ");
                System.out.println(rset.getString("orderNumber") + "               ");
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
