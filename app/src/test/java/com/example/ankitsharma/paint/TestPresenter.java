package com.example.ankitsharma.paint;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by ankitsharma on 9/21/16.
 */

public class TestPresenter {
    @Mock
    PaintViewCallback paintViewCallback;

    private SimplePresenter presenter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        presenter = new SimplePresenter(paintViewCallback);
    }

    @Test
    public void testChangeBrushColor() {
        presenter.changeBrushColor(Color.RED);
        verify(paintViewCallback).setBrushColor(Color.RED);
    }

    @Test
    public void testChangeBrushWidth() {
        int BRUSH_WIDTH = 20;
        presenter.changeBrushWidth(BRUSH_WIDTH);
        verify(paintViewCallback).setBrushWidth(BRUSH_WIDTH);
    }

    @Test
    public void testOnClear() {
        presenter.clearCanvas();
        verify(paintViewCallback).onClear();
    }

    @Test
    public void testEraseCanvas() {
        presenter.eraseCanvas();
        verify(paintViewCallback).setEraser();
    }
}
