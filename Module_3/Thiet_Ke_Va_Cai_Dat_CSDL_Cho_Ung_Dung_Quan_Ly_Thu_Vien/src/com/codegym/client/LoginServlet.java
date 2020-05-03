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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
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
            out.println("<head><title>Query Response</title></head>");
            out.println("<body>");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String queryAccount = "select * from borroworders where borroworders.username = '" + username + "' and borroworders.password = '" + password + "';";

            conn = libraryDB.getConn();
            MySQLExecute executeObj = new MySQLExecute(conn);
            rset = executeObj.execute(queryAccount);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            try {
                if (!rset.next()) {
                    out.print("<h1>Incorrect username or password !!!</h1>");
                    out.println("</body></html>");
                    out.close();
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
