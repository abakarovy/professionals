package com.sodirhon.professionalskebede.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.sodirhon.professionalskebede.R;

public class OnboardingActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    OnboardingAdapter adapter;
    Button pageButton;

    LinearLayout indicatorLayout;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.onboarding);

        pageButton = findViewById(R.id.onboardingPageButton);

        adapter = new OnboardingAdapter(this);
        viewPager = findViewById(R.id.onboardingViewPager);
        viewPager.setAdapter(adapter);

        indicatorLayout = findViewById(R.id.linearLayout);
        updateIndicators(0);

        pageButton.setOnClickListener(v -> {
            flipPage();
            if (viewPager.getCurrentItem() > 0) {
                pageButton.setText("Далее");
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                updateIndicators(position);
            }
        });
    }

    private void flipPage() {
        int currFrag = viewPager.getCurrentItem();
        Log.i("SAD", String.valueOf(currFrag));
        if (currFrag < adapter.getItemCount() - 1) {
            viewPager.setCurrentItem(currFrag + 1);
        } else {
            Intent mainActivity = new Intent(this, Login.class);
            startActivity(mainActivity);
            finish();
        }
    }
    private void updateIndicators(int position) {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            View indicator = indicatorLayout.getChildAt(i);
            indicator.setBackgroundResource(R.drawable.page_indicator_deselected);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(60,6);
            params.setMargins(8, 0, 8, 0);
            indicator.setLayoutParams(params);
        }
        View selected = indicatorLayout.getChildAt(position);
        selected.setBackgroundResource(R.drawable.page_indicator_selected);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(90,10);
        params.setMargins(8, 0, 8, 0);
        selected.setLayoutParams(params);
    }
}
