package domain;

import java.util.ArrayList;

public class Cart {
   private int itemsPrices;
   private int  allPrice;
   private int UserId;
   int id;
   Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private ArrayList<Product>products = new ArrayList<Product>(5);

    public Cart(){

    }

    public void calculateItemPrice(){
        for (int i=0;i<products.size();i++){
           allPrice+= products.get(i).getPrice()*products.get(i).getNumber();


        }

    }

    public int getItemsPrices() {
        return itemsPrices;
    }

    public void setItemsPrices(int itemsPrices) {
        this.itemsPrices = itemsPrices;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

}
