package com.example.ankitsharma.paint;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ankitsharma on 9/19/16.
 */
public class PaintFragment extends Fragment {
    public PaintFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        PaintView pv = (PaintView) getView().findViewById(R.id.custom_paint_view);
    }


}
