package domain;

public class Test {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Product product = new Product();
        System.out.println(cart.getProducts().size());
        cart.setProducts(product);
        System.out.println(cart.getProducts().size());
    }
}
