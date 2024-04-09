package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Transaction;

/**
 * Data access object for managing transactions in the database.
 */
public class TransactionDao {
	
	/**
	 * Adds a new transaction to the database.
	 * @param transaction The transaction to be added
	 */
	public void addTransaction(Transaction transaction) {
	    String sql = "INSERT INTO Transactions (ItemID, Quantity, Name, PhoneNumber, Address, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, transaction.getItemID());
	        stmt.setInt(2, transaction.getQuantity());
	        stmt.setString(3, transaction.getName());
	        stmt.setString(4, transaction.getPhoneNumber());
	        stmt.setString(5, transaction.getAddress());
	        // Use setDate method with correct index and data type to avoid errors.
	        stmt.setDate(6, new java.sql.Date(transaction.getDeliveryDate().getTime()));
	        
	        stmt.executeUpdate();
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
}
