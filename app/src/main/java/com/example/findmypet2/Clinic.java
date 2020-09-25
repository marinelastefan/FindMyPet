package com.example.findmypet2;

public class Clinic {

    String clinicId;
    String clinicName;
    String clinicAddress;
    String clinicContact;

    public Clinic() {

    }

    public Clinic(String clinicId, String clinicName, String clinicAddress, String clinicContact) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.clinicContact = clinicContact;
    }

    public String getClinicId() {
        return clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public String getClinicContact() {
        return clinicContact;
    }
}
