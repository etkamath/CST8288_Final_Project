package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.Transaction;

public class TransactionDao {

    public void createTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transactions (ItemID, UserID, Quantity, TransactionType, TransactionDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getItemID());
            statement.setInt(2, transaction.getUserID());
            statement.setInt(3, transaction.getQuantity());
            statement.setString(4, transaction.getTransactionType());
            statement.setTimestamp(5, new java.sql.Timestamp(transaction.getTransactionDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Transaction findTransactionById(int transactionId) {
        Transaction transaction = null;
        String sql = "SELECT * FROM Transactions WHERE TransactionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transactionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    transaction = new Transaction();
                    transaction.setTransactionID(resultSet.getInt("TransactionID"));
                    transaction.setItemID(resultSet.getInt("ItemID"));
                    transaction.setUserID(resultSet.getInt("UserID"));
                    transaction.setQuantity(resultSet.getInt("Quantity"));
                    transaction.setTransactionType(resultSet.getString("TransactionType"));
                    transaction.setTransactionDate(resultSet.getTimestamp("TransactionDate"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE Transactions SET ItemID = ?, UserID = ?, Quantity = ?, TransactionType = ?, TransactionDate = ? WHERE TransactionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getItemID());
            statement.setInt(2, transaction.getUserID());
            statement.setInt(3, transaction.getQuantity());
            statement.setString(4, transaction.getTransactionType());
            statement.setTimestamp(5, new java.sql.Timestamp(transaction.getTransactionDate().getTime()));
            statement.setInt(6, transaction.getTransactionID());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(int transactionId) {
        String sql = "DELETE FROM Transactions WHERE TransactionID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transactionId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
