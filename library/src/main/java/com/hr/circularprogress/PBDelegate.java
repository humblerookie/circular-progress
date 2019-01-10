package com.hr.circularprogress;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.UiThread;

interface PBDelegate {

    @UiThread
    void draw(Canvas canvas, Paint paint);

    @UiThread
    void start();

    @UiThread
    void stop();

    @UiThread
    void progressiveStop(CircularProgressDrawable.OnEndListener listener);
}