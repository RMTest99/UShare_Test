package com.example.ushare_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ushare_test.Fragments.ChatsFragment;
import com.example.ushare_test.Fragments.ProfileFragment;
import com.example.ushare_test.Fragments.SearchFragment;
import com.example.ushare_test.Fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;

    private ChatsFragment chatsFragment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        chatsFragment = new ChatsFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();

        mainFrame = findViewById(R.id.main_frame);
        mainNav = findViewById(R.id.main_nav);

        setFragment(chatsFragment);

        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_chats :
                        setFragment(chatsFragment);
                        return true;

                    case R.id.nav_search :
                        setFragment(searchFragment);
                        return true;

                    case R.id.nav_profile :
                        setFragment(profileFragment);
                        return true;

                    case R.id.nav_settings :
                        setFragment(settingsFragment);
                        return true;

                        default:
                            return false;

                }



            }
        });
    }

    public void inviteClicked(View view) {
        Intent intent = new Intent(MainActivity.this, InviteActivity.class);
        startActivity(intent);
    }

    public void premiumClicked (View view) {
        Intent intent = new Intent(MainActivity.this, PremiumActivity.class);
        startActivity(intent);
    }

    public void helpClicked (View view) {
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    public void privacyClicked (View view) {
        Intent intent = new Intent(MainActivity.this, PrivacyActivity.class);
        startActivity(intent);
    }

    public void accountClicked (View view) {
        Intent intent = new Intent(MainActivity.this, AccountActivity.class);
        startActivity(intent);
    }

    public void logOutClicked (View view) {
        firebaseAuth.signOut();

        Toast.makeText(MainActivity.this, "User logged out", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void editClicked (View view) {
        Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
        startActivity(intent);
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
