package repository;

import domain.Address;

import java.sql.SQLException;

public interface AddressRepository {

    public int addAddress(Address address) throws SQLException;

    public void readAddress(int userId) throws SQLException;

    public void editAddress(Address address);

    public void deleteAddress(Address address);


}
