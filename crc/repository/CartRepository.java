package repository;

import domain.Cart;

import java.sql.SQLException;

public interface CartRepository {

    public int   addToCart(Cart cart) throws SQLException;
    public void   viewCart(int userId) throws SQLException;
    public void   deleteFromCart(int cartId) throws SQLException;
    public  void    editItemNUmber();


}
