package repository;

import domain.Cart;

import java.sql.SQLException;

public interface CartRepository {

    public int   addToCart(Cart cart,int userId) throws SQLException;
    public void   viewCart(int userId) throws SQLException;
    public void   deleteFromCart(int cartId,int productId) throws SQLException;
    public Cart selectCart(int userId) throws SQLException;
    public  void    editItemNUmber();
    public void eraseCart(int userId) throws SQLException;


}
