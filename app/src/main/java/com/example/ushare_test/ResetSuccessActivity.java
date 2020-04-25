package com.example.ushare_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResetSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_success);
    }

    public void logInClicked(View view) {
        Intent intent = new Intent(ResetSuccessActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
