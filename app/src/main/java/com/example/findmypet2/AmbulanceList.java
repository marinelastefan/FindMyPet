package com.example.findmypet2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AmbulanceList extends ArrayAdapter<Ambulance> {
    private Activity context;
    private List<Ambulance> ambulanceList;

    public AmbulanceList(Activity context, List<Ambulance> ambulanceList) {
        super(context, R.layout.list_layout_clinics, ambulanceList);
        this.context = context;
        this.ambulanceList = ambulanceList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_volunteers, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewVolunteerName);
        TextView textViewContact = listViewItem.findViewById(R.id.textViewVolunteerContact);

        Ambulance ambulance = ambulanceList.get(position);
        textViewName.setText(ambulance.getName());
        textViewContact.setText(ambulance.getContact());

        return listViewItem;

    }
}
