package com.example.ankitsharma.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFragment();
    }

    private void startFragment() {
        getFragmentManager().beginTransaction()
                .add(R.id.paint_fragment, new PaintFragment())
                .commit();
    }
}
