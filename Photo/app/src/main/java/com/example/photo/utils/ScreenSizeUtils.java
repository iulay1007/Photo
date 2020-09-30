package com.example.photo.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Window;
import android.view.WindowManager;

public class ScreenSizeUtils {
    public static Point getScreenSize(Context context){

        Point point=new Point();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
        return point;
    }
}
