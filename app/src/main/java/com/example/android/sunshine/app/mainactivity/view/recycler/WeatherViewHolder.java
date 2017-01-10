package com.example.android.sunshine.app.mainactivity.view.recycler;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.sunshine.app.R;

/**
 * Created by vutka bilai on 1/10/17.
 * mail : la4508@gmail.com
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    public TextView weahterTv;

    public WeatherViewHolder(View itemView) {
        super(itemView);

        weahterTv = (TextView) itemView.findViewById(R.id.list_item_forecast_textview);

    }
}
