```java
package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Retailer;

/**
 * Data access object for managing retailers in the database.
 */
public class RetailerDao {

    /**
     * Creates a new retailer in the database.
     * @param retailer The retailer to be created
     */
    public void createRetailer(Retailer retailer) {
        String sql = "INSERT INTO Retailers (RetailerID, StoreName, Location) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, retailer.getRetailerID());
            statement.setString(2, retailer.getStoreName());
            statement.setString(3, retailer.getLocation());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a retailer by their ID in the database.
     * @param retailerId The ID of the retailer to find
     * @return The retailer if found, null otherwise
     */
    public Retailer findRetailerById(int retailerId) {
        Retailer retailer = null;
        String sql = "SELECT * FROM Retailers WHERE RetailerID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, retailerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    retailer = new Retailer();
                    retailer.setRetailerID(resultSet.getInt("RetailerID"));
                    retailer.setStoreName(resultSet.getString("StoreName"));
                    retailer.setLocation(resultSet.getString("Location"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retailer;
    }

    /**
     * Updates a retailer's information in the database.
     * @param retailer The retailer to be updated
     */
    public void updateRetailer(Retailer retailer) {
        String sql = "UPDATE Retailers SET StoreName = ?, Location = ? WHERE RetailerID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, retailer.getStoreName());
            statement.setString(2, retailer.getLocation());
            statement.setInt(3, retailer.getRetailerID());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a retailer from the database.
     * @param retailerId The ID of the retailer to be deleted
     */
    public void deleteRetailer(int retailerId) {
        String sql = "DELETE FROM Retailers WHERE RetailerID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, retailerId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

I have added Javadoc comments to each method in the `RetailerDao` class, providing a description of what each method does and the parameters it takes. Let me know if you need further assistance!