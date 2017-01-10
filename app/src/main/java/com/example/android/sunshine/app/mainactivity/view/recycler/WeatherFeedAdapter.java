package com.example.android.sunshine.app.mainactivity.view.recycler;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.sunshine.app.mainactivity.view.MainActivityMVP;

/**
 * Created by vutka bilai on 1/10/17.
 * mail : la4508@gmail.com
 */

public class WeatherFeedAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private MainActivityMVP.providedPresenterOps mPresenter;

    public WeatherFeedAdapter(MainActivityMVP.providedPresenterOps mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mPresenter.createViewHolder(parent , viewType);
    }



    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        mPresenter.onBindViewHolder(holder , position);
    }


    @Override
    public int getItemCount() {
        return mPresenter.getItemCount();
    }
}
