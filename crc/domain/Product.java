package domain;

import java.util.List;

public class Product {

    private String name;
    private int number ;
    private  int price;
    private String image;
    private int id;
    private  int ProductTypeId;
    private List<Feature> features;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Product(){

    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        ProductTypeId = productTypeId;
    }
}
