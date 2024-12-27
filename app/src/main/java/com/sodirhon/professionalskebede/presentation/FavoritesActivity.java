package com.sodirhon.professionalskebede.presentation;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.sodirhon.professionalskebede.R;
import com.sodirhon.professionalskebede.data.ExampleData;
import com.sodirhon.professionalskebede.data.samples.ShoeItem;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FavoritesActivity extends Fragment {

    GridLayout gridLayout;
    ProgressBar progressBar;

    List<ShoeItem> favoriteShoes;

    MainActivity mainActivity;

    public FavoritesActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance) {


        return inflater.inflate(R.layout.fav_activity, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedStateInstance) {

        gridLayout = view.findViewById(R.id.itemsGrid);
        progressBar = view.findViewById(R.id.favorites_progressBar3);


        new Thread(new Runnable() {
            @Override
            public void run() {
                favoriteShoes = ExampleData.getFavShoes();

                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (favoriteShoes == null) return;
                        for (int i = 0; i < favoriteShoes.size(); i++) {
                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                            params.rowSpec = androidx.gridlayout.widget.GridLayout.spec(i / 2);
                            params.columnSpec = androidx.gridlayout.widget.GridLayout.spec(i % 2);
                            params.setGravity(Gravity.CENTER);

                            gridLayout.addView(new CardItemComponent(mainActivity, favoriteShoes.get(i)), params);
                        }

                        progressBar.setVisibility(View.GONE);
                        gridLayout.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

    }
}
