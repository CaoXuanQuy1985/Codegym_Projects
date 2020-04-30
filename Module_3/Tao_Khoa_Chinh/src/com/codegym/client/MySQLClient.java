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
        user = "root";
        pass = "11100001";
        try {
            MySQLConnect mySQL = new MySQLConnect(jdbcURL);
            mySQL.setDBDriver();
            mySQL.setCredentials(user, pass);
            conn = mySQL.openConnection(jdbcURL);

            MySQLExecute executeObj = new MySQLExecute(conn);

            String createTable = "create table if not exists classicmodels.users" +
                                         "(" +
                                            "user_id int not null auto_increment primary key," +
                                            "username varchar(40)," +
                                            "password varchar(255), " +
                                            "email varchar(255)" +
                                         ");";
            executeObj.execute(createTable);

            createTable = "create table if not exists classicmodels.roles" +
                                "(" +
                                    "role_id int(11) not null auto_increment," +
                                    "role_name varchar(40) not null," +
                                    "primary key (role_id)" +
                                ");";
            executeObj.execute(createTable);

            String createPivotTable = "create table if not exists classicmodels.user_role" +
                                                "(" +
                                                    "user_id int not null," +
                                                    "role_id int not null, " +
                                                    "primary key(user_id, role_id)," +
                                                    "foreign key(user_id) references classicmodels.users(user_id), " +
                                                    "foreign key(role_id) references classicmodels.roles(role_id)" +
                                                ");";
            executeObj.execute(createPivotTable);

            String creatNewTable = "create table if not exists classicmodels.new_table" +
                                             "(" +
                                                "table_id int not null," +
                                                "table_name varchar(25)" +
                                             ");";
            executeObj.execute(creatNewTable);

            String addPrimaryKey = "alter table classicmodels.new_table add primary key (table_id);";
            executeObj.execute(addPrimaryKey);
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
