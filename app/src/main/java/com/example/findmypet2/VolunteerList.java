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

public class VolunteerList extends ArrayAdapter<Volunteer> {
    private Activity context;
    private List<Volunteer> volunteerList;

    public VolunteerList(Activity context, List<Volunteer> volunteerList) {
        super(context, R.layout.list_layout_volunteers, volunteerList);
        this.context = context;
        this.volunteerList = volunteerList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_volunteers, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewVolunteerName);
        TextView textViewContact = listViewItem.findViewById(R.id.textViewVolunteerContact);

        Volunteer volunteer = volunteerList.get(position);
        textViewName.setText(volunteer.getName());
        textViewContact.setText(volunteer.getContact());

        return listViewItem;

    }
}
