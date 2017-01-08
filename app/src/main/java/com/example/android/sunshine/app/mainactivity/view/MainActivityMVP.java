package com.example.android.sunshine.app.mainactivity.view;


import android.content.Context;

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
    }
}
