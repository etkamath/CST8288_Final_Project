package net.javaguides.registration.model;

public class Retailer {
    private int retailerID; // Foreign Key to User.userID
    private String storeName;
    private String location;

    // Constructor, getters, and setters
    public Retailer() {}

    public int getRetailerID() {
        return retailerID;
    }

    public void setRetailerID(int retailerID) {
        this.retailerID = retailerID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
