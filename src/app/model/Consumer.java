package app.model;

import app.model.User;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends User {
    private int balance;

    public Consumer(String name, String email, String password) {
        super(name, email, password,UserType.CONSUMERS);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
