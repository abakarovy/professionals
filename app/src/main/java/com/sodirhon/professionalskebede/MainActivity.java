package com.sodirhon.professionalskebede;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private int fragmentId;
    private int homeOption;
    private int favOption;
    private int notifOption;
    private int profileOption;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        BottomNavigationView bottomBar = findViewById(R.id.bottomNavigationView);

        homeOption = R.id.home;
        favOption = R.id.favorites;
        notifOption = R.id.notifications;
        profileOption = R.id.profile;

        bottomBar.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int selectedItemID = item.getItemId();

        if (selectedItemID == homeOption) {
            HomeActivity homeActivity = new HomeActivity();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFragment, homeActivity)
                    .commit();
        } else if (selectedItemID == favOption) {

        } else if (selectedItemID == notifOption) {

        } else if (selectedItemID == profileOption) {
            
        }

        return false;
    }

}
