package com.sodirhon.professionalskebede.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.sodirhon.professionalskebede.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                //TODO: CHECK FOR AUTH HERE could also remove the delay ig nigger
                Intent mainActivity = new Intent(SplashScreen.this, OnboardingActivity.class);
                startActivity(mainActivity);
                finish();

                Log.i("Maga", "App launched");
            }
        }, 2200);
    }

}
