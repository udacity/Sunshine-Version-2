package com.example.android.sunshine.app.common;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by vutka bilai on 1/8/17.
 * mail : la4508@gmail.com
 * <p>
 * this class Retains and maintain object's state between configuration changes
 * <p>
 * in Activitys and Fragments
 */

public class StateMaintainer {

    protected final String TAG = getClass().getSimpleName();


    private final String mStateMaintainerTag;
    private final WeakReference<FragmentManager> mFragmentManager;
    private StateMngFragment mStatemaintainerFrag;
    private boolean isRecreating;


    public StateMaintainer(String mStateMaintainerTag, WeakReference<FragmentManager> mFragmentManager) {
        this.mStateMaintainerTag = mStateMaintainerTag;
        this.mFragmentManager = mFragmentManager;
    }


    /**
     * Creates the Fragment responsible to maintain the objects.
     *
     * @return true: fragment just created
     */
    public boolean firstTimeIn() {

        try {

            mStatemaintainerFrag = (StateMngFragment) mFragmentManager.get().findFragmentByTag(mStateMaintainerTag);

            if(mStatemaintainerFrag == null){
                Log.d(TAG, "no saved fragment found to retainted " + mStatemaintainerFrag);
                mStatemaintainerFrag = new StateMngFragment();
                mFragmentManager.get().beginTransaction().add(mStatemaintainerFrag , mStateMaintainerTag).commit();
                isRecreating = false ;

                return  true ;
            }else {
                Log.d(TAG, "saved fragment found , retaining fragment " + mStatemaintainerFrag);
                isRecreating = true;

                return false;
            }
        }catch (NullPointerException e){
            Log.e(TAG , " error "+e.getMessage());

            return false;
        }
    }


    /**
     * Return <strong>true</strong> it the current Activity was recreated at least one time
     * @return  If the Activity was recreated
     */
    public boolean wasRecreated() { return isRecreating; }


    /**
     * Insert the object to be preserved
     * @param key
     * @param obj
     */
    public void put(String key , Object obj){
        mStatemaintainerFrag.put(key , obj);
    }


    /**
     * Recovers the object saved
     * @param key   Object's TAG
     * @param <T>   Object type
     * @return      Object saved
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key)  {
        return mStatemaintainerFrag.get(key);

    }

    /**
     * Checks the existence of a given object
     * @param key   Key to verification
     * @return      true: Object exists
     */
    public boolean hasKey(String key) {
        return mStatemaintainerFrag.get(key) != null;
    }


    /**
     * insert the object to be preserved
     * @param obj
     */
    public void put(Object obj){
        put(obj.getClass().getName() , obj);
    }

    /**
     * Fragment resposible to preserve objects.
     * Instantiated only once. Uses a hashmap to save objs
     */

    public static class StateMngFragment extends Fragment {

        private HashMap<String, Object> mData = new HashMap<>();


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setRetainInstance(true);
        }


        /**
         * inset objects in the hashmap
         *
         * @param key
         * @param object
         */

        public void put(String key, Object object) {
            mData.put(key, object);
        }


        /**
         * insert object in the hash map
         *
         * @param object
         */
        public void put(Object object) {
            put(object.getClass().getName(), object);
        }


        /**
         * recovers saved object against the given key
         *
         * @param key
         * @param <T>
         * @return
         */
        @SuppressWarnings("unchecked")
        public <T> T get(String key) {
            return (T) mData.get(key);
        }
    }
}
