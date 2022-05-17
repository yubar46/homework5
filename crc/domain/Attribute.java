package domain;

public class Attribute {

    private  int id;
    private String title;
    private int productTypeId;

    public Attribute(String title, int productTypeId) {
        this.title = title;
        this.productTypeId = productTypeId;
    }
    public Attribute(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }
}

