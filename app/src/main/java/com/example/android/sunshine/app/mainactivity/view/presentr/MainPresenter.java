package com.example.android.sunshine.app.mainactivity.view.presentr;


import android.content.Context;
import android.view.ViewGroup;

import com.example.android.sunshine.app.mainactivity.view.MainActivityMVP;
import com.example.android.sunshine.app.mainactivity.view.recycler.WeatherViewHolder;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by vutka bilai on 1/9/17.
 * mail : la4508@gmail.com
 */

public class MainPresenter implements MainActivityMVP.providedPresenterOps , MainActivityMVP.RequiredPresenterOPS {

    // View reference. We use as a WeakReference
    // because the Activity could be destroyed at any time
    // and we don't want to create a memory leak
    private WeakReference<MainActivityMVP.RequiredViewOps> mView;


    //model reference
    private MainActivityMVP.ProvidedModelOps mModel;


    public MainPresenter(MainActivityMVP.RequiredViewOps mView) {
        this.mView = new WeakReference<MainActivityMVP.RequiredViewOps>(mView);
    }





    @Override
    public Context getAppContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }


    /**
     * Called by View every time it is destroyed.
     *
     * @param isChangingConfigurations true: is changing configuration
     *                                 and will be recreated
     */
    @Override
    public void onDestroy(boolean isChangingConfigurations) {

        //view should be null every time onDEstroy is called
        mView =  null ;

        //inform model about the event
        mModel.onDestroy(isChangingConfigurations);

        //activity destroyed
        if(!isChangingConfigurations){
            mModel = null ;
        }
    }

    @Override
    public List<String> getDummyWeather() {
        return mModel.createDummyWeather();
    }

    @Override
    public WeatherViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
