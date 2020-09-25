package com.example.findmypet2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VeterinaryMedicalCare extends AppCompatActivity {
    ListView listView;
    DatabaseReference dataBaseClinics;
    DatabaseReference databaseVolunteers;
    DatabaseReference databaseAmbulances;
    List<Clinic> clinicList;
    List<Volunteer> volunteerList;
    List<Ambulance> ambulanceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary_medical_care);
        dataBaseClinics = FirebaseDatabase.getInstance().getReference("clinics");
        databaseVolunteers = FirebaseDatabase.getInstance().getReference("volunteers");
        databaseAmbulances = FirebaseDatabase.getInstance().getReference("ambulance");

        listView = findViewById(R.id.list_view);
        clinicList = new ArrayList<>();
        volunteerList = new ArrayList<>();
        ambulanceList = new ArrayList<>();

    }

    public void showClinics(View view) {
        dataBaseClinics.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clinicList.clear();
                for (DataSnapshot clinicSnapshot : snapshot.getChildren()) {
                    Clinic clinic = clinicSnapshot.getValue(Clinic.class);

                    clinicList.add(clinic);
                    ClinicsList adapter = new ClinicsList(VeterinaryMedicalCare.this, clinicList);
                    listView.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void showVolunteers(View view) {
        databaseVolunteers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                volunteerList.clear();
                for(DataSnapshot volunteerSnapshot : snapshot.getChildren()) {
                    Volunteer volunteer = volunteerSnapshot.getValue(Volunteer.class);

                    volunteerList.add(volunteer);
                    VolunteerList adapter = new VolunteerList(VeterinaryMedicalCare.this, volunteerList);
                    listView.setAdapter(adapter);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void clickedOnAmbulance(View view) {
        databaseAmbulances.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ambulanceList.clear();
                for (DataSnapshot clinicSnapshot : snapshot.getChildren()) {
                    Ambulance ambulance = clinicSnapshot.getValue(Ambulance.class);

                    ambulanceList.add(ambulance);
                    AmbulanceList adapter = new AmbulanceList(VeterinaryMedicalCare.this, ambulanceList);
                    listView.setAdapter(adapter);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}