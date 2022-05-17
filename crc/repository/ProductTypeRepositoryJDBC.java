package repository;

import domain.Product;
import domain.ProductType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductTypeRepositoryJDBC implements ProductTypeRepository {

    Connection connection;

    public ProductTypeRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(ProductType productType) {
        return 0;
    }

    @Override
    public ProductType read(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public ProductType edit(ProductType productType) {
        return null;
    }

    @Override
    public void readAllProductTypes() throws SQLException {
        String allPT = "select *from ProductType";
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery(allPT);
        while (resultSet.next()){
            System.out.print("id: "+resultSet.getInt(1)+"\t");
            System.out.printf("%s %s %n","product type: "+resultSet.getString(2));

        }


    }
}
