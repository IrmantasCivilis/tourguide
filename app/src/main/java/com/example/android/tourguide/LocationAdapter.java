package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Irmantas Čivilis on 2017.05.30.
 * <p>
 * {@link LocationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list based on
 * a data source, which is a list of {@link Location} objects.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * @param context   The current context. Used to inflate the layout file.
     * @param locations A list of Location objects to display in a list.
     */

    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the LocationName from the current Location object and set this text on the locationName TextView
        locationNameTextView.setText(currentLocation.getName());

        // Find the TextView in the list_item.xml layout with the ID location_description
        TextView locationDescriptionTextView = (TextView) listItemView.findViewById(R.id.location_description);
        // Get the description from the current Location object and set this text on the Location description TextView
        locationDescriptionTextView.setText(currentLocation.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID location image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_image);
        // Get the image resource ID from the current Location object and set the image to LocationImage
        imageView.setImageResource((currentLocation.getImageResourceId()));

        return listItemView;
    }
}
