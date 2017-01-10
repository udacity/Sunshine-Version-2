/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.app.mainactivity.view;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.sunshine.app.R;
import com.example.android.sunshine.app.common.StateMaintainer;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.RequiredViewOps {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    public PlaceholderFragment mainFragment ;


    // Responsible to maintain the object's integrity
    // during configurations change
    private final StateMaintainer mStateMaintainer
            = new StateMaintainer(MainActivity.class.getName() , getFragmentManager());

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            mainFragment = new PlaceholderFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container , mainFragment)
                    .commit();
        }
        
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public PlaceholderFragment getFragment() {

        return mainFragment;
    }


    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment{

        public PlaceholderFragment() {

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main , container , false);
            return rootView;
        }
    }
}
