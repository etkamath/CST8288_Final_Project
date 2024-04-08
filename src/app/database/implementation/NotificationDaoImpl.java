package app.database.implementation;

import app.database.dao.NotificationDao;

import java.util.List;

public class NotificationDaoImpl implements NotificationDao<String> {

    @Override
    public void notifyAllSubscribers(String information) {
        //TODO: Query To add information for all those members who have subscribed
    }

    public List<String> userNotification(int userId) {
        //TODO: Query to Select Consumer Notifications
        return null;
    }
}
