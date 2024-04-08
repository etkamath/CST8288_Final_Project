package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.FoodItem;
import net.javaguides.registration.model.Transaction;

public class TransactionDao {
	public void addTransaction(Transaction transaction) {
	    String sql = "INSERT INTO Transactions (ItemID, Quantity, Name, PhoneNumber, Address, DeliveryDate) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DbConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, transaction.getItemID());
	        stmt.setInt(2, transaction.getQuantity());
	        stmt.setString(3, transaction.getName());
	        stmt.setString(4, transaction.getPhoneNumber());
	        stmt.setString(5, transaction.getAddress());
	        // Hataya sebep olan kısım burası olabilir. 
	        // Doğru index ve veri tipiyle setDate kullanılmalı.
	        stmt.setDate(6, new java.sql.Date(transaction.getDeliveryDate().getTime()));
	        
	        stmt.executeUpdate();
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	}
