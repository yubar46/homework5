package repository;

import domain.PastOrders;
import domain.User;

import java.sql.SQLException;

public interface PastOrdersRepository {

    public void AddToPastOrders(PastOrders pastOrders, User user) throws SQLException;
    public void selectPastOrders(int userId) throws SQLException;
}
