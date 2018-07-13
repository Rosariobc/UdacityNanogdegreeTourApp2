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
public class EastFragment extends Fragment {

    public EastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.zone_list, container, false);

        // This method creates the East arrayList

        final ArrayList<Zone> zones = new ArrayList<Zone>();

        //zone.add("east")
        zones.add(new Zone(R.string.river_name, R.string.river_description, R.string.river_address, R.drawable.east_river));
        zones.add(new Zone(R.string.ferry_name, R.string.ferry_description, R.string.ferry_address, R.drawable.east_ferry));
        zones.add(new Zone(R.string.un_name, R.string.un_description, R.string.un_address, R.drawable.east_un));
        zones.add(new Zone(R.string.lic_name, R.string.lic_description, R.string.lic_address, R.drawable.east_lic));
        zones.add(new Zone(R.string.brooklyn_bridge_name, R.string.brooklyn_bridge_description, R.string.brooklyn_bridge_address, R.drawable.east_brooklyn_bridge));
        zones.add(new Zone(R.string.acquarium_name, R.string.acquarium_description, R.string.acquarium_address, R.drawable.east_acquarium));
        zones.add(new Zone(R.string.roosevelt_island_name, R.string.roosevelt_island_description, R.string.roosevelt_island_address, R.drawable.east_roosevelt_island));

        ZoneAdapter adapter = new ZoneAdapter(getActivity(), zones, R.color.category_east);

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
