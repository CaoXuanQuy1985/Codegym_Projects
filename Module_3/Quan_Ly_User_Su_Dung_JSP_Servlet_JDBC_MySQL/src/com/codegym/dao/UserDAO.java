package com.codegym.dao;

import com.codegym.model.User;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserDAO implements IUserDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUser = "root";
    private static String jdbcPassword = "11100001";

    private static final String INSERT_USER_SQL = "insert into demo.users(name, email, country) values (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from demo.users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from demo.users;";
    private static final String DELETE_USERS_BY_ID = "delete from demo.users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update demo.users set name = ?, email = ?, country = ? where id = ?;";

    public UserDAO(){}

    protected Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        String name = user.getName();
        String email = user.getEmail();
        String country = user.getCountry();

        PreparedStatement ps = getConnection().prepareStatement(INSERT_USER_SQL);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, country);
        System.out.println(ps);

        try {
            ps.executeUpdate();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }

    public User selectUser(int id) {
        System.out.println(SELECT_USER_BY_ID);
        Connection conn = getConnection();
        User user = null;
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_return = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id_return, name, email, country);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        User user = null;
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        Connection conn = getConnection();
        boolean rowDeleted = false;
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_USERS_BY_ID);
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_USERS_SQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());

            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                System.out.println("SQLErrorCode: " + ((SQLException)e).getErrorCode());
                System.err.println("Message: " + ((SQLException)e).getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
