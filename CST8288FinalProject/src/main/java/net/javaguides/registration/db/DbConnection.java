package net.javaguides.registration.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123qweasdzc";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
