package app.model;

public class Retailer extends User{
    public Retailer(String name, String email, String password) {
        super(name, email, password, UserType.RETAILERS);
    }
}
