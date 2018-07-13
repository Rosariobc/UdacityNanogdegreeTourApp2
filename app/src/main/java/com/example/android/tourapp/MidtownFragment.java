package com.example.android.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MidtownFragment extends Fragment {

    public MidtownFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.zone_list, container, false);

        // This method creates the Midtown arrayList

        final ArrayList<Zone> zones = new ArrayList<Zone>();

        //zone.add("midtown")
        zones.add(new Zone(R.string.times_name, R.string.times_description, R.string.times_address, R.drawable.midtown_times));
        zones.add(new Zone(R.string.gcs_name, R.string.gcs_description, R.string.gcs_address, R.drawable.midtown_gcs));
        zones.add(new Zone(R.string.carnegie_name, R.string.carnegie_description, R.string.carnegie_address, R.drawable.midtown_carnegie));
        zones.add(new Zone(R.string.san_patricks_name, R.string.san_patricks_description, R.string.san_patricks_address, R.drawable.midtown_san_patricks));
        zones.add(new Zone(R.string.hudson_name, R.string.hudson_description, R.string.hudson_address, R.drawable.midtown_hudson));
        zones.add(new Zone(R.string.bryant_name, R.string.bryant_description, R.string.bryant_address, R.drawable.midtown_bryant));
        zones.add(new Zone(R.string.library_name, R.string.library_description, R.string.library_address, R.drawable.midtown_library));
        zones.add(new Zone(R.string.rockefeller_name, R.string.rockefeller_description, R.string.rockefeller_address, R.drawable.midtown_rockefeller));
        zones.add(new Zone(R.string.radio_name, R.string.radio_description, R.string.radio_address, R.drawable.midtown_radio));

        ZoneAdapter adapter = new ZoneAdapter(getActivity(), zones, R.color.category_midtown);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ZoneAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Zone} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link Zone} object at the given position the user clicked on
                Zone zone = zones.get(position);

                //TODO for future app
                // Intent sending to the address

                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri currentAddress = Uri.parse("geo:0,0?q=" + zone.getPlaceAddress());

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent addressIntent = new Intent(Intent.ACTION_VIEW, currentAddress);

                // Make the Intent explicit by setting the Google Maps package
                addressIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(addressIntent);
            }
        });
        return rootView;
    }
}
