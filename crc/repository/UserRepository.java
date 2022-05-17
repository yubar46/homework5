package repository;

import domain.User;

import java.sql.SQLException;

public interface UserRepository {
    public int addUser(User user) throws SQLException;
    public User readUser(int id) throws SQLException;
    public void editUser(User user);
    public void deleteUser(User user);

    public int cheekLogin(String username,String password) throws SQLException;
    public boolean validUser(String userName) throws SQLException;
    public boolean validPhoneNumber(String phoneNumber) throws SQLException;
    public boolean validEmail(String email) throws SQLException;

}
