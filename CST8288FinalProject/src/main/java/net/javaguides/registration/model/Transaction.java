package net.javaguides.registration.model;

import java.util.Date;

public class Transaction {
    private int transactionID; // Otomatik artırılacak, Primary Key
    private int itemID; // FoodItem tablosundan Foreign Key
    private int quantity; // Sipariş miktarı
    private String name; // İsim
    private String phoneNumber; // Telefon Numarası
    private String address; // Adres
    private Date deliveryDate; // Teslimat Tarihi

    // Constructor, getters ve setters
    public Transaction() {}

    // Getter ve setter metodları...
    
    // transactionID için setter metoduna gerek yok çünkü otomatik artırılacak
    public int getTransactionID() {
        return transactionID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
