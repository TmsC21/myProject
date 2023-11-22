package org.example.sk.service;

import org.example.sk.model.MyUser;

import java.util.ArrayList;

public interface MyService {

    void addUser(int id, String guid, String name);

    ArrayList<MyUser> getAll();

    void deleteAll();

}
