package com.example.android.sunshine.app.mainactivity.view.presentr;


import android.content.Context;

import com.example.android.sunshine.app.mainactivity.view.MainActivityMVP;

import java.util.List;

/**
 * Created by vutka bilai on 1/9/17.
 * mail : la4508@gmail.com
 */

public class MainPresentr implements MainActivityMVP.providedPresenterOps , MainActivityMVP.RequiredPresenterOPS {




    @Override
    public Context getAppContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void onDestroy(boolean isChangingConfigurations) {

    }

    @Override
    public List<String> getDummyWeather() {
        return null;
    }
}
