package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.FoodItem;
import net.javaguides.registration.model.Subscription;

public class SubscriptionDao {

    public void createSubscription(Subscription subscription) {
        String sql = "INSERT INTO Subscriptions (UserID, Preferences, Location, ContactMethod) VALUES (?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscription.getUserID());
            statement.setString(2, subscription.getPreferences());
            statement.setString(3, subscription.getLocation());
            statement.setString(4, subscription.getContactMethod());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Subscription findSubscriptionById(int subscriptionId) {
        Subscription subscription = null;
        String sql = "SELECT * FROM Subscriptions WHERE SubscriptionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscriptionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    subscription = new Subscription();
                    subscription.setSubscriptionID(resultSet.getInt("SubscriptionID"));
                    subscription.setUserID(resultSet.getInt("UserID"));
                    subscription.setPreferences(resultSet.getString("Preferences"));
                    subscription.setLocation(resultSet.getString("Location"));
                    subscription.setContactMethod(resultSet.getString("ContactMethod"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subscription;
    }

    public void updateSubscription(Subscription subscription) {
        String sql = "UPDATE Subscriptions SET UserID = ?, Preferences = ?, Location = ?, ContactMethod = ? WHERE SubscriptionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscription.getUserID());
            statement.setString(2, subscription.getPreferences());
            statement.setString(3, subscription.getLocation());
            statement.setString(4, subscription.getContactMethod());
            statement.setInt(5, subscription.getSubscriptionID());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubscription(int subscriptionId) {
        String sql = "DELETE FROM Subscriptions WHERE SubscriptionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, subscriptionId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Subscription findSubscriptionByUserId(int userId) {
        Subscription subscription = null;
        String sql = "SELECT * FROM Subscriptions WHERE UserID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    subscription = new Subscription();
                    subscription.setSubscriptionID(resultSet.getInt("SubscriptionID"));
                    subscription.setUserID(resultSet.getInt("UserID"));
                    subscription.setPreferences(resultSet.getString("Preferences"));
                    subscription.setLocation(resultSet.getString("Location"));
                    subscription.setContactMethod(resultSet.getString("ContactMethod"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subscription;
        }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions= new ArrayList<>();
        String sql = "SELECT * FROM Subscriptions";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Subscription subscription = null;
                    subscription = new Subscription();
                    subscription.setSubscriptionID(resultSet.getInt("SubscriptionID"));
                    subscription.setUserID(resultSet.getInt("UserID"));
                    subscription.setPreferences(resultSet.getString("Preferences"));
                    subscription.setLocation(resultSet.getString("Location"));
                    subscription.setContactMethod(resultSet.getString("ContactMethod"));
              subscriptions.add(subscription);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }
}