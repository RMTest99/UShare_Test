package com.example.ushare_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResetFailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_fail);
    }

    public void logInClicked(View view) {
        Intent intent = new Intent(ResetFailActivity.this, ResetSuccessActivity.class);
        startActivity(intent);
        finish();
    }
}
