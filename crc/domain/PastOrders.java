package domain;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.List;

public class PastOrders {

  private   Product product;

  private int userID;
  private int price;
  private  Address address;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PastOrders(Product product, int userID, int price) {
        this.product = product;
        this.userID = userID;
        this.price = price;
    }
    public  PastOrders(){

    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
