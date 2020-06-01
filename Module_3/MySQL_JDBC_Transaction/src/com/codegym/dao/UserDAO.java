package com.codegym.dao;

import com.codegym.model.User;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUser = "root";
    private static String jdbcPassword = "11100001";

    private static final String INSERT_USER_SQL = "insert into demo.users(name, email, country) values (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from demo.users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from demo.users;";
    private static final String DELETE_USERS_BY_ID = "delete from demo.users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update demo.users set name = ?, email = ?, country = ? where id = ?;";
    private static final String SEARCH_BY_COUNTRY = "select * from demo.users where country = ? order by name desc;";

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

    public List<User> searchByCountry(String country) throws SQLException{
        List<User> users = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(SEARCH_BY_COUNTRY);
        ps.setString(1, country);

        System.out.println(ps);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String countryRS = rs.getString("country");

            User user = new User(name, email, countryRS);
            users.add(user);
        }

        return users;
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

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "call get_user_by_id(?);";

        try {
            Connection conn = getConnection();
            CallableStatement callableStatement = conn.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }

        return user;
    }

    @Override

    public void insertUserStore(User user) throws SQLException {

        String query = "{CALL insert_user(?,?,?)}";

        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);

        }
    }

    public void addUserTransaction(User user, int[] permisions) {
        Connection conn = null;
        PreparedStatement pstmt =  null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());

            int rowsEffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }

            if (rowsEffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(user_id, permision_id) VALUES(?,?)";
                ;
                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch  (SQLException ex2) {
                System.out.println(ex2.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (pstmtAssignment != null)
                    pstmtAssignment.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}