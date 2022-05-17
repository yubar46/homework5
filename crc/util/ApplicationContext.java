package util;

import domain.Cart;
import domain.Product;
import domain.User;
import repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContext {

private DatabaseUtil databaseUtil;
private User user = new User();
private Cart cart = new Cart();

     String databaseUrl="jdbc:mysql://localhost:3306/homeWork5";
     String databaseUser ="user";
     String databasePassword=  "123321";
    Connection connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);


   private UserRepository userRepository = new UserRepositoryJDBC(connection,user);
    private ProductRepository productRepository= new ProductRepositoryJDBC(databaseUtil.getConnection());
    private FeatureRepository featureRepository = new FeatureRepositoryJDBC(databaseUtil.getConnection());
    private AttributeRepository attributeRepository= new AttributeRepositoryJDBC(databaseUtil.getConnection());
    private AddressRepository addressRepository = new AddressRepositoryJDBC(databaseUtil.getConnection());
    private ProductTypeRepository productTypeRepository = new ProductTypeRepositoryJDBC(databaseUtil.getConnection());
    private CartRepository cartRepository = new CartRepositoryJDBC(databaseUtil.getConnection());
    private PastOrdersRepository pastOrdersRepository = new PastOrdersRepositoryJDBC(databaseUtil.getConnection());

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
