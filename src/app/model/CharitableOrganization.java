package app.model;

public class CharitableOrganization extends User{
    public CharitableOrganization(String name, String email, String password) {
        super(name, email, password, UserType.CHARITABLE_ORGANIZATIONS);
    }
}
