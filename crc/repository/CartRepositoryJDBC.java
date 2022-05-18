package repository;

import domain.Cart;
import domain.CartItem;
import domain.Product;

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

        String add = "INSERT INTO Cart  ( User_id, number,allPrice, productId) VALUES (?, ?,?,?)";
        PreparedStatement preparedStatement =connection.prepareStatement(add);
        for (int i = 0 ;i<cart.getProducts().size();i++){
            preparedStatement.setInt(1,cart.getUserId());
            preparedStatement.setInt(2,cart.getProducts().get(i).getNumber());
            preparedStatement.setInt(3,cart.getProducts().get(i).getAllPrice());
            preparedStatement.setInt(4,cart.getProducts().get(i).getProduct().getId());
            preparedStatement.executeUpdate();
        }

        String cartId = "select c.id from Cart as c left join" +
                " Cart_has_Product ChP on c.id = ChP.Cart_id where User_id=? and number=?   ";
        preparedStatement = connection.prepareStatement(cartId);
        preparedStatement.setInt(1,cart.getUserId());
        preparedStatement.setInt(2,cart.getProducts().get(cart.getProducts().size()-1).getNumber());
        //preparedStatement.setInt(3,cart.getAllPrice());
        ResultSet resultSet = preparedStatement.executeQuery();
        int id=0;
        while (resultSet.next()){
             id= resultSet.getInt(1);

        }

       String sql ="insert  into  Cart_has_Product (Cart_id,Product_id) values (?,?)";
       preparedStatement =connection.prepareStatement(sql);
       preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,cart.getProducts().get(cart.getProducts().size()-1).getProduct().getId());
        preparedStatement.executeUpdate();

    return id;
    }

    @Override
    public void viewCart(int userId) throws SQLException {
        String viewCart = "select P.name, c.number,P.price, c.AllPrice , c.id ,P.id from Cart as c left join" +
                " Cart_has_Product ChP on c.id = ChP.Cart_id left join Product P on ChP.Product_id = P.id where User_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(viewCart);
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print("produCt id : " +resultSet.getInt(6)+"\t");
                System.out.print("product name  " +resultSet.getString(1)+"\t");
                System.out.print("number : " +resultSet.getInt(2)+"\t");
                System.out.print("price : " +resultSet.getInt(3)+"\t");
                System.out.print("allPrice : " +resultSet.getInt(4)+"\t");
                System.out.println("cart id : "+resultSet.getInt(5)+"\t");
                System.out.println();

            }
    }

    @Override
    public void deleteFromCart(int cartId,int productId) throws SQLException {
        String deleteCHP = "DELETE FROM Cart_has_Product  WHERE cart_id = ? and product_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteCHP);
        preparedStatement.setInt(1,cartId);
        preparedStatement.setInt(2,productId);
        preparedStatement.executeUpdate();


        String  delete = "DELETE FROM Cart  WHERE id = ? and  productId=?";
         preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,cartId);
        preparedStatement.setInt(2,productId);

        preparedStatement.executeUpdate();


    }

    @Override
    public Cart selectCart(int userId) throws SQLException {
        String viewCart = "select P.name, c.number,P.price, c.AllPrice , c.id ,P.id from Cart as c left join" +
                " Cart_has_Product ChP on c.id = ChP.Cart_id left join Product P on ChP.Product_id = P.id where User_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(viewCart);
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Cart cart = new Cart();
        while (resultSet.next()){
             String productName;
             int productId;
             int cartItemNumber;
              int price;
              int cartId ;

            productId=  resultSet.getInt(6);
            productName= resultSet.getString(1);
           cartItemNumber= resultSet.getInt(2);
            price= resultSet.getInt(3);
           cartId= resultSet.getInt(5);

            Product product = new Product();
            product.setId(productId);
            product.setPrice(price);
            product.setName(productName);
            CartItem cartItem = new CartItem(product,cartItemNumber);

            cart.setId(cartId);
            cart.setProducts(cartItem);
            cart.setUserId(userId);

        }
        cart.calculateCartPrice();
        return cart;
    }

    @Override
    public void editItemNUmber() {

    }


}
