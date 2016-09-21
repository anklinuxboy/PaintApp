package com.example.ankitsharma.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import timber.log.Timber;

/**
 * Created by ankitsharma on 9/19/16.
 */
public class PaintView extends View {

    private Path drawPath;
    private Paint drawPaint,
            canvasPaint;

    private Canvas canvas;
    private Bitmap bitmap;


    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        drawPath = new Path();
        drawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int color = Utility.getBrushColorPref(getContext());
        drawPaint.setColor(color);
        drawPaint.setAntiAlias(true);
        int width = Utility.getBrushWidthPref(getContext());
        drawPaint.setStrokeWidth(width);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawBitmap(bitmap, 0, 0, canvasPaint);
            canvas.drawPath(drawPath, drawPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                canvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void onClear() {
        Timber.d("Inside onClear PaintView");
        canvas.drawColor(getResources().getColor(R.color.paintColor));
        drawPath = new Path();
        invalidate();
    }

    public void setBrushColor(int color) {
        drawPath = new Path();
        drawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        drawPaint.setColor(color);
        Utility.saveBrushColorPref(getContext(), color);
        drawPaint.setAntiAlias(true);
        int width = Utility.getBrushWidthPref(getContext());
        drawPaint.setStrokeWidth(width);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setBrushWidth(int width) {
        drawPath = new Path();
        drawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int color = Utility.getBrushColorPref(getContext());
        drawPaint.setColor(color);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(width);
        Utility.saveBrushWidthPref(getContext(), width);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }


}
