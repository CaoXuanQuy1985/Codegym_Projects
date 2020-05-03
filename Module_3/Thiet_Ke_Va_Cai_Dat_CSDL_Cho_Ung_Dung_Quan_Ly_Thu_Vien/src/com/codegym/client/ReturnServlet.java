package com.codegym.client;

import com.codegym.library.LibraryDBQuery;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

@WebServlet("/returnServlet")
public class ReturnServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryDBQuery libraryDB = null;
        ResultSet rset = null;
        Connection conn = null;
        try {
            libraryDB = new LibraryDBQuery();
            libraryDB.connect();

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Return Books</title></head>");
            out.println("<body>");
            String isbn = request.getParameter("isbn");
            String student_number = request.getParameter("student_number");
            String query_1 = "select return_date from issues where isbn = '" + isbn + "' and student_number = '" + student_number + "';";

            conn = libraryDB.getConn();
            MySQLExecute executeObj = new MySQLExecute(conn);
            rset = executeObj.execute(query_1);

            try {
                if (!rset.next()) {
                    out.println("</body></html>");
                    out.close();
                }
                   java.sql.Date return_date =  rset.getDate("return_date");
                    Calendar calendar = Calendar.getInstance();
                    java.util.Date currentTime = calendar.getTime();
                   java.sql.Date currentDate =  new java.sql.Date(currentTime.getTime());
                    //java.sql.Date currentDate = new java.sql.Date(2014, 1, 29);
                   if (currentDate.compareTo(return_date) <= 0) {
                       out.println("Ban da gia sach dung thoi han");
                       String query_2 = "select penalty from students where student_number = '" + student_number + "'";
                       rset = executeObj.execute(query_2);
                       while (rset.next()) {
                           out.println(rset.getFloat("penalty"));
                       }
                       String query_delete = "delete from issues where student_number = '" + student_number + "' and isbn = '" + isbn + "';";
                       MySQLExecute executeObj2 = new MySQLExecute(conn);
                       executeObj2.execute(query_delete);
                   } else {
                       out.println("Ban da gia sach qua thoi han, tong tien phat cua ban la: ");
                       long delayTime = (currentDate.getTime() - return_date.getTime()) ;
                       long delayDate = delayTime / (60*60*24*1000);
                       float penalty = (float)(delayDate * 0.7);
                       out.println(penalty + " VND");

                       String update_sql = "update students set penalty = '" + penalty + "'where student_number = '" + student_number + "';";
                       rset = executeObj.execute(update_sql);

                       String query_delete = "delete from issues where student_number = '" + student_number + "' and isbn = '" + isbn + "';";
                       MySQLExecute executeObj2 = new MySQLExecute(conn);
                       executeObj2.execute(query_delete);
                   }
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (rset != null)
                    rset.close();
                if (libraryDB.getStmt() != null)
                    libraryDB.getStmt().close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
