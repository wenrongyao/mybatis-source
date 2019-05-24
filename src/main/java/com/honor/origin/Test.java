package com.honor.origin;

import java.sql.*;

/**
 * Created by rongyaowen
 * on 2019/5/22.
 */
public class Test {
    public static void main(String[] args) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "select * from sys_role";
            statement.execute(sql);
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer sysRoleId = resultSet.getInt("sys_role_id");
                String sysRoleName = resultSet.getString("role_name");
                System.out.println("sysRoleId:" + sysRoleId + "," + "sysRoleName:" + sysRoleName + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        close(connection);
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
