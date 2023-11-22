package org.example.sk;

import org.example.sk.controller.MyController;
import org.example.sk.utils.MyDatabase;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        MyController myController = new MyController();
        try {
            MyDatabase myDatabase = new MyDatabase();
            myDatabase.createConntection();
            myDatabase.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}