package org.example.sk.controller;


import org.example.sk.model.MyUser;
import org.example.sk.service.MyServiceImp;

import java.sql.Connection;
import java.util.ArrayList;

public class MyController {
    MyServiceImp service;

    public MyController(Connection connection) {
        this.service = new MyServiceImp(connection);
    }

    public void addUser(int id, String guid, String name){
        service.addUser(id,guid,name);
    }

    public void printAll(){
        ArrayList<MyUser> users = service.getAll();
        if(users == null || users.isEmpty()){
            System.out.println("No users found!");
        }else{
            users.forEach(System.out::println);
        }
    }

    public void deleteAll(){
        service.deleteAll();
    }
}
