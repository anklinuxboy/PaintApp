package com.example.ankitsharma.paint;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by ankitsharma on 9/19/16.
 */
public class PaintFragment extends Fragment implements View.OnClickListener {
    public PaintFragment() {}

    @BindView(R.id.delete_icon)
    ImageButton deleteButton;
    @BindView(R.id.brush_icon)
    ImageButton brushButton;
    @BindView(R.id.pallete_icon)
    ImageButton palleteButton;
    @BindView(R.id.custom_paint_view)
    PaintView paintView;

    int RED = Color.RED;
    int GREEN = Color.GREEN;
    int YELLOW = Color.YELLOW;
    int MAGENTA = Color.MAGENTA;
    int BLUE = Color.BLUE;
    int BLACK = Color.BLACK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        deleteButton.setOnClickListener(this);
        brushButton.setOnClickListener(this);
        palleteButton.setOnClickListener(this);

        return view;
    }

    @Nullable
    @OnClick({R.id.delete_icon, R.id.brush_icon, R.id.pallete_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete_icon:
                Timber.d("Delete Button Pressed");
                paintView.onClear();
                break;
            case R.id.brush_icon:
                Timber.d("Brush Button Pressed");
                break;
            case R.id.pallete_icon:
                Timber.d("Pallete Button Pressed");
                break;
            default:
                return;
        }
    }
}
