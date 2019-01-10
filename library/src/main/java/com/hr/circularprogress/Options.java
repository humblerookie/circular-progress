package com.hr.circularprogress;

import android.view.animation.Interpolator;

class Options {

    //params
    final Interpolator angleInterpolator;
    final Interpolator sweepInterpolator;
    final float borderWidth;
    final int[] colors;
    final float sweepSpeed;
    final float rotationSpeed;
    final int minSweepAngle;
    final int maxSweepAngle;
    final int gradientStartColor;
    final int gradientEndColor;
    final int gradientHeight;
    final boolean shouldUseGradient;
    @CircularProgressDrawable.Style
    final int style;

    Options(Interpolator angleInterpolator,
            Interpolator sweepInterpolator,
            float borderWidth,
            int[] colors,
            float sweepSpeed,
            float rotationSpeed,
            int minSweepAngle,
            int maxSweepAngle,
            @CircularProgressDrawable.Style int style,
            int gradientStartColor,
            int gradientEndColor,
            int gradientHeight,
            boolean shouldUseGradient
    ) {
        this.angleInterpolator = angleInterpolator;
        this.sweepInterpolator = sweepInterpolator;
        this.borderWidth = borderWidth;
        this.colors = colors;
        this.sweepSpeed = sweepSpeed;
        this.rotationSpeed = rotationSpeed;
        this.minSweepAngle = minSweepAngle;
        this.maxSweepAngle = maxSweepAngle;
        this.style = style;
        this.gradientEndColor = gradientEndColor;
        this.gradientStartColor = gradientStartColor;
        this.gradientHeight = gradientHeight;
        this.shouldUseGradient = shouldUseGradient;

    }


}