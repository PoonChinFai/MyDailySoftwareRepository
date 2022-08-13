package com.sleeptask;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.WindowManager;

public class WindowManage {
    WindowManager window;
    WindowManager.LayoutParams windowlayout;

    public void WindowManage(Context context) {
        window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowlayout = new WindowManager.LayoutParams();
        windowlayout.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        windowlayout.format = PixelFormat.RGBA_8888;
        windowlayout.width = 500;
        windowlayout.height = 100;
        windowlayout.x = 300;
        windowlayout.y = 300;

    }
}
