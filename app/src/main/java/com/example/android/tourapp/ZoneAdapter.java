package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ZoneAdapter extends ArrayAdapter<Zone> {

    // Resource Id for the background color for the list of zones
    private int aColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * @param context        The current context. Used to inflate the layout file.
     * @param zones A List of words objects to display in a list
     * @param colorResourceId for the background color
     */
    ZoneAdapter(FragmentActivity context, ArrayList<Zone> zones, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        super(context, 0, zones);
        aColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Zone} object located at this position in the list
        Zone currentZone = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the version name from the current place for the zone object and
        // set this text on the name TextView
        placeNameTextView.setText(currentZone.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeDescriptionTextView = (TextView) listItemView.findViewById(R.id.place_description);
        // Get the version name from the current description for the zone object and
        // set this text on the name TextView
        placeDescriptionTextView.setText(currentZone.getPlaceDescription());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeAddressTextView = (TextView) listItemView.findViewById(R.id.place_address);
        // Get the version name from the current address for the zone object and
        // set this text on the name TextView
        placeAddressTextView.setText(currentZone.getPlaceAddress());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.place_picture);

        if(currentZone.hasImage()) {
            // Get the image resource ID from the current Zone object and
            // set the image to iconView
            iconView.setImageResource(currentZone.getImageResourceId());
            // As the view is Recycled we want to be sure that if the previous View used a Gone state,
            // we are having it visible again
            iconView.setVisibility(View.VISIBLE);
        } else {
            // We will take the image out of the View, otherwise there will be a blank space
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list view
        View textContainer = listItemView.findViewById(R.id.list_container);

        // Find the color that the resourceId maps to
        int color = ContextCompat.getColor(getContext(), aColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
