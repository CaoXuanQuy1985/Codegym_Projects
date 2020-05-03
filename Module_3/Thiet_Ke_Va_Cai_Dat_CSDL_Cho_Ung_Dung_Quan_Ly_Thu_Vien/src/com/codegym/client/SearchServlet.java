package com.codegym.client;

import com.codegym.library.LibraryDBQuery;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryDBQuery libraryDB = null;
        ResultSet rset = null;
        Connection conn = null;
        try {
            libraryDB = new LibraryDBQuery();
            libraryDB.connect();

            String isbn = request.getParameter("isbn");
            String student_number = request.getParameter("student_number");

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Search A Book</title></head>");
            out.println("<body>");
            String sql_query1 = "select b.isbn, b.title, b.author, count(bc.isbn) from books as b inner join bookcopies as bc using(isbn) where b.isbn = '" + isbn + "' and b.isbn = bc.isbn " +
                                        "group by bc.isbn;";

            conn = libraryDB.getConn();
            MySQLExecute executeObj = new MySQLExecute(conn);
            rset = executeObj.execute(sql_query1);

            try {
                if (!rset.next()) {
                    out.println("Khong co loai sach ma ban can tim !!!");
                } else {
                    out.print(rset.getString("isbn") + " ");
                    out.print(rset.getString("title") + " ");
                    out.print(rset.getString("author") + " ");
                    out.println(rset.getInt("count(bc.isbn)"));

                    String query_2 = "select isbn, copy_id from bookcopies where isbn = '" + isbn + "'";
                    MySQLExecute executeObj2 = new MySQLExecute(conn);
                    ResultSet rset2 = executeObj2.execute(query_2);
                    String isbnVal = null;
                    String copy_idVal = null;

                    while(rset2.next()) {
                        isbnVal = rset2.getString("isbn");
                        copy_idVal = rset2.getString("copy_id");
                    }
                    /*$today = date("Y-m-d");
                    $plus = strtotime("+14 day", time());
                    $estimate = date('Y-m-d', $plus);*/

                    // create a java calendar instance
                    Calendar calendar = Calendar.getInstance();

// get a java date (java.util.Date) from the Calendar instance.
// this java date will represent the current date, or "now".
                    java.util.Date currentDate = calendar.getTime();

// now, create a java.sql.Date from the java.util.Date
                    java.sql.Date date = new java.sql.Date(currentDate.getTime());
                    java.sql.Date afterDate = new java.sql.Date(currentDate.getTime() + 28l * 24l * 60l * 60l * 1000l);

                    String lastCrawlDate = "2014-01-28";
                    java.util.Date utilDate = null;
                    try {
                        utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    String query_insert = "INSERT INTO issues (isbn, copy_id, student_number, extend_date, issue_date, " +
                            "return_date) VALUES ('" + isbnVal + "', '" + copy_idVal + "', '" + student_number + "', '" + afterDate + "', '" + date + "', '" + afterDate + "');";
                    rset = executeObj.execute(query_insert);
                    System.out.println(query_insert);

                    while (rset.next()) {
                        out.print(rset.getString("isbn") + " ");
                        out.print(rset.getString("title") + " ");
                        out.print(rset.getString("author") + " ");
                        out.println(rset.getInt("count(bc.isbn)"));
                    }
                }

                out.println("</body></html>");
                out.close();

            } catch (SQLException ex) {
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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
