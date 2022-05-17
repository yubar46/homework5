package repository;

import domain.ProductType;

import java.sql.SQLException;

public interface ProductTypeRepository {

    public int create(ProductType productType);

    public ProductType read(int id);
    public void delete (int id);
    public ProductType edit(ProductType productType);
    public void readAllProductTypes() throws SQLException;
}
