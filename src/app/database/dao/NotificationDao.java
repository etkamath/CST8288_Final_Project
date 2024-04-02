package app.database.dao;

import java.util.List;

/**
 * Notification is a Type of T(String, Message class object etc)
 * @param <T>
 */
public interface NotificationDao<T>{
    void notifyAllSubscribers(T information);

    /**
     * Query to select user with userId notifications
     * @param userId
     * @return List of Notifications
     */
    List<T> userNotification(int userId);
}
