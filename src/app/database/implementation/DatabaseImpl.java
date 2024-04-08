package app.database.implementation;

import app.database.DataBase;
import app.database.dao.*;
import app.database.implementation.RetailersDaoImpl;
import app.database.implementation.UserDaoImpl;

public class DatabaseImpl extends DataBase {
    @Override
    public RetailerDao retailerDao() {
        return new RetailersDaoImpl();
    }

    @Override
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Override
    public NotificationDao<String> notificationDao() {
        return new NotificationDaoImpl();
    }

    @Override
    public CharitableOrganizationDao charitableOrganizationDao() {
        return new CharitableOrganizationDaoImpl();
    }

    @Override
    public ConsumerDao consumerDao() {
        return new ConsumerDaoImpl();
    }

    @Override
    public FoodDao foodDao() {
        return new FoodDaoImpl();
    }
}
