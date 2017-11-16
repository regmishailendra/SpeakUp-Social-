package com.example.shailendra.speakup;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;

public class MainActivity extends AppCompatActivity {
 public static final String TAG="meroinsta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageBottomNavigationAnimation();





    }

    private void manageBottomNavigationAnimation() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(MainActivity.this,bottomNavigationView);


    }





}
