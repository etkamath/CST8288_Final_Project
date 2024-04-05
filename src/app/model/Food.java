package app.model;

import app.model.FoodFlag;

import java.time.LocalDate;

public class Food {
    private int id;//AutoIncrement ID
    private LocalDate expirationDate;
    private String name;
    private int quantity;
    private FoodFlag flag;
    private int price;
    private int discount = 0;//default value -> discount is zero

    public Food( String name, int quantity,LocalDate expirationDate, FoodFlag flag) {
        this.name = name;
        this.quantity = quantity;
        this.flag = flag;
        this.expirationDate = expirationDate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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

    public FoodFlag getFlag() {
        return flag;
    }

    public void setFlag(FoodFlag flag) {
        this.flag = flag;
    }
}
