package repository;

import domain.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepositoryJDBC implements  CartRepository{

    Connection connection;

    public CartRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addToCart(Cart cart) throws SQLException {
        String add = "INSERT INTO Cart  ( User_id, number,allPrice) VALUES (?, ?,100)";
        PreparedStatement preparedStatement =connection.prepareStatement(add);
        preparedStatement.setInt(1,cart.getUserId());
        preparedStatement.setInt(2,cart.getProducts().get(cart.getProducts().size()-1).getNumber());
      //  preparedStatement.setInt(3,cart.getProducts().get(cart.getAllPrice()));
        preparedStatement.executeUpdate();
        String cartId = "select c.id from Cart as c left join" +
                " Cart_has_Product ChP on c.id = ChP.Cart_id where User_id=? and number=? ";
        preparedStatement = connection.prepareStatement(cartId);
        preparedStatement.setInt(1,cart.getUserId());
        preparedStatement.setInt(2,cart.getProducts().get(cart.getProducts().size()-1).getNumber());
       // preparedStatement.setInt(3,cart.getProducts().get(cart.getAllPrice()));
        ResultSet resultSet = preparedStatement.executeQuery();
       int id= resultSet.getInt(1);
       String sql ="insert  into  Cart_has_Product (Cart_id,Product_id) values (?,?)";
       preparedStatement =connection.prepareStatement(sql);
       preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,cart.getProducts().get(cart.getProducts().size()-1).getId());
        preparedStatement.executeUpdate();

    return id;
    }

    @Override
    public void viewCart(int userId) throws SQLException {
        String viewCart = "select P.name, c.number,P.price, c.AllPrice from Cart as c left join" +
                " Cart_has_Product ChP on c.id = ChP.Cart_id,c.id left join Product P on ChP.Product_id = P.id where User_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(viewCart);
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print("product name" +resultSet.getString(1)+"\t");
                System.out.print("number : " +resultSet.getInt(2)+"\t");
                System.out.print("price : " +resultSet.getInt(3)+"\t");
                System.out.print("allPrice : " +resultSet.getInt(4));
                System.out.println("cart id : "+resultSet.getInt(5));
                System.out.println();

            }
    }

    @Override
    public void deleteFromCart(int cartId) throws SQLException {
        String  delete = "DELETE FROM Cart  WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,cartId);
        preparedStatement.executeUpdate();


    }

    @Override
    public void editItemNUmber() {

    }
}
