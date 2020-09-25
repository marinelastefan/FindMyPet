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

public class FostersList extends ArrayAdapter<AdoptionCenters> {
    private Activity context;
    private List<AdoptionCenters> adoptionCentersList;

    public FostersList(Activity context, List<AdoptionCenters> adoptionCentersList) {
        super(context, R.layout.list_layout_clinics, adoptionCentersList);
        this.context = context;
        this.adoptionCentersList = adoptionCentersList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_clinics, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewContact = listViewItem.findViewById(R.id.textViewContact);

        AdoptionCenters adoptionCenters = adoptionCentersList.get(position);
        textViewName.setText(adoptionCenters.getName());
        textViewAddress.setText(adoptionCenters.getAddress());
        textViewContact.setText(adoptionCenters.getContact());

        return listViewItem;

    }
}

