package com.example.findmypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PetDescription extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    RequestQueue mRequestQueue;
    private String URL = "https://fcm.googleapis.com/fcm/send";
    Uri imageUri;
    private static final int PICK_IMAGE = 100;
    ImageView imageView;
    Spinner spinner;
    Spinner spinner2;
    Button button;
    RadioGroup group1;
    EditText editTextName;
    EditText editText;
    Button send;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_description);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.time,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);

        button = findViewById(R.id.loadPicture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        send = findViewById(R.id.send_notif);
        mRequestQueue = Volley.newRequestQueue(this);

        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });

        FirebaseMessaging.getInstance().subscribeToTopic("lostpet");

        // Location
       /* FusedLocationProviderClient fusedLocationClient;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //onRequestPermission
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                });*/

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void sendNotification() {

        group1 = findViewById(R.id.group1);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);

            }
        });
        String pet = radioButton.getText().toString();
        String name = editTextName.getText().toString();
        String time = spinner2.getSelectedItem().toString();
        String color = spinner.getSelectedItem().toString();
        String phoneNumber = editText.getText().toString();



        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("to", "/topics/" + "lostpet");
            JSONObject notificationObj = new JSONObject();
            notificationObj.put("title", "Lost Pet");
            String body_text = "A" + pet +  "named" + name + "color" + color + "was lost" + time + "ago.Please call " + phoneNumber;

            notificationObj.put("body", body_text);
            mainObj.put("notification", notificationObj);

            JsonObjectRequest request= new JsonObjectRequest(Request.Method.POST, URL, mainObj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //on success

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //on error

                        }
                    }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> header = new HashMap<>();
                    header.put("content-type", "application/json");
                    header.put("authorization", "key=AAAA_VwntTc:APA91bHo7ymrf2IbzPk8rgoc1pYmhUQBIMJjIJC5z6m42BoP66UsyvHF6rfL6rcuigfnpQ0Fr4BAvYGOuTahkHbETBgGDf-qNlOAr6PhtkziaIEPkbES3N9lkXxtFwb6t2sTYm6g25PY");
                    return header;
                }
            };
            mRequestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
