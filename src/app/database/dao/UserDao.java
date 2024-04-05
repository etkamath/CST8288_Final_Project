package app.database.dao;

import app.model.User;
import app.model.UserType;

/**
 * A Dao class is used to separates a data resource's client interface from its data access mechanisms.
 * UserDAO is Used to querying on user table
 */
public interface UserDao {

    /**
     * authenticate user information to login into his account
     * @param email
     * @param password
     * @param userType We save user type with codes in database. so we authenticate user information with its user type code next to email and password
     * @return true if user logged in successfully else false
     */
    User authLogin(String email, String password, UserType userType);

    /**
     * Register
     * @param user
     * @return false if email is used before else true
     */
    boolean registerUser(User user);


    void subscribe(int userId);
    void unsubscribe(int userId);


}
