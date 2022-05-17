package domain;

public class Feature {

    private String feature ;
    private int id;

    private int productId;

    private int attributeId;

    public Feature(String feature, int productId, int attributeId) {
        this.feature = feature;
        this.productId = productId;
        this.attributeId = attributeId;
    }

    public Feature() {

    }


    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }
}
