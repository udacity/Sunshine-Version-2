package com.example.android.sunshine.app.mainactivity.view.model;


import com.example.android.sunshine.app.mainactivity.view.MainActivityMVP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vutka bilai on 1/9/17.
 * mail : la4508@gmail.com
 */

public class MainModel implements MainActivityMVP.ProvidedModelOps {


    private String[] days = {"Mon 6/23" , "Tue 6/24" , "Wed 6/25" , "Thurs 6/26" , "Fri  6/27" , "Sat 6/28" , "Sun 6/29"};
    private String[] moods = {"Sunny ", "foggy ", "cloud " , "Rainy ", "TRAPPED IN WEATHERSTATION " };
    private String[] temperaturs = {"31/17 ", "21/8 " , "22/17 " , "18/11 " , "21/10 " , "23/18 " , "20/7 "};


    //presenter reference
    private MainActivityMVP.RequiredPresenterOPS mPresenter;


    public MainModel(MainActivityMVP.RequiredPresenterOPS mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void onDestroy(boolean isChangingConfigurations) {
        if (!isChangingConfigurations) {
            mPresenter = null;

        }
    }

    @Override
    public List<String> createDummyWeather() {

        List<String> weathers = new ArrayList<>();
        String dummyWeatherFeed = "";

        int moodhigh = 4;
        int moodlow = 0;

        int temHigh = 6;
        int tempLow = 0;

        for (int i = 0 ; i<=days.length ; i++){
            Random r = new Random();
            int dummymood = r.nextInt(moodhigh - moodlow) + moodlow;
            int dummyTemp = r.nextInt(temHigh - tempLow)+tempLow;
            dummyWeatherFeed = days[i] + " - " + dummymood + " - " + dummyTemp;

            weathers.add(dummyWeatherFeed);
        }



        return weathers;
    }
}
