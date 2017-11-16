package com.example.shailendra.speakup.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;
import com.example.shailendra.speakup.R;

/**
 * Created by shailendra on 11/14/17.
 */

public class SearchActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.i("meroinsta", "onCreate: search started");
    //setUpBottomNavigation();

    }


    private void setUpBottomNavigation() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(SearchActivity.this,bottomNavigationView);


    }



}
