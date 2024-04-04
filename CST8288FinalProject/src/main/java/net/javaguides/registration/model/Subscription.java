package net.javaguides.registration.model;

public class Subscription {
    private int subscriptionID; // Assuming auto-increment in the database
    private int userID; // Foreign Key to User.userID
    private String preferences;
    private String location;
    private String contactMethod; // ENUM 'Email', 'Phone'

    // Constructor, getters, and setters
    public Subscription() {}

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}
