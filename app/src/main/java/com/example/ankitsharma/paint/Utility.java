package com.example.ankitsharma.paint;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ankitsharma on 9/20/16.
 */

public class Utility {

    private static final String BRUSH_COLOR_PREFERENCE = "colorPreference";
    private static final String BRUSH_WIDTH_PREFERENCE = "widthPreference";

    public static void saveBrushColorPref(Context context, int color) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        pref.edit().putInt(BRUSH_COLOR_PREFERENCE, color).apply();
    }

    public static void saveBrushWidthPref(Context context, int width) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        pref.edit().putInt(BRUSH_WIDTH_PREFERENCE, width).apply();
    }

    public static int getBrushColorPref(Context context) {
        int DEFAULT_PAINT_COLOR = context.getResources().getColor(R.color.brushColor);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt(BRUSH_COLOR_PREFERENCE, DEFAULT_PAINT_COLOR);
    }

    public static int getBrushWidthPref(Context context) {
        int DEFAULT_BRUSH_WIDTH = 15;
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt(BRUSH_WIDTH_PREFERENCE, DEFAULT_BRUSH_WIDTH);
    }
}
