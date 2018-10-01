package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.v("EarthquakeLoader","onStartLoading");
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if(mUrl==null){
            return null;
        }
        Log.v("EarthquakeLoader","loadInBackground + "+mUrl);

        ArrayList<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}