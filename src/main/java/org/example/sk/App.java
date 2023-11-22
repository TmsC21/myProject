package org.example.sk;

import org.example.sk.controller.MyController;
import org.example.sk.utils.MyDatabase;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            MyDatabase myDatabase = new MyDatabase();
            myDatabase.createConntection();
            MyController myController = new MyController(myDatabase.getConnection());

            System.out.println("--------------------------------");
            myController.addUser(1, "a1", "Robert");
            System.out.println("--------------------------------");
            myController.addUser(2, "a2", "Martin");
            System.out.println("--------------------------------");

            myController.printAll();
            System.out.println("--------------------------------");
            myController.deleteAll();
            System.out.println("--------------------------------");
            myController.printAll();

            myDatabase.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}