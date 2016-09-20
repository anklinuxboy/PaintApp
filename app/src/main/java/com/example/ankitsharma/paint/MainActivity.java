package com.example.ankitsharma.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        startFragment();
    }

    private void startFragment() {
        getFragmentManager().beginTransaction()
                .add(R.id.paint_fragment, new PaintFragment())
                .commit();
    }
}
