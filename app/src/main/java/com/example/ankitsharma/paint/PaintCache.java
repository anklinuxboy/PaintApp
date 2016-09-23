package com.example.ankitsharma.paint;

import android.graphics.Bitmap;
import android.graphics.Path;

import java.util.List;

/**************************************
 * Created by ankitsharma on 9/23/16. *
 *        Work In Progress            *
 *************************************/

public class PaintCache {
    private List<Path> paths;
    private Bitmap bitmap;

    public List<Path> getPaths() {
        return paths;
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public void deletePaths() {
        paths.clear();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    private static final PaintCache cache = new PaintCache();
    public static PaintCache getInstance() { return cache; }
}
