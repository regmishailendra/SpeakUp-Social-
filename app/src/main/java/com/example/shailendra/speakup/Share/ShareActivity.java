package com.example.shailendra.speakup.Share;

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

public class ShareActivity extends AppCompatActivity{

    private ViewPager viewPager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Log.i("meroinsta", "onCreate: share started");


        // setUpBottomNavigation();
        setViewPager();

    }


    private void setUpBottomNavigation() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(ShareActivity.this,bottomNavigationView);


    }


    public int getCurrentTabNumber(){

        return viewPager.getCurrentItem();


    }





    void setViewPager(){

        SectionsPagerAdapter adapter=new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GallaryFragment());
        adapter.addFragment(new PhotoFragment());

         viewPager=findViewById(R.id.container);
         viewPager.setAdapter(adapter);
        TabLayout tabLayout=findViewById(R.id.tabsBottom);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Gallary");
        tabLayout.getTabAt(1).setText("Photo");








    }





}
