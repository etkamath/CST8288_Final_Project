
package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Orders;

/**
 * Data access object for managing orders in the database.
 */
public class OrdersDao {

    /**
     * Adds a new order to the database.
     * @param orders The order to be added
     */
    public void addOrders(Orders orders) {
        String sql = "INSERT INTO Orders (ItemID, Quantity, Name, PhoneNumber, Address, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orders.getItemID());
            stmt.setInt(2, orders.getQuantity());
            stmt.setString(3, orders.getName());
            stmt.setString(4, orders.getPhoneNumber());
            stmt.setString(5, orders.getAddress());
            stmt.setDate(6, new java.sql.Date(orders.getDeliveryDate().getTime()));
            
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
```
