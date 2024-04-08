package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Orders;

public class OrdersDao {
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
