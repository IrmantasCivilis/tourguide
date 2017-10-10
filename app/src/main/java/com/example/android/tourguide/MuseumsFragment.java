package com.example.android.tourguide;

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
 * Created by Irmantas Čivilis on 2017.06.01.
 * <p>
 * A simple {@link Fragment} subclass.
 */

public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location(getString(R.string.name_palace),
                R.drawable.palace,
                getString(R.string.description_palace),
                getString(R.string.coordinates_palace)));

        locations.add(new Location(getString(R.string.name_national_museum),
                R.drawable.national_museum,
                getString(R.string.description_national_museum),
                getString(R.string.coordinates_national_museum)));

        locations.add(new Location(getString(R.string.name_old_arsenal),
                R.drawable.old_arsenal,
                getString(R.string.description_old_arsenal),
                getString(R.string.coordinates_old_arsenal)));

        locations.add(new Location(getString(R.string.name_picture_gallery),
                R.drawable.picture_gallery,
                getString(R.string.description_picture_gallery),
                getString(R.string.coordinates_picture_gallery)));

        locations.add(new Location(getString(R.string.name_energy_and_technology),
                R.drawable.energy_and_technology,
                getString(R.string.description_energy_and_technology),
                getString(R.string.coordinates_energy_and_technology)));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Locations}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called locations_list, which is declared in the
        // locations_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.locations_list);

        // Make the {@link ListView} use the (@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // Set a click listener on the ListView item and on click show location in the Google map.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link Location) object at the given position the user clicked on
                Location currentLocation = locations.get(position);

                // Get the coordinates of the clicked object.
                Uri locationUri = Uri.parse(currentLocation.getCoordinates());

                // Create an implicit intent
                Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);

                // Start a new activity
                startActivity(intent);
            }
        });

        return rootView;
    }
}
