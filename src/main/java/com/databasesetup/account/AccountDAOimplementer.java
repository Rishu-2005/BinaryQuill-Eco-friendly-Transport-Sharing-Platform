package com.databasesetup.account;

import java.sql.*;

public class AccountDAOimplementer implements AccountDAO {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/EarthyWay";
    private static final String USER = "root";
    private static final String PASSWORD = "rishu005";


    @Override
    public void addUser(AccountData user) {

        String query = "INSERT INTO User(firstname,midname,lastname,email,phone,dob,passwd) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getMidName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cant add " + e.getMessage());
        }

    }

    @Override
    public AccountData getUserbyid(int id) {
        String query = "SELECT * FROM User WHERE accountid=?";
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("accountid");
                resultSet.getString("firstname");
                resultSet.getString("midname");
                resultSet.getString("lastname");
                resultSet.getString("email");
                resultSet.getString("phone");
                resultSet.getString("dob");
            }
        } catch (SQLException e) {
            System.out.println("Cant get " + e.getMessage());
        }
        return null;
    }


    @Override
    public void deleteUser(AccountData user) {

        String query = "DELETE FROM User WHERE accountid=?";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cant Delete" + e.getMessage());
        }
    }
}
