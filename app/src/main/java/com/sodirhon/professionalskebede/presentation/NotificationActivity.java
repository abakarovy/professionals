package com.sodirhon.professionalskebede.presentation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sodirhon.professionalskebede.R;

public class NotificationActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance) {

        return inflater.inflate(R.layout.notif_activity, container, false);
    }
}
