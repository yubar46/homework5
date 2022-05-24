package repository;

import domain.PastOrders;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PastOrdersRepositoryJDBC implements  PastOrdersRepository {
    Connection connection;

    public PastOrdersRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    public void AddToPastOrders(PastOrders pastOrders, User user) throws SQLException {
        String add = "INSERT INTO PastOrders (Product, price, Adress, User_id,number,totalPrice,ordersPrice) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);

        preparedStatement.setString(1,pastOrders.getProduct().getName());
        preparedStatement.setInt(2,pastOrders.getPrice());
        preparedStatement.setString(3,pastOrders.getAddress().toString());
        preparedStatement.setInt(4,pastOrders.getUserID());
        preparedStatement.setInt(5,pastOrders.getProduct().getNumber());
        preparedStatement.setInt(6,pastOrders.getAllPrice());
        preparedStatement.setInt(7,pastOrders.getTotalPrice());
        preparedStatement.executeUpdate();
      /*  String getId = "select id from PastOrders where User_id=?";
        preparedStatement = connection.prepareStatement(getId);
        preparedStatement.setInt(1,pastOrders.getUserID());
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = resultSet.getInt(1)

       */



    }

    public void selectPastOrders(int userId) throws SQLException {
        String selectPastOrders ="select *from PastOrders where User_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectPastOrders);
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
            boolean empty=true;
        while (resultSet.next()){
            System.out.print("product name : "+ resultSet.getString(2)+"\t");
            System.out.print("price: "+ resultSet.getInt(3)+"\t");
            System.out.print(resultSet.getString(4));
            System.out.println("user id ; "+resultSet.getInt(5));
            System.out.println("number ; "+resultSet.getInt(6));
            System.out.println(" sum of product price; "+resultSet.getInt(8));
            if (resultSet.isLast())
            System.out.println(" all order price  ; "+resultSet.getInt(7));
            empty=false;
        }
        if (empty) System.out.println("you have any order in past");
    }
}
