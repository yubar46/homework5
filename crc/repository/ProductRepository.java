package repository;

import domain.Product;

import java.sql.SQLException;

public interface ProductRepository {

    public int createProduct(Product product);
    public void readProduct(Product product);
    public void editProduct(Product product,int newNumber) throws SQLException;
    public void deleteProduct(Product product);
    public void showAllProducts(int ptId) throws SQLException;
    public boolean isExist(Product product, int nOfOrder) throws SQLException;
    public Product selectProduct(int productId) throws SQLException;

}
