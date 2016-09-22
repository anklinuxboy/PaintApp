package com.example.ankitsharma.paint;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by ankitsharma on 9/22/16.
 */

public class ApplicationForTimber extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
