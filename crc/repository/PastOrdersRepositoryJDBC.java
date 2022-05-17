package repository;

import domain.PastOrders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PastOrdersRepositoryJDBC implements  PastOrdersRepository {
    Connection connection;

    public PastOrdersRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    public void AddToPastOrders(PastOrders pastOrders) throws SQLException {
        String add = "INSERT INTO PastOrders (Product, price, Adress, User_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1,pastOrders.getProduct().getName());
        preparedStatement.setInt(2,pastOrders.getPrice());
        preparedStatement.setString(3,pastOrders.getAddress().toString());
        preparedStatement.setInt(4,pastOrders.getUserID());
        preparedStatement.executeUpdate();
      /*  String getId = "select id from PastOrders where User_id=?";
        preparedStatement = connection.prepareStatement(getId);
        preparedStatement.setInt(1,pastOrders.getUserID());
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = resultSet.getInt(1)

       */



    }
}
