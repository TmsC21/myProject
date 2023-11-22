package org.example.sk.model;

public class MyUser {
    private int id;
    private String guid;
    private String name;

    public MyUser(int id, String guid, String name) {
        this.id = id;
        this.guid = guid;
        this.name = name;
    }

    public MyUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: "+id+" Guid: "+guid+" Name: "+name;
    }
}
