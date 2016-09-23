package com.example.ankitsharma.paint;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;


import java.util.HashMap;

import timber.log.Timber;

/**
 * Created by ankitsharma on 9/22/16.
 */

public class PaintApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
