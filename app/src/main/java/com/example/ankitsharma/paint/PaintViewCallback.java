package com.example.ankitsharma.paint;

/**
 * Created by ankitsharma on 9/22/16.
 */

public interface PaintViewCallback {
    void setBrushColor(int color);
    void setBrushWidth(int width);
    void onClear();
    void setEraser();
}
