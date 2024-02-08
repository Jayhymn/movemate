package com.wakeupdev.movemate.animations;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public class WidthAnimation {

    public static void animateWidth(View view, int targetWidth, long duration) {
        int currentWidth = view.getWidth();

        ValueAnimator animator = ValueAnimator.ofInt(currentWidth, targetWidth);
        animator.setDuration(duration);

        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = animatedValue;
            view.setLayoutParams(layoutParams);
        });

        // Start the animation
        animator.start();
    }
}
