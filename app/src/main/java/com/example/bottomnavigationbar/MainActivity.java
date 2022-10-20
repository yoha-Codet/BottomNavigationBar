package com.example.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.bottom_navigation);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) chipNavigationBar.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        //here you can change the first selected fragment to be displayed when the app starts

        chipNavigationBar.setItemEnabled(R.id.nav_extra,true);
        chipNavigationBar.setItemSelected(R.id.nav_extra, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentExtra()).commit();
        bottomMenu();
    }


    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.nav_home:
                        fragment = new FragmentHome();
                        break;
                    case R.id.nav_extra:
                        fragment = new FragmentExtra();
                        break;
                    case R.id.nav_about:
                        fragment = new FragmentAbout();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,
                                fragment).commit();
            }
        });
    }
}
