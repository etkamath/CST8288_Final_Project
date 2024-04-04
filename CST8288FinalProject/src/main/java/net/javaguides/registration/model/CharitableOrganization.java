package net.javaguides.registration.model;

public class CharitableOrganization {
    private int organizationID; // Foreign Key to User.userID
    private String organizationName;
    private String location;

    // Constructor, getters, and setters
    public CharitableOrganization() {}

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
