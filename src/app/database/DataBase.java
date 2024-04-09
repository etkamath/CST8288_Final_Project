package app.database;


import app.database.dao.*;

/**
 * Database class
 */
public abstract class DataBase {
    public abstract RetailerDao retailerDao();
    public abstract UserDao userDao();

    // its String For Now But You can change it to any type that you want
    public abstract NotificationDao<String> notificationDao();
    public abstract CharitableOrganizationDao charitableOrganizationDao();
    public abstract ConsumerDao consumerDao();
    public abstract FoodDao foodDao();
}
