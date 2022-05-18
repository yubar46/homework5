package domain;

public class CartItem {
    private Product product;
    private int number;
    int allPrice;

    public CartItem(Product product, int number) {
        this.product = product;
        this.number = number;
        this.allPrice = product.getPrice()*number;

    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }
}
