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
import net.javaguides.registration.model.User;

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
	public List<Transaction> getAllTransactions() {

			List<Transaction> foodItems = new ArrayList<>();
			String sql = "SELECT * FROM transactions";
			try (Connection connection = DbConnection.getConnection();
				 PreparedStatement statement = connection.prepareStatement(sql);
				 ResultSet resultSet = statement.executeQuery()) {

				while (resultSet.next()) {
					Transaction foodItem = new Transaction();
					foodItem.setItemID(resultSet.getInt("ItemID"));
					foodItem.setQuantity(resultSet.getInt("Quantity"));
					foodItem.setName(resultSet.getString("Name"));
					foodItem.setQuantity(resultSet.getInt("PhoneNumber"));
					foodItem.setAddress(resultSet.getString("Address"));
					foodItem.setDeliveryDate(resultSet.getDate("DeliveryDate"));

					foodItems.add(foodItem);
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return foodItems;
		}
	}
