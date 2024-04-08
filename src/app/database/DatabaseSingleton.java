package app.database;

import app.database.implementation.DatabaseImpl;

public class DatabaseSingleton {

    private static DataBase dataBase;
    private DatabaseSingleton(){}

    public static DataBase getDatabase(){
        if(dataBase==null){
            dataBase = new DatabaseImpl();
        }
        return dataBase;
    }

}
