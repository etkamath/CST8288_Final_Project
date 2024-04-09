package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Subscription;

/**
 * Data access object for managing subscriptions in the database.
 */
public class SubscriptionDao {

    /**
     * Creates a new subscription in the database.
     * @param subscription The subscription to be created
     */
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

    /**
     * Finds a subscription by its ID in the database.
     * @param subscriptionId The ID of the subscription to find
     * @return The subscription if found, null otherwise
     */
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

    /**
     * Updates a subscription's information in the database.
     * @param subscription The subscription to be updated
     */
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

    /**
     * Deletes a subscription from the database.
     * @param subscriptionId The ID of the subscription to be deleted
     */
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
}
```

I have added Javadoc comments to each method in the `SubscriptionDao` class, providing a description of what each method does and the parameters it takes. Let me know if you need further assistance!