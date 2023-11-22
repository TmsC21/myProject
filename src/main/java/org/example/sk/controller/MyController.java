package org.example.sk.controller;


import org.example.sk.service.MyServiceImp;

public class MyController {
    MyServiceImp service;

    public MyController() {
        this.service = new MyServiceImp();
    }

    public void addUser(int id, String guid, String name){
        try {
            service.addUser(id,guid,name);
        }catch (Exception e){
            return;
        }
    }

    public void printAll(){
        try {
            service.printAll();
        }catch (Exception e){
            return;
        }
    }

    public void deleteAll(){
        try {
            service.deleteAll();
        }catch (Exception e){
            return;
        }
    }
}
