package com.example.findmypet2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomelessPets extends AppCompatActivity {

    ListView listViewClinics;
    DatabaseReference dataBaseClinics;
    DatabaseReference databaseVolunteers;
    DatabaseReference databaseFosters;
    List<Clinic> clinicList;
    List<Volunteer> volunteerList;
    List<AdoptionCenters> adoptionCentersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_pets);
        dataBaseClinics = FirebaseDatabase.getInstance().getReference("clinics");
        databaseVolunteers = FirebaseDatabase.getInstance().getReference("volunteers");
        databaseFosters = FirebaseDatabase.getInstance().getReference("adoption centers");

        listViewClinics = findViewById(R.id.listViewClinics);
        clinicList = new ArrayList<Clinic>();
        volunteerList = new ArrayList<Volunteer>();
        adoptionCentersList = new ArrayList<AdoptionCenters>();


    }

    public void clickedOnClinics(View view) {
        dataBaseClinics.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clinicList.clear();
                for(DataSnapshot clinicSnapshot : snapshot.getChildren()) {
                    Clinic clinic = clinicSnapshot.getValue(Clinic.class);

                    clinicList.add(clinic);
                    ClinicsList adapter = new ClinicsList(HomelessPets.this, clinicList);
                    listViewClinics.setAdapter(adapter);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void clickedOnVolunteers(View view) {
        databaseVolunteers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                volunteerList.clear();
                for(DataSnapshot volunteerSnapshot : snapshot.getChildren()) {
                    Volunteer volunteer = volunteerSnapshot.getValue(Volunteer.class);

                    volunteerList.add(volunteer);
                    VolunteerList adapter = new VolunteerList(HomelessPets.this, volunteerList);
                    listViewClinics.setAdapter(adapter);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void clickedOnFosters(View view) {
       databaseFosters.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adoptionCentersList.clear();
                for(DataSnapshot clinicSnapshot : snapshot.getChildren()) {
                    AdoptionCenters adoptionCenters = clinicSnapshot.getValue(AdoptionCenters.class);

                    adoptionCentersList.add(adoptionCenters);
                    FostersList adapter = new FostersList(HomelessPets.this, adoptionCentersList);
                    listViewClinics.setAdapter(adapter);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}