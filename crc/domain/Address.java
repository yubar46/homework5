package domain;

public class Address {
    private String state;
    private String city;
    private String streetName;
    private String pistolCode;
    private int UserId;
    private int id;

    public Address(String state, String city, String streetName, String pistolCode) {
        this.state = state;
        this.city = city;
        this.streetName = streetName;
        this.pistolCode = pistolCode;
    }

    public Address() {

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

    public String getPistolCode() {
        return pistolCode;
    }

    public void setPistolCode(String pistolCode) {
        this.pistolCode = pistolCode;
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

    @Override
    public String toString() {
        return String.format("%s %s%s%s%s %n", state+" ", city+" ", streetName+" ", "pistol code: ", pistolCode);
    }
}
