package com.wakeupdev.movemate;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.wakeupdev.movemate.databinding.ActivityCalculateBinding;

import java.util.Locale;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }

        ActivityCalculateBinding binding = ActivityCalculateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageParcel.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_slide_up));
        binding.movemate.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_slide_up));
        binding.btnHome.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_slide_up));
        binding.estimate.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_slide_up));
        binding.message.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_slide_up));

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1460);

        valueAnimator.setStartDelay(0);
        valueAnimator.setDuration(2000);

        valueAnimator.addUpdateListener(animation -> {
            float animatedValue = (float) animation.getAnimatedValue();
            String formattedText = String.format(Locale.getDefault(), "$%.2f USD", animatedValue);
            binding.status.setText(formattedText);
        });

        valueAnimator.start();


        binding.btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(CalculateActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
            finish();
        });
    }

}