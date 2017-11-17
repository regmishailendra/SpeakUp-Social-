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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;
import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.GridImageAdapter;
import com.example.shailendra.speakup.Utils.UniversalImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity{
private ProgressBar mProgressBar;
ImageView profilePhoto;
    private int NUM_GRID_COLUMNS=3;
    TextView editProfile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.i("meroinsta", "onCreate: profile started");

setupActivityWidgets();

    setUpBottomNavigation();
    setUpToolBar();
    setProfileImage();
        tempGridSetup();


        editProfile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(ProfileActivity.this,AccountSettingsActivity.class);
                        intent.putExtra("calling","profile");
                        startActivity(intent);

                    }
                }
        );


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


    private void setProfileImage(){

        UniversalImageLoader.setImage(
                "http://tctechcrunch2011.files.wordpress.com/2012/09/mark.jpeg",
                profilePhoto,null,""
                );

    }

private void setupActivityWidgets(){

    mProgressBar=findViewById(R.id.profileProgressBar);
    mProgressBar.setVisibility(View.GONE);
    profilePhoto=findViewById(R.id.profilePhoto);
    editProfile=(TextView)findViewById(R.id.tveditprofile);




}

private void tempGridSetup(){

    ArrayList<String> imageUrls=new ArrayList<>();
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/07/Bernard-Tomic.jpg");
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/05/Karishma-Tanna.jpg");

    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/05/Tamannaah-Bhatia.jpg");
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/03/Ak-Networks-53.jpg");

    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/04/Yuvraj-Singh.jpg");
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/05/Osman-Khalid-Butt.jpg");
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/08/8-Month-Old-First-Week.jpg");
    imageUrls.add("http://www.anyfeed.in/wp-content/uploads/2016/06/12-3.jpg ");


    setupImageGrid(imageUrls);

}


public void setupImageGrid(ArrayList<String> imageUrls){
    GridView gridView=findViewById(R.id.gridView);

    int gridWidth=getResources().getDisplayMetrics().widthPixels;
    int imageWidth=gridWidth/NUM_GRID_COLUMNS;  //imp at samesizing image
    gridView.setColumnWidth(imageWidth);   //setting exact width we need according to device





    GridImageAdapter gridImageAdapter= new GridImageAdapter(ProfileActivity.this,R.layout.layout_grid_imageview
    ,imageUrls,"");
    gridView.setAdapter(gridImageAdapter);







}


}
