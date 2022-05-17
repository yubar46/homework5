package repository;

import domain.PastOrders;

import java.sql.SQLException;

public interface PastOrdersRepository {

    public void AddToPastOrders(PastOrders pastOrders) throws SQLException;
}
