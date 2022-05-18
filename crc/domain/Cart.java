package domain;

import java.util.ArrayList;

public class Cart {
   private int cartPrice;
   private int UserId;
   int id;

   Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private ArrayList<CartItem >products = new ArrayList<CartItem>(5);

    public Cart(){

    }

    public void calculateCartPrice(){
        for (int i=0;i<products.size();i++){


            cartPrice+= products.get(i).getAllPrice();

        }

    }

    public int getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(int cartPrice) {
        this.cartPrice = cartPrice;
    }





    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }



    public ArrayList<CartItem> getProducts() {
        return products;
    }

    public void setProducts(CartItem cartItem) {
        this.products.add(cartItem);
    }
}
