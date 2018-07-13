package com.example.android.tourapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class DowntownFragment extends Fragment {

    public DowntownFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.zone_list, container, false);

        // This method creates the Downtown arrayList

        final ArrayList<Zone> zones = new ArrayList<Zone>();

        //zone.add("downtown")
        zones.add(new Zone(R.string.wtc_name, R.string.wtc_description, R.string.wtc_address, R.drawable.downtown_wtc));
        zones.add(new Zone(R.string.one_name, R.string.one_description, R.string.one_address, R.drawable.downtown_one));
        zones.add(new Zone(R.string.oculus_name, R.string.oculus_description, R.string.oculus_address, R.drawable.downtown_oculus));
        zones.add(new Zone(R.string.battery_name, R.string.battery_description, R.string.battery_address, R.drawable.downtown_battery));
        zones.add(new Zone(R.string.girl_name, R.string.girl_description, R.string.girl_address, R.drawable.downtown_girl));
        zones.add(new Zone(R.string.chelsea_name, R.string.chelsea_description, R.string.chelsea_address, R.drawable.downtown_chelsea));
        zones.add(new Zone(R.string.line_name, R.string.line_description, R.string.line_address, R.drawable.downtown_high_line));
        zones.add(new Zone(R.string.staten_name, R.string.staten_description, R.string.staten_address, R.drawable.downtown_staten));


        ZoneAdapter adapter = new ZoneAdapter(getActivity(), zones, R.color.category_downtown);

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
