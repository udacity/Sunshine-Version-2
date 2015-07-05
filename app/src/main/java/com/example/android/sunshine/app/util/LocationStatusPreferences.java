package com.example.android.sunshine.app.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;

import static com.example.android.sunshine.app.sync.SunshineSyncAdapter.LOCATION_STATUS_UNKNOWN;
import static com.example.android.sunshine.app.sync.SunshineSyncAdapter.LocationStatus;

/**
 * Created by sergey on 05.07.15.
 */
public class LocationStatusPreferences {
    public static final String KEY = "LocationStatusPreferences";
    public static final String STATUS = "Status";


    /* Name section */
    public static void setStatus(Context context, @LocationStatus int status) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putInt(STATUS, status);
        editor.commit();


    }

    public static void resetStatus(Context context) {
        setStatus(context, SunshineSyncAdapter.LOCATION_STATUS_UNKNOWN);


    }

    @SuppressWarnings("ResourceType")
    static public
    @LocationStatus
    int getLocationStatus(Context context) {
        SharedPreferences prefs = getInstance(context);
        return prefs.getInt(STATUS, LOCATION_STATUS_UNKNOWN);
    }

    public static SharedPreferences getInstance(Context context) {
        if (context != null) {
            return context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        } else {
            return null;
        }
    }
}
