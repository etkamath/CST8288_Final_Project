package net.javaguides.registration.model;

import java.util.Date;

public class FoodItem {
    private int itemID; // Assuming auto-increment in the database
    private int retailerID; // Foreign Key to Retailer.retailerID
    private String name;
    private int quantity;
    private Date expiryDate;
    private boolean isSurplus;

    // Constructor, getters, and setters
    public FoodItem() {}

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getRetailerID() {
        return retailerID;
    }

    public void setRetailerID(int retailerID) {
        this.retailerID = retailerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean isSurplus) {
        this.isSurplus = isSurplus;
    }
}
