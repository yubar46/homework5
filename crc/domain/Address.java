package domain;

public class Address {
    private String state;
    private String city;
    private String streetName;
    private String pisitolCode;
    private int UserId;
    private int id;

    public Address(String state, String city, String streetName, String pisitolCode) {
        this.state = state;
        this.city = city;
        this.streetName = streetName;
        this.pisitolCode = pisitolCode;
    }

    public Address(){

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPisitolCode() {
        return pisitolCode;
    }

    public void setPisitolCode(String pisitolCode) {
        this.pisitolCode = pisitolCode;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String  toString(){
        return String.format("%s %s %s %s ",state,city, streetName,pisitolCode);
    }
}
