package com.example.ankitsharma.paint;

import android.app.Application;
import android.graphics.Bitmap;


import timber.log.Timber;

/**
 * Created by ankitsharma on 9/22/16.
 */

public class ModelPaintApplication extends Application {

    public Bitmap drawing;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
