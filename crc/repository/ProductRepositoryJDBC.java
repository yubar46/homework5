package repository;

import domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryJDBC implements  ProductRepository {

    Connection connection;

    public  ProductRepositoryJDBC(Connection connection){
        this.connection=connection;
    }

    @Override
    public int createProduct(Product product) {
        return 0;
    }

    @Override
    public void readProduct(Product product) {

    }

    @Override
    public void editProduct(Product product,int newNumber) throws SQLException {
        String edit = "UPDATE Product SET number = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(1,newNumber);
        preparedStatement.setInt(2,product.getId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteProduct(Product product) {

    }

    public void showAllProducts(int ptId) throws SQLException {
        String showProducts = "select p.name,A.title,f.value,p.price,p.number,p.id,pt.name,A.id  from ProductType as pt left join  Product as p on" +
                " pt.id = p.ProductType_id left join ProductType_has_Attribute  as PThA on pt.id = PThA.ProductType_id" +
                "  left join Attribute  as A on PThA.Attribute_id = A.id left join Feature as f on f.AttributeId = A.id where pt.id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(showProducts);
        preparedStatement.setInt(1,ptId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int productId=0;
        int valueId=0;
        while (resultSet.next()){
            if (resultSet.getInt(5)>0){

                    if (resultSet.getInt(6)!=productId){
                        System.out.print( resultSet.getString(7)+" name:  " +resultSet.getString(1)+"\t");
                        System.out.print(resultSet.getString(2)+" :"+resultSet.getString(3)+"\t");
                        System.out.print( "price : "+resultSet.getString(4)+"\t");
                        System.out.print( "number : "+resultSet.getString(5)+"\t");
                        System.out.print( "product id  : "+resultSet.getString(6)+"\t");
                        System.out.println();
                        productId=resultSet.getInt(6);
                    }else if (resultSet.getInt(8)!=valueId){
                        System.out.println();
                        System.out.print(resultSet.getString(2)+" :"+resultSet.getString(3)+"\t");
                        System.out.println();
                        valueId=resultSet.getInt(8);
                    }



            }

        }

    }

    public Product selectProduct(int productId) throws SQLException {
        Product product = new Product();
        String selectProduct ="select p.id,p.name,p.number,p.price,p.ProductType_id,F.AttributeId,F.value  from ProductType as pt left join Product" +
                " as p on pt.id = p.ProductType_id left join ProductType_has_Attribute as ptha on" +
                "    pt.id = ptha.ProductType_id left join Attribute a on ptha.Attribute_id = a.id= 1 " +
                "left join Feature F on a.id = F.AttributeId where p.id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectProduct);
        preparedStatement.setInt(1,productId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setNumber(resultSet.getInt(3));
                product.setPrice(resultSet.getInt(4));
                product.setProductTypeId(resultSet.getInt(5));




        }
        return product;
    }

    public boolean isExist(Product product, int nOfOrder) throws SQLException {
        boolean isExist = false;

        String cheek="select  number from Product as p where p.id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(cheek);
        preparedStatement.setInt(1,product.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getInt(1)-nOfOrder>=0)isExist=true;
        }

         return isExist;


    }
}
