package com.example.ankitsharma.paint;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
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

    // Pallete Buttons
    @BindView(R.id.black_button)
    ImageButton blackButton;
    @BindView(R.id.blue_button)
    ImageButton blueButton;
    @BindView(R.id.red_button)
    ImageButton redButton;
    @BindView(R.id.green_button)
    ImageButton greenButton;
    @BindView(R.id.yellow_button)
    ImageButton yellowButton;
    @BindView(R.id.magenta_button)
    ImageButton magentaButton;

    // Brush Buttons
    @BindView(R.id.brush_24)
    ImageButton brush24;
    @BindView(R.id.brush_18)
    ImageButton brush18;
    @BindView(R.id.brush_12)
    ImageButton brush12;
    @BindView(R.id.brush_6)
    ImageButton brush6;

    private boolean palleteVisible = false;
    private boolean brushVisible = false;

    int RED = Color.RED;
    int GREEN = Color.GREEN;
    int YELLOW = Color.YELLOW;
    int MAGENTA = Color.MAGENTA;
    int BLUE = Color.BLUE;
    int BLACK = Color.BLACK;

    int XLARGE_BRUSH_WIDTH = 20;
    int LARGE_BRUSH_WIDTH = 14;
    int MEDIUM_BRUSH_WIDTH = 10;
    int SMALL_BRUSH_WIDTH = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        deleteButton.setOnClickListener(this);
        brushButton.setOnClickListener(this);
        palleteButton.setOnClickListener(this);
        // Set up listeners on pallete
        blackButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        magentaButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        // listeners for brush width
        brush24.setOnClickListener(this);
        brush18.setOnClickListener(this);
        brush12.setOnClickListener(this);
        brush6.setOnClickListener(this);

        return view;
    }

    @OnClick({R.id.delete_icon, R.id.brush_icon, R.id.pallete_icon, R.id.black_button,
     R.id.blue_button, R.id.red_button, R.id.yellow_button, R.id.green_button,
     R.id.magenta_button, R.id.brush_12, R.id.brush_24, R.id.brush_18, R.id.brush_6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete_icon:
                Timber.d("Delete Button Pressed");
                paintView.onClear();
                break;
            case R.id.brush_icon:
                Timber.d("Brush Button Pressed");
                setBrushWidthVisible();
                break;
            case R.id.pallete_icon:
                Timber.d("Pallete Button Pressed");
                setPalleteVisible();
                break;
            case R.id.black_button:
                paintView.setBrushColor(BLACK);
                break;
            case R.id.blue_button:
                paintView.setBrushColor(BLUE);
                break;
            case R.id.red_button:
                paintView.setBrushColor(RED);
                break;
            case R.id.green_button:
                paintView.setBrushColor(GREEN);
                break;
            case R.id.magenta_button:
                paintView.setBrushColor(MAGENTA);
                break;
            case R.id.yellow_button:
                paintView.setBrushColor(YELLOW);
                break;
            case R.id.brush_24:
                paintView.setBrushWidth(XLARGE_BRUSH_WIDTH);
                break;
            case R.id.brush_18:
                paintView.setBrushWidth(LARGE_BRUSH_WIDTH);
                break;
            case R.id.brush_12:
                paintView.setBrushWidth(MEDIUM_BRUSH_WIDTH);
                break;
            case R.id.brush_6:
                paintView.setBrushWidth(SMALL_BRUSH_WIDTH);
                break;
            default:
                break;
        }
    }

    private void setBrushWidthVisible() {
        if (!brushVisible) {
            brush24.setVisibility(View.VISIBLE);
            brush18.setVisibility(View.VISIBLE);
            brush12.setVisibility(View.VISIBLE);
            brush6.setVisibility(View.VISIBLE);
            brushVisible = true;
        } else {
            brush24.setVisibility(View.GONE);
            brush18.setVisibility(View.GONE);
            brush12.setVisibility(View.GONE);
            brush6.setVisibility(View.GONE);
            brushVisible = false;
        }
    }

    private void setPalleteVisible() {
        if (!palleteVisible) {
            blackButton.setVisibility(View.VISIBLE);
            redButton.setVisibility(View.VISIBLE);
            blueButton.setVisibility(View.VISIBLE);
            greenButton.setVisibility(View.VISIBLE);
            magentaButton.setVisibility(View.VISIBLE);
            yellowButton.setVisibility(View.VISIBLE);
            palleteVisible = true;
        } else {
            blackButton.setVisibility(View.GONE);
            redButton.setVisibility(View.GONE);
            blueButton.setVisibility(View.GONE);
            greenButton.setVisibility(View.GONE);
            magentaButton.setVisibility(View.GONE);
            yellowButton.setVisibility(View.GONE);
            palleteVisible = false;
        }
    }
}
