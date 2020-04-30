package com.codegym.client;

import com.codegym.patterns.templatepattern.connect.mysql.MySQLConnect;
import com.codegym.patterns.templatepattern.execute.mysql.MySQLExecute;
import java.sql.*;

public class MySQLClient {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root",
                 password = "11100001";
        Connection conn = null;

        try {
            MySQLConnect mysql = new MySQLConnect(jdbcURL);
            conn = mysql.connectDB(jdbcURL, user, password);

            MySQLExecute executeObj = new MySQLExecute(conn);
            //Query: create new table which has name contacts
            String createTable = "create table if not exists classicmodels.contacts" +
                    "(" +
                    "contact_id int(11) not null auto_increment," +
                    "last_name varchar(30) not null," +
                    "first_name varchar(25)," +
                    "birthDay date," +
                    "constraint contacts_pk primary key (contact_id)" +
                    ")";
            System.out.println(createTable);
            executeObj.execute(createTable);

            createTable = "create table if not exists classicmodels.suppliers" +
                    "(" +
                    "supplier_id int(11) not null auto_increment," +
                    "supplier_name varchar(50) not null," +
                    "account_rep varchar(30) default 'TBD'," +
                    "constraint suppliers_pk primary key (supplier_id)" +
                    ")";
            executeObj.execute(createTable);

            //Drop table
            String dropTable = "drop table classicmodels.suppliers";
            executeObj.execute(dropTable);

            //Adding new column (field)
            String addCol = "alter table classicmodels.contacts add numberPhone int(11) after birthDay;";
            executeObj.execute(addCol);

            //Adding new multi column
            addCol = "alter table classicmodels.contacts add bankAccount int(11), add old boolean default false after numberPhone";
            executeObj.execute(addCol);

            //Modifying column
            String modifyStr = "alter table classicmodels.contacts modify last_name int(20) not null";
            executeObj.execute(modifyStr);

            //Drop Column
            String dropCol = "alter table classicmodels.contacts drop column old";
            executeObj.execute(dropCol);

            //Changing column
            String changeCol = "alter table classicmodels.contacts change column numberPhone newNumberPhone varchar(25);";
            executeObj.execute(changeCol);

            //Rename table
            String renameTable = "alter table classicmodels.contacts rename to newContacts;";
            executeObj.execute(renameTable);
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
        }
    }
}
