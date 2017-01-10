package com.example.android.sunshine.app.mainactivity.view;


import android.content.Context;
import android.view.ViewGroup;

import com.example.android.sunshine.app.mainactivity.view.recycler.WeatherViewHolder;

import java.util.List;

/**
 * Created by vutka bilai on 1/8/17.
 * mail : la4508@gmail.com
 */

public interface MainActivityMVP {

    /**
     * Required View methods available to Presenter.
     * A passive layer, responsible to show data
     * and receive user interactions
     * (presenter -> view )
     */

    interface RequiredViewOps{

        Context getAppContext();
        Context getActivityContext();
        MainActivity.PlaceholderFragment getFragment();
    }


    /**
     * Operations offered to View to communicate with Presenter.
     * Process user interaction, sends data requests to Model, etc.
     * (view -> presenter)
     */

    interface providedPresenterOps{

        void onDestroy(boolean isChangingConfigurations);
        List<String> getDummyWeather();
        WeatherViewHolder createViewHolder(ViewGroup parent , int viewType);
        void onBindViewHolder(WeatherViewHolder holder, int position);
        int getItemCount();
    }


    /**
     * required Presenter operation available
     * to model (model -> presenter)
     */

    interface RequiredPresenterOPS{
        Context getAppContext();
        Context getActivityContext();
    }


    /**
     * Operations offered to model to communicate with presenter
     * Handles all data business logic
     * (presenter -> model )
     */

    interface ProvidedModelOps{

        void onDestroy(boolean isChangingConfigurations);
        List<String> createDummyWeather();

    }
}
