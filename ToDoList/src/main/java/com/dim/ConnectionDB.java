package com.dim;

import java.sql.DriverManager;

public class ConnectionDB {

    public static java.sql.Connection connection;

    public static void connect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "dima";
            String password = "193105610";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
