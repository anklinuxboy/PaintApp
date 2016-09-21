package com.example.ankitsharma.paint;

/**
 * Created by ankitsharma on 9/21/16.
 */

public class SimplePresenter {

    public void changeBrushColor(PaintView pv, int color) {
        pv.setBrushColor(color);
    }

    public void changeBrushWidth(PaintView pv, int width) {
        pv.setBrushWidth(width);
    }

    public void clearCanvas(PaintView pv) {
        pv.onClear();
    }

    public void eraseCanvas(PaintView pv) {
        pv.setEraser();
    }
}
