package com.project.myapps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String username = intent.getStringExtra("name");


        bottomNavigation = findViewById(R.id.menu_navbottom);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, HomeFragment.newInstance(username))
                .commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.nav_home) {
                    selectedFragment = HomeFragment.newInstance(username);
                } else if (item.getItemId() == R.id.nav_status) {
                    selectedFragment = new StatusFragment();
                } else if (item.getItemId()== R.id.nav_profil) {
                    selectedFragment = ProfileFragment.newInstance(username);
                }

                if (selectedFragment != null) {

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_content, selectedFragment)
                            .commit();
                    return true;
                }
                return false;


            }
        });
    }
}