package com.example.shailendra.speakup.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;
import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.SectionsPagerAdapter;

/**
 * Created by shailendra on 11/14/17.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("meroinsta", "onCreate: home started");
        setUpBottomNavigation();

        setUpViewPager();

    }

    private void setUpViewPager() {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new CameraFragment());
        sectionsPagerAdapter.addFragment(new HomeFragment());
        sectionsPagerAdapter.addFragment(new MessagesFragment());
        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);




    }


    private void setUpBottomNavigation() {


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(HomeActivity.this, bottomNavigationView);

    }


}
