package com.example.physiofit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the navigation drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                Fragment selectedFragment = null;
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    selectedFragment = new HomeFragment();
                } else if (id == R.id.navigation_profile) {
                    selectedFragment = new ProfileFragment();
                } else if (id == R.id.navigation_settings) {
                    selectedFragment = new SettingsFragment();
                }
                openFragment(selectedFragment);

                return false;
            }
        });

        // Set up the bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    selectedFragment = new HomeFragment();
                }else if (id == R.id.navigation_chat) {
                    selectedFragment = new ChatListFragment();
                }else if (id == R.id.navigation_profile) {
                    selectedFragment = new ProfileFragment();
                } else if (id == R.id.navigation_analytics) {
                    selectedFragment = new AnalyticsFragment();

                }
                if (selectedFragment != null) {
                    openFragment(selectedFragment);
                    return true; // Indicate the item was handled
                }
                return false;
            }
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle toolbar menu item clicks here
        int id = item.getItemId();
        if (id == R.id.navigation_analytics) {
            // Handle settings action
            openFragment(new AnalyticsFragment());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}