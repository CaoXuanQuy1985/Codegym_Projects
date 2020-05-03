package com.codegym.library;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDBQuery {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library_database";
    private static final String USER = "root";
    private static final String PASS = "11100001";
    private static MySQLConnect mySQLConnect = null;
    private static Connection conn = null;
    private static MySQLExecute executeObj = null;
    private static ResultSet rset = null;
    private static Statement stmt = null;

    private static final String CREATE_TABLE_STUDENTS = "create table if not exists students" +
                                                                             "(" +
                                                                                "student_number int(11) not null primary key, " +
                                                                                "student_name varchar(30) not null, " +
                                                                                "gender char not null, " +
                                                                                "age int(11) not null, " +
                                                                                "address varchar(40) not null, " +
                                                                                "email varchar(40) default null, " +
                                                                                "isDebarred boolean not null, " +
                                                                                "penalty decimal(5,2) not null, " +
                                                                                "dept varchar(30)" +
                                                                             ");";
    private static final String CREATE_TABLE_BORROWORDERS = "create table if not exists borroworders" +
                                                                                        "(" +
                                                                                            "username varchar(15) not null, " +
                                                                                            "password varchar(20) not null" +
                                                                                        ");";
    private static final String CREATE_TABLE_BOOKS = "create table if not exists books" +
                                                                            "(" +
                                                                                "isbn char(9) not null primary key, " +
                                                                                "title varchar(30) not null, " +
                                                                                "isReserved boolean not null, " +
                                                                                "edition int not null, " +
                                                                                "author varchar(30) not null, " +
                                                                                "publisher varchar(30) not null" +
                                                                            ");";
    private static final String CREATE_TABLE_BOOKCOPIES = "create table if not exists bookcopies" +
                                                                            "(" +
                                                                                "isbn char(9) not null, " +
                                                                                "copy_id int not null, " +
                                                                                "isHold boolean not null, " +
                                                                                "primary key(isbn, copy_id), " +
                                                                                "foreign key(isbn) references books(isbn)" +
                                                                            ");";
    private static final String CREATE_TABLE_ISSUES = "create table if not exists issues" +
            "(" +
            "issue_id char(9) unique, " +
            "isbn char(9) not null, " +
            "copy_id int not null, " +
            "student_number int(11) not null, " +
            "extend_date date not null, " +
            "issue_date date not null, " +
            "return_date date not null check(return_date >= extend_date), " +
            "primary key(issue_id), " +
            "foreign key(student_number) references students(student_number), " +
            "foreign key(isbn) references bookcopies(isbn)" +
            ");";

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
        executeObj.execute(CREATE_TABLE_BORROWORDERS);
        executeObj.execute(CREATE_TABLE_BOOKS);
        executeObj.execute(CREATE_TABLE_BOOKCOPIES);
        executeObj.execute(CREATE_TABLE_ISSUES);
    }

    public Connection getConn() {
        return conn;
    }
}
