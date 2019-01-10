package com.hr.circularprogress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CircularProgressBar extends ProgressBar {

    public CircularProgressBar(Context context) {
        this(context, null);
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.cpbStyle);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            setIndeterminateDrawable(new CircularProgressDrawable.Builder(context, true).build());
            return;
        }

        Resources res = context.getResources();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressBar, defStyle, 0);

        final int defaultColor = res.getColor(R.color.cpb_default_color);
        final int color = a.getColor(R.styleable.CircularProgressBar_cpb_color, res.getColor(R.color.cpb_default_color));
        final float strokeWidth = a.getDimension(R.styleable.CircularProgressBar_cpb_stroke_width, res.getDimension(R.dimen.cpb_default_stroke_width));
        final float sweepSpeed = a.getFloat(R.styleable.CircularProgressBar_cpb_sweep_speed, Float.parseFloat(res.getString(R.string.cpb_default_sweep_speed)));
        final float rotationSpeed = a.getFloat(R.styleable.CircularProgressBar_cpb_rotation_speed, Float.parseFloat(res.getString(R.string.cpb_default_rotation_speed)));
        final int colorsId = a.getResourceId(R.styleable.CircularProgressBar_cpb_colors, 0);
        final int minSweepAngle = a.getInteger(R.styleable.CircularProgressBar_cpb_min_sweep_angle, res.getInteger(R.integer.cpb_default_min_sweep_angle));
        final int maxSweepAngle = a.getInteger(R.styleable.CircularProgressBar_cpb_max_sweep_angle, res.getInteger(R.integer.cpb_default_max_sweep_angle));
        final int gradientStart = a.getColor(R.styleable.CircularProgressBar_cpb_gradient_start, defaultColor);
        final int gradientEnd = a.getColor(R.styleable.CircularProgressBar_cpb_gradient_end, defaultColor);
        final int gradientHeight = getHeight() == 0 ? (int) context.getResources().getDimension(R.dimen.cpb_default_gradient_height) : getHeight();
        a.recycle();

        int[] colors = null;
        //colors
        if (colorsId != 0) {
            colors = res.getIntArray(colorsId);
        }

        Drawable indeterminateDrawable;
        CircularProgressDrawable.Builder drawableBuilder = new CircularProgressDrawable.Builder(context)
                .sweepSpeed(sweepSpeed)
                .rotationSpeed(rotationSpeed)
                .strokeWidth(strokeWidth)
                .minSweepAngle(minSweepAngle)
                .maxSweepAngle(maxSweepAngle);

        if (gradientStart != defaultColor) {
            drawableBuilder
                    .gradientStart(gradientStart)
                    .gradientEnd(gradientEnd)
                    .gradientHeight(gradientHeight);
        }

        if (colors != null && colors.length > 0)
            drawableBuilder.colors(colors);
        else
            drawableBuilder.color(color);

        indeterminateDrawable = drawableBuilder.build();
        setIndeterminateDrawable(indeterminateDrawable);
    }
}