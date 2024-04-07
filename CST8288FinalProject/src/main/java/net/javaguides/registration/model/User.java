package net.javaguides.registration.model;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Etka Dakak
 */
public class User {

    private int userID; // Assuming auto-increment in the database
    private String userName;
    private String email;
    private String password;
    private String userType; // ENUM types can be handled as String in Java for simplicity

    // Constructor, getters, and setters
    public User() {}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}