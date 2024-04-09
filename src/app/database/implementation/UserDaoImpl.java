package app.database.implementation;

import app.database.dao.UserDao;
import app.model.User;
import app.model.UserType;

public class UserDaoImpl implements UserDao {
    @Override
    public User authLogin(String email, String password, UserType userType) {
        //TODO: Query to Authenticate User
        return null;
    }

    @Override
    public boolean registerUser(User user) {
        //TODO: Query to Register User
        return false;
    }

    @Override
    public void subscribe(int userId) {
        //TODO: Query to subscribe
    }

    @Override
    public void unsubscribe(int userId) {
        //TODO: Query to unsubscribe
    }

}
