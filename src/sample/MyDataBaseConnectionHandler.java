package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataBaseConnectionHandler {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/kcs";
    private static final String LOGIN_NAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Neprisijungeme " + e);
        }
        return connection;
    }



}
