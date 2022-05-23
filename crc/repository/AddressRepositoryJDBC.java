package repository;

import domain.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AddressRepositoryJDBC implements AddressRepository {

    Connection connection;


    public AddressRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addAddress(Address address) throws SQLException {

        String add = "INSERT INTO Address(state,city,streetName,pistolCode,User_id) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, address.getState());
        preparedStatement.setString(2, address.getCity());
        preparedStatement.setString(3, address.getStreetName());
        preparedStatement.setString(4, address.getPistolCode());
        preparedStatement.setInt(5, address.getUserId());
        preparedStatement.executeUpdate();
        String getId = "select id from  Address where state=? and  city=? and  " +
                "streetName = ? and  pistolCode =? and  User_id=?";
        preparedStatement = connection.prepareStatement(getId);
        preparedStatement.setString(1, address.getState());
        preparedStatement.setString(2, address.getCity());
        preparedStatement.setString(3, address.getStreetName());
        preparedStatement.setString(4, address.getPistolCode());
        preparedStatement.setInt(5, address.getUserId());
        ResultSet resultSet = preparedStatement.executeQuery();
        int id =0;
        if (resultSet.next()){
            id = resultSet.getInt(1);

        }


        return id;
    }

    @Override
    public void readAddress(int userId) throws SQLException {
        String selectAddress = "select   *from  Address where User_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectAddress);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("address id: " + resultSet.getInt(1) + "\t");
            System.out.print("state  : " + resultSet.getString(2) + "\t");
            System.out.print("city  : " + resultSet.getString(3) + "\t");
            System.out.print("street name  : " + resultSet.getString(4) + "\t");
            System.out.print("pistol code  : " + resultSet.getString(5) + "\t");
            System.out.println();
        }


    }

    @Override
    public void editAddress(Address address) {

    }

    @Override
    public void deleteAddress(Address address) {

    }

    public ArrayList<Address> selectAddress(int userId) throws SQLException {
        String selectAddress = "select   *from  Address where User_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectAddress);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Address address;
        ArrayList<Address> addresses = new ArrayList<>();
        while (resultSet.next()) {
            int addressId = resultSet.getInt(1);
            String state = resultSet.getString(2);
            String city = resultSet.getString(3);
            String streetName = resultSet.getString(4);
            String pistolCode = resultSet.getString(5);
            address = new Address(state, city, streetName, pistolCode);
            address.setId(addressId);
            addresses.add(address);

        }
        return addresses;

    }
}
