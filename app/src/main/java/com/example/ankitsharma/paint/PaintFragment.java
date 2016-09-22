package com.example.ankitsharma.paint;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.WindowDecorActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by ankitsharma on 9/19/16.
 */
public class PaintFragment extends Fragment implements View.OnClickListener {
    public PaintFragment() {}

    @BindViews({R.id.pallete_icon, R.id.brush_icon, R.id.delete_icon})
    List<ImageButton> mainButtons;

    @BindView(R.id.custom_paint_view)
    PaintView paintView;

    @BindViews({R.id.black_button, R.id.blue_button, R.id.red_button, R.id.green_button,
            R.id.magenta_button, R.id.yellow_button})
    List<ImageButton> palleteButtons;

    @BindViews({R.id.brush_24, R.id.brush_18, R.id.brush_12, R.id.brush_6, R.id.eraser_icon})
    List<ImageButton> brushButtons;

    private boolean palleteVisible = false;
    private boolean brushVisible = false;
    private final String PALLETE_KEY = "palleteKey";
    private final String BRUSH_KEY = "brushKey";

    private SimplePresenter presenter;

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
        presenter = new SimplePresenter(paintView);

        setClickListeners(mainButtons);
        setClickListeners(palleteButtons);
        setClickListeners(brushButtons);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(PALLETE_KEY, palleteVisible);
        savedInstanceState.putBoolean(BRUSH_KEY, brushVisible);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            palleteVisible = savedInstanceState.getBoolean(PALLETE_KEY);
            brushVisible = savedInstanceState.getBoolean(BRUSH_KEY);
            setRotateVisibility();
        }
    }

    private void setRotateVisibility() {
        if (palleteVisible) {
            changeVisibility(palleteButtons, View.VISIBLE);
        }
        if (brushVisible) {
            changeVisibility(brushButtons, View.VISIBLE);
        }
    }

    @OnClick({R.id.delete_icon, R.id.brush_icon, R.id.pallete_icon, R.id.black_button,
     R.id.blue_button, R.id.red_button, R.id.yellow_button, R.id.green_button, R.id.eraser_icon,
     R.id.magenta_button, R.id.brush_12, R.id.brush_24, R.id.brush_18, R.id.brush_6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete_icon:
                Timber.d("Delete Button Pressed");
                presenter.clearCanvas();
                break;
            case R.id.brush_icon:
                //Log.d("sss", "sdfsfd");
                Timber.d("Brush Button Pressed");
                setBrushWidthVisible();
                break;
            case R.id.pallete_icon:
                Timber.d("Pallete Button Pressed");
                setPalleteVisible();
                break;
            case R.id.black_button:
                presenter.changeBrushColor(BLACK);
                break;
            case R.id.blue_button:
                presenter.changeBrushColor(BLUE);
                break;
            case R.id.red_button:
                presenter.changeBrushColor(RED);
                break;
            case R.id.green_button:
                presenter.changeBrushColor(GREEN);
                break;
            case R.id.magenta_button:
                presenter.changeBrushColor(MAGENTA);
                break;
            case R.id.yellow_button:
                presenter.changeBrushColor(YELLOW);
                break;
            case R.id.brush_24:
                presenter.changeBrushWidth(XLARGE_BRUSH_WIDTH);
                break;
            case R.id.brush_18:
                presenter.changeBrushWidth(LARGE_BRUSH_WIDTH);
                break;
            case R.id.brush_12:
                presenter.changeBrushWidth(MEDIUM_BRUSH_WIDTH);
                break;
            case R.id.brush_6:
                presenter.changeBrushWidth(SMALL_BRUSH_WIDTH);
                break;
            case R.id.eraser_icon:
                presenter.eraseCanvas();
                break;
            default:
                break;
        }
    }

    private void setBrushWidthVisible() {
        if (!brushVisible) {
            changeVisibility(brushButtons, View.VISIBLE);
            brushVisible = true;
        } else {
            changeVisibility(brushButtons, View.GONE);
            brushVisible = false;
        }
    }

    private void setPalleteVisible() {
        if (!palleteVisible) {
            changeVisibility(palleteButtons, View.VISIBLE);
            palleteVisible = true;
        } else {
            changeVisibility(palleteButtons, View.GONE);
            palleteVisible = false;
        }
    }

    private void changeVisibility(List<ImageButton> buttons, int visibilitySetting) {
        for (ImageButton button : buttons) {
            button.setVisibility(visibilitySetting);
        }
    }

    private void setClickListeners(List<ImageButton> buttons) {
        for (ImageButton button : buttons) {
            button.setOnClickListener(this);
        }
    }
}
