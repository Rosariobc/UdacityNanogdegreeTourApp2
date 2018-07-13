package com.example.android.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NorthFragment extends Fragment {

    public NorthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.zone_list, container, false);

        // This method creates the North arrayList

        final ArrayList<Zone> zones = new ArrayList<Zone>();

        //zone.add("north")
        zones.add(new Zone(R.string.park_name, R.string.park_description, R.string.park_address, R.drawable.north_park));
        zones.add(new Zone(R.string.colombus_name, R.string.colombus_description, R.string.colombus_address, R.drawable.north_colombus));
        zones.add(new Zone(R.string.zoo_name, R.string.zoo_description, R.string.zoo_address, R.drawable.north_zoo));

        ZoneAdapter adapter = new ZoneAdapter(getActivity(), zones, R.color.category_north);

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
