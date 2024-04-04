package net.javaguides.registration.model;

import java.util.Date;

public class Transaction {
    private int transactionID; // Assuming auto-increment in the database
    private int itemID; // Foreign Key to FoodItem.itemID
    private int userID; // Foreign Key to User.userID
    private int quantity;
    private String transactionType; // ENUM 'Purchase', 'Donation'
    private Date transactionDate;

    // Constructor, getters, and setters
    public Transaction() {}

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
