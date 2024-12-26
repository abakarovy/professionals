package com.sodirhon.professionalskebede.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

import com.sodirhon.professionalskebede.R;

public class HomeActivity extends Fragment {

    MainActivity mainActivity;

    public HomeActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.home_activity, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedStateInstance) {
        Button popularBtn = view.findViewById(R.id.popularBtn);

        popularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popularActivity = new Intent(mainActivity, PopularActivity.class);
                startActivity(popularActivity);
            }
        });
    }
}
