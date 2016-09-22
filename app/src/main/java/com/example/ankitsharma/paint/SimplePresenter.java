package com.example.ankitsharma.paint;

/**
 * Created by ankitsharma on 9/21/16.
 */

public class SimplePresenter {

    private final PaintViewCallback paintViewCallback;

    public SimplePresenter(PaintViewCallback paintViewCallback) {
        this.paintViewCallback = paintViewCallback;
    }

    public void changeBrushColor(int color) {
        paintViewCallback.setBrushColor(color);
    }

    public void changeBrushWidth(int width) { paintViewCallback.setBrushWidth(width); }

    public void clearCanvas() {
        paintViewCallback.onClear();
    }

    public void eraseCanvas() {
        paintViewCallback.setEraser();
    }
}
