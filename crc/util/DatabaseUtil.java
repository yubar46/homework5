package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private Connection connection;
    private String databaseUrl="jdbc:mysql://localhost:3306/homeWork5";
    private String databaseUser ="user";
    private String databasePassword=  "123321";

    public  DatabaseUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        this.databaseUrl = "jdbc:mysql://localhost:3306/homeWork5";
        this.databaseUser = "user";
        this.databasePassword = "123321";
        this.connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
    }

    public Connection getConnection() throws SQLException {
        return  this.connection = DriverManager.getConnection(databaseUrl,databaseUser,databasePassword);
    }




}
