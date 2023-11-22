package org.example.sk.utils;

import org.example.sk.model.MyUser;

import java.sql.*;

public class MyDatabase {

    private final Connection connection;

    public MyDatabase() throws SQLException {
        String jdbcURL = "jdbc:h2:mem:test";
        this.connection = DriverManager.getConnection(jdbcURL);
    }

    public void createConntection() throws SQLException{

        System.out.println("Connected to H2 in-memory database.");
        String sql = "CREATE TABLE SUSERS (\n" +
                "    USER_ID INT PRIMARY KEY,\n" +
                "    USER_GUID VARCHAR(50) NOT NULL,\n" +
                "    USER_NAME VARCHAR(50) NOT NULL\n" +
                ");";

        connection.createStatement().execute(sql);
        System.out.println("The users table was created");
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
        System.out.println("Disconnected from H2 in-memory database.");
    }

    public Connection getConnection() {
        return this.connection;
    }
}
