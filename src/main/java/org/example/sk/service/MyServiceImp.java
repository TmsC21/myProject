package org.example.sk.service;

import org.example.sk.model.MyUser;

import java.sql.*;
import java.util.ArrayList;

public class MyServiceImp implements MyService {

    private Connection connection;

    public MyServiceImp(Connection connection) {
        this.connection = connection;
    }

    public MyServiceImp() {
    }

    @Override
    public void addUser(int id, String guid, String name) {
        MyUser user = new MyUser(id, guid, name);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getGuid());
            preparedStatement.setString(3, user.getName());
            preparedStatement.executeUpdate();
            System.out.println("User " + user + " added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<MyUser> getAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT USER_ID, USER_GUID, USER_NAME FROM SUSERS");
            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<MyUser> users = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("USER_ID");
                String guid = rs.getString("USER_GUID");
                String name = rs.getString("USER_NAME");
                MyUser user = new MyUser(id, guid, name);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAll() {
        try {
            Statement statement = connection.createStatement();

            String deleteSql = "DELETE FROM SUSERS";
            int rowsAffected = statement.executeUpdate(deleteSql);

            System.out.println("Deleted " + rowsAffected + " users.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
