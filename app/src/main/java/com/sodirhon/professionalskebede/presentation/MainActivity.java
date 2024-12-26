package com.sodirhon.professionalskebede.presentation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.sodirhon.professionalskebede.R;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private int fragmentId;
    private int homeOption;
    private int favOption;
    private int notifOption;
    private int profileOption;

    int selectedPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView bottomBar = findViewById(R.id.mainBottomBar);

        homeOption = R.id.home;
        favOption = R.id.favorites;
        notifOption = R.id.notifications;
        profileOption = R.id.profile;

        fragmentId = R.id.mainFragment;

        selectedPage = getIntent().getIntExtra("selectedPage", R.id.home);

        bottomBar.setOnItemSelectedListener(this);
        bottomBar.setSelectedItemId(selectedPage);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int selectedItemID = item.getItemId();

        if (selectedItemID == homeOption) {
            HomeActivity homeActivity = new HomeActivity(this);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragmentId, homeActivity)
                    .commit();
            return true;
        } else if (selectedItemID == favOption) {
            FavoritesActivity favActivity = new FavoritesActivity();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragmentId, favActivity)
                    .commit();
            return true;
        } else if (selectedItemID == notifOption) {
            NotificationActivity notifActivity = new NotificationActivity();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragmentId, notifActivity)
                    .commit();
            return true;
        } else if (selectedItemID == profileOption) {
            ProfileActivity profileActivity = new ProfileActivity();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragmentId, profileActivity)
                    .commit();
            return true;
        }

        return false;
    }

}
