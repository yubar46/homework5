package util;

import domain.Cart;
import domain.Product;
import domain.User;
import repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContext {

private DatabaseUtil databaseUtil = new DatabaseUtil();
private User user = new User();
private Cart cart = new Cart();




   private UserRepository userRepository = new UserRepositoryJDBC(databaseUtil.connection,user);
    private ProductRepository productRepository= new ProductRepositoryJDBC(databaseUtil.connection);
    private FeatureRepository featureRepository = new FeatureRepositoryJDBC(databaseUtil.connection);
    private AttributeRepository attributeRepository= new AttributeRepositoryJDBC(databaseUtil.connection);
    private AddressRepository addressRepository = new AddressRepositoryJDBC(databaseUtil.connection);
    private ProductTypeRepository productTypeRepository = new ProductTypeRepositoryJDBC(databaseUtil.connection);
    private CartRepository cartRepository = new CartRepositoryJDBC(databaseUtil.connection);
    private PastOrdersRepository pastOrdersRepository = new PastOrdersRepositoryJDBC(databaseUtil.connection);

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public FeatureRepository getFeatureRepository() {
        return featureRepository;
    }

    public AttributeRepository getAttributeRepository() {
        return attributeRepository;
    }

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public ProductTypeRepository getProductTypeRepository() {
        return productTypeRepository;
    }

    public ApplicationContext () throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public PastOrdersRepository getPastOrdersRepository() {
        return pastOrdersRepository;
    }
}
