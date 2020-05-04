package com.codegym.library;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDBQuery {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASS = "11100001";
    private static MySQLConnect mySQLConnect = null;
    private static Connection conn = null;
    private static MySQLExecute executeObj = null;
    private static ResultSet rset = null;
    private static Statement stmt = null;

    private static final String CREATE_TABLE_STUDENTS = "create table if not exists student.students" +
                                                                                "(" +
                                                                                    "id int(11) not null auto_increment, " +
                                                                                    "primary key(id), " +
                                                                                    "name varchar(40) not null, " +
                                                                                    "age int(11) not null, " +
                                                                                    "course varchar(20) not null, " +
                                                                                    "money float(10, 2) not null " +
                                                                                ");";
    private static final String sql_insert1 = "insert into student.students(name, age, course, money) values ('Hoang', 21, 'CNTT', 400000), " +
            "('Viet', 19, 'DTVT', 320000), " +
            "('Thanh', 18, 'KTDN', 400000)," +
            "('Nhan', 19, 'CK', 450000), " +
            "('Huong', 20, 'TCNH', 500000), " +
            "('Huong', 20, 'TCNH', 200000) "
            ;

    public ResultSet getRset() {
        return rset;
    }

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConnection() {
        return conn;
    }

    public void connect() {
        mySQLConnect = new MySQLConnect(JDBC_URL);
        mySQLConnect.setDBDriver();
        mySQLConnect.setCredentials(USER, PASS);
        conn = mySQLConnect.openConnection();
        executeObj = new MySQLExecute(conn);

        executeObj.execute(CREATE_TABLE_STUDENTS);
        //executeObj.execute(sql_insert1);
    }

    public Connection getConn() {
        return conn;
    }
}
