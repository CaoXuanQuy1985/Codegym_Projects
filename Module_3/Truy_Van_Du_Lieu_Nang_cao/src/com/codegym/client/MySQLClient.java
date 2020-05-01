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

            //Query statement lấy ra các sản phẩm có giá lớn hơn 56.75 và số lượng trong kho lớn hơn 10 ...
            String queryStr_1 = "select productCode, productName, quantityInStock, buyPrice " +
                                        "from classicmodels.products " +
                                        "where buyPrice > 56.76 and quantityInStock > 10;";
            rset = executeObj.execute(queryStr_1);
            System.out.println("ProductCode      productName     QuantityInStock    buyPrice");
            while (rset.next()) {
                System.out.print(rset.getString("productCode") + "          ");
                System.out.print(rset.getString("productCode") + "          ");
                System.out.print(rset.getInt("quantityInStock") + "               ");
                System.out.println(rset.getFloat("buyPrice"));
            }
            System.out.println();

            //lấy productcode, productname và buyprice từ bảng products, textdescription từ bảng productlines
            // với điều kiện giá mua nằm trong khoảng từ 56.76 đến 95.59.
            String queryStr_2 = "select p.productCode productCode, " +
                                                "p.productName productName, " +
                                                "p.buyPrice buyPrice, " +
                                                "p.productLine, " +
                                                "l.textDescription description " +
                                                "from products p inner join productlines l on p.productLine = l.productLine " +
                                                "where p.buyPrice >= 56.76 and p.buyPrice <= 95.59;";
            rset = executeObj.execute(queryStr_2);
            System.out.println("ProductCode      productName                 buyPrice                        textDescription");
            while (rset.next()) {
                System.out.print(rset.getString("productCode") + "          ");
                System.out.print(rset.getString("productName") + "          ");
                System.out.print(rset.getFloat("buyPrice") + "               ");
                System.out.println(rset.getString("description"));
            }

            // hiển thị ra các sản phẩm có loại sản phẩm là Classic Cars hoặc nhà cung cấp là 'Min Lin Diecast' sử dụng truy vấn như sau:
            String queryStr_3 = "select productCode, productName, buyprice, quantityInStock, productVendor, productLine  from products " +
                    "where productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast';";
            rset = executeObj.execute(queryStr_3);
            System.out.println("ProductCode      productName                 buyPrice");
            while (rset.next()) {
                System.out.print(rset.getString("productCode") + "          ");
                System.out.print(rset.getString("productName") + "          ");
                System.out.println(rset.getFloat("buyPrice") + "               ");
            }
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
