package net.javaguides.registration.model;

import java.util.Date;

public class Orders {
    private int orderID;
    private int itemID;
    private int quantity;
    private String name;
    private String phoneNumber;
    private String address;
    private Date deliveryDate;

    // Constructor
    public Orders() {
    }

    // Getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderId) {
        this.orderID = orderId;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemId) {
        this.itemID = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
