package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private  String firstName;
    private  String lastName;
    private  String phoneNumber;
    private String email;
    private  int id;


    private List<Address> addresses;

   private Cart cart = new Cart();

   private List<PastOrders> pastOrders;



    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User(String userName, String password, String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;

    }
    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses.add(addresses);
    }


    public List<PastOrders> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<PastOrders> pastOrders) {
        this.pastOrders = pastOrders;
    }
}
