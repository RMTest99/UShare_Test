package com.example.ushare_test.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ushare_test.InviteActivity;
import com.example.ushare_test.MainActivity;
import com.example.ushare_test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    public void inviteClicked (View view) {

    }

    public void premiumClicked (View view) {

    }

    public void helpClicked (View view) {

    }

    public void privacyClicked (View view) {

    }

    public void accountClicked (View view) {

    }

    public void logOutClicked (View view) {

    }

}
