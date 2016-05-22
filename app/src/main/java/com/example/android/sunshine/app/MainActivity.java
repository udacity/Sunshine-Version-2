package com.example.android.sunshine.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String[] data = {
                                       "Mon 6/23 - Sunny - 31/17",
                                        "Tue 6/24 - Foggy - 21/8",
                                        "Wed 6/25 - Cloudy - 22/17",
                                        "Thurs 6/26 - Rainy - 18/11",
                                        "Fri 6/27 - Foggy - 21/10",
                                        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                                        "Sun 6/29 - Sunny - 20/7"
                                       };

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));
            Context context = getActivity();
            ArrayAdapter<String> forecastListViewAdapter = new ArrayAdapter<String>(context,R.layout.list_item_forecast,
            R.id.list_item_forecast_textview
            ,weekForecast);
            ListView forcastListView = (ListView) rootView.findViewById(R.id.listview_forecast);
            forcastListView.setAdapter(forecastListViewAdapter);
    return rootView;
}
}
}
