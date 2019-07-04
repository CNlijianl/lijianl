package com.db;


import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;


public class Dao {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String dirver = "com.mysql.jdbc.Driver";
    private String Url = "jdbc:mysql://localhost:3306/test";
    private String name1 = "root";
    private String password = "949555";

    public Dao() {
        try {
            Class.forName(dirver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createConnection() {
        try {
            connection = DriverManager.getConnection(Url, name1, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean selectUser(int id, String psd) throws SQLException {
        String sql = "select *from tb_user where userid = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (resultSet.getString(5).equals(psd)) {
                return true;

            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public String selectUserName(int id) throws SQLException {


        String sql = "select name from tb_user where userid =" + id;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            String str = resultSet.getString(1);
            return str;
        } else {
            return null;
        }

    }

    public LinkedList selectfriend(int id) {
        createConnection();
        LinkedList list = new LinkedList();
        String sql = "select *from tb_" + id;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int a = resultSet.getInt(2);
                list.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    public boolean updateMessage(int id, String user, String passd, String sex1) {
        int count = 0;
        try {
            statement = connection.createStatement();
            System.out.println("1111");

            statement.addBatch("update tb_user set name ='" + user + "' where userid=" + id);
            statement.addBatch("update tb_user set password ='" + passd + "' where userid=" + id);
            statement.addBatch("update tb_user set sex ='" + sex1 + "' where userid=" + id);
            int result[] = statement.executeBatch();

            for (int i = 0; i < result.length; i++) {
                count++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public void closeConn() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closestatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeresultSet() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closepreparedStatement() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
