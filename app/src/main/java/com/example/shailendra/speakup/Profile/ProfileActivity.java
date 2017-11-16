package com.example.shailendra.speakup.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;
import com.example.shailendra.speakup.R;

public class ProfileActivity extends AppCompatActivity{
private ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.i("meroinsta", "onCreate: profile started");
        mProgressBar=findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);


    setUpBottomNavigation();
    setUpToolBar();



    }
  private void setUpToolBar(){
      Toolbar toolbar=findViewById(R.id.profileToolBar);



      setSupportActionBar(toolbar);

      ImageView profileIV=findViewById(R.id.profileMenu);
      profileIV.setOnClickListener(
              new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(ProfileActivity.this,AccountSettingsActivity.class);
                      startActivity(intent);
                  }
              }
      );

       toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {
               Log.i("meroinsta", "onMenuItemClick: ");

               switch (item.getItemId()){

                   case R.id.profileMenu:
                       Log.i("meroinsta", "onMenuItemClick: going to profile page");
                       break;




               }

               return false;
           }
       });



  }

    private void setUpBottomNavigation() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(ProfileActivity.this,bottomNavigationView);


    }







}
