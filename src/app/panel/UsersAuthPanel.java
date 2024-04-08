package app.panel;

import app.database.DataBase;
import app.database.DatabaseSingleton;
import app.model.*;

public class UsersAuthPanel {
    private DataBase db = DatabaseSingleton.getDatabase();;


    /**
     * if User Logged in Successfully, we guide him to his specific Panel
     * @param email
     * @param pass
     * @param userType
     * @return specific user panel else returns null if authentication failed
     */
    public UserPanel loginToPanel(String email, String pass, UserType userType){
        User loggedIn = db.userDao().authLogin(email,pass,userType);
        if(loggedIn!=null){
            switch (userType){
                case RETAILERS -> {return new RetailerPanel((Retailer) loggedIn);}
                case CONSUMERS ->{return  new ConsumerPanel((Consumer) loggedIn);}
                case CHARITABLE_ORGANIZATIONS -> {return new CharitableOrganizationPanel((CharitableOrganization) loggedIn);}
            }
        }
        return null;
    }
    public boolean signUpUser(User user){
        return db.userDao().registerUser(user);
    }

}
