package repository;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryJDBC implements UserRepository {
        User user;
    Connection connection ;

    public  UserRepositoryJDBC (Connection connection,User user){

        this.connection = connection;
        this.user = user;
    }

    @Override
    public int addUser(User user) throws SQLException {
        String addUser= "INSERT INTO homeWork5.User (userName, password, fristName, lastName, phoneNumber, email)" +
                " VALUES (?, ?, ?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(4,user.getFirstName());
        preparedStatement.setString(4,user.getLastName());
        preparedStatement.setString(5,user.getPhoneNumber());
        preparedStatement.setString(6,user.getEmail());
       preparedStatement.executeUpdate();
       String getUserId = "select u.id from User as u where userName=?";
      PreparedStatement preparedStatementGetId = connection.prepareStatement(getUserId);
      preparedStatement.setString(1,user.getUserName());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
          user.setId(resultSet.getInt("id"));
      }

            return user.getId();
    }

    @Override
    public User readUser(int id) throws SQLException {
        String selectUser = "SELECT userName,id,firstName,lastName,phoneNumber,email,password FROM " +
                "homeWork5.User where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user.setUserName(resultSet.getString(1));
            System.out.println("username : " +user.getUserName());
            user.setId(resultSet.getInt(2));
            System.out.println("user id : " +user.getId());
            user.setFirstName(resultSet.getString(3));
            System.out.println("first name : " +user.getFirstName());
            user.setLastName(resultSet.getString(4));
            System.out.println("last name : " +user.getLastName());
            user.setPhoneNumber(resultSet.getString(5));
            System.out.println("phone number : " +user.getPhoneNumber());
            user.setEmail(resultSet.getString(6));
            System.out.println("email  : " +user.getEmail());
            user.setPassword(resultSet.getString(7));
            System.out.println();

        }
            return user;

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }



    @Override
    public int cheekLogin(String username, String password) throws SQLException {
        String cheek = "select id from User where userName=? and password =? ";
        PreparedStatement preparedStatement = connection.prepareStatement(cheek);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = -1;
        if (resultSet.next()) id=resultSet.getInt(1);
        return id;

    }

    @Override
    public boolean validUser(String userName) throws SQLException {
        String userCheek="select *from User where userName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(userCheek);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public boolean validPhoneNumber(String phoneNumber) throws SQLException {
        String phoneNumberCheek= "select *from User where PhoneNumber=?";
        PreparedStatement preparedStatement = connection.prepareStatement(phoneNumberCheek);
            preparedStatement.setString(1,phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
    }

    @Override
    public boolean validEmail(String email) throws SQLException {
        String emailcheek= "select *from User where email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(emailcheek);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }
}
