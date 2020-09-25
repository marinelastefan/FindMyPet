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

public class ClinicsList extends ArrayAdapter<Clinic> {
    private Activity context;
    private List<Clinic> clinicList;

    public ClinicsList(Activity context, List<Clinic> clinicList) {
        super(context, R.layout.list_layout_clinics, clinicList);
        this.context = context;
        this.clinicList = clinicList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_clinics, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewContact = listViewItem.findViewById(R.id.textViewContact);

        Clinic clinic = clinicList.get(position);
        textViewName.setText(clinic.getClinicName());
        textViewAddress.setText(clinic.getClinicAddress());
        textViewContact.setText(clinic.getClinicContact());

        return listViewItem;

    }
}
