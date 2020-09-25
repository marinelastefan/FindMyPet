package com.example.findmypet2;

public class AdoptionCenters {
    String id;
    String name;
    String address;
    String contact;

    public  AdoptionCenters() {

    }

    public AdoptionCenters(String id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}
