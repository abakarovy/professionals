package com.sodirhon.professionalskebede.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.gridlayout.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.sodirhon.professionalskebede.R;
import com.sodirhon.professionalskebede.data.ExampleData;
import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import java.util.List;

public class PopularActivity extends AppCompatActivity {

    List<ShoeItem> shoeItemList;
    ProgressBar progressBar;
    GridLayout gridLayout;
    ImageButton backButton;

    @Override
    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.popular_activity);

        gridLayout = findViewById(R.id.itemsGrid);
        progressBar = findViewById(R.id.popular_progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                shoeItemList = ExampleData.getShoes();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < shoeItemList.size(); i++) {
                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                            params.rowSpec = GridLayout.spec(i / 2);
                            params.columnSpec = GridLayout.spec(i % 2);
                            params.setGravity(Gravity.CENTER);

                            gridLayout.addView(new CardItemComponent(PopularActivity.this, shoeItemList.get(i)), params);
                        }

                        progressBar.setVisibility(View.GONE);
                        gridLayout.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();


        ImageButton favBtn = findViewById(R.id.favorites_cartBtn);
        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(PopularActivity.this, MainActivity.class);
                mainActivityIntent.putExtra("selectedPage", R.id.favorites);
                startActivity(mainActivityIntent);
            }
        });

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(PopularActivity.this, MainActivity.class);
                mainActivityIntent.putExtra("selectedPage", R.id.home);
                startActivity(mainActivityIntent);
            }
        });
    }
}
