package com.example.findmypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void clickedOnHomelessPetsButton(View view) {
        Intent i = new Intent(this, HomelessPets.class );
        startActivity(i);

    }

    public void clickedOnVeterinaryMedicalCare(View view) {
        Intent i2 = new Intent(this, VeterinaryMedicalCare.class);
        startActivity(i2);
    }

    public void clickedLostPetButton(View view) {
        Intent i3 = new Intent(this,PetDescription.class );
        startActivity(i3);
    }
}