package com.pelukron.diego.testrecyclerview.application;

import android.app.Application;

import com.pelukron.diego.testrecyclerview.adapter.MyAdapter;

/**
 * Created by diego on 6/21/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyAdapter.init(getApplicationContext());
    }
}
