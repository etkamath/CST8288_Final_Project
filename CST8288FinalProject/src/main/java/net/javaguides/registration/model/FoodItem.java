package net.javaguides.registration.model;

import java.util.Date;

public class FoodItem {
    private int itemID; // Assuming auto-increment in the database
    private int retailerID; // Foreign Key to Retailer.retailerID
    private String name;
    private int quantity;
    private Date expiryDate;
    private boolean isSurplus;
    private String surplusType; // "Donation" or "Sale"


    //discount 0 means for donation and upper than 0 means for sale at reduced price
   private double discount=0;



    // Constructor, getters, and setters
    public FoodItem() {}
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


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
    

    public String getSurplusType() {
        return surplusType;
    }

    public void setSurplusType(String surplusType) {
        this.surplusType = surplusType;
    }

}
