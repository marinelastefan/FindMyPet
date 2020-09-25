package com.example.findmypet2;

public class Volunteer {
    String id;
    String name;
    String contact;
    public Volunteer() {

    }

    public Volunteer(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
