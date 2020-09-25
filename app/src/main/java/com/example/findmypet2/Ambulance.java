package com.example.findmypet2;

public class Ambulance {
    String id;
    String name;
    String contact;

    public Ambulance() {

    }

    public Ambulance(String id, String name, String contact) {
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
