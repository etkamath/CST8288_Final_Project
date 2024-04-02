package app.panel;

import app.database.DataBase;
import app.database.DatabaseSingleton;
import app.model.User;

public abstract class UserPanel<T extends User> {
    private DataBase dataBase = DatabaseSingleton.getDatabase();
    private T loggedIn;

    public UserPanel(T loggedIn) {
        this.loggedIn = loggedIn;
    }

    public T getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(T loggedIn) {
        this.loggedIn = loggedIn;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
