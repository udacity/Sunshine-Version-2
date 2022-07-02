package com.example.android.sunshine.app.util;

import android.os.Build;

/**
 * Created by Администратор on 7/10/2015.
 */
public class VersionUtil {
    public static boolean isLaterHoneyComb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }
}
