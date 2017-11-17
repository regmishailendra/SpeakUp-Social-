package com.example.shailendra.speakup.Profile;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.shailendra.speakup.Helpers.BottomNavHelper;
import com.example.shailendra.speakup.Home.HomeActivity;
import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.SecionsStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by shailendra on 11/16/17.
 */

public class AccountSettingsActivity extends AppCompatActivity {

    private SecionsStatePagerAdapter adapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_account_settings);
      setupSettingsList();
      viewPager=findViewById(R.id.container);
      relativeLayout=findViewById(R.id.relLayout1);
      setupFragments();
        setUpBottomNavigation();


Intent intent=getIntent();
if(intent.hasExtra("calling")){
    setViewPager(adapter.getFragmentNumber(getString(R.string.edit_profile_fragment)));




}



      //setup back button

        ImageView backArrow=findViewById(R.id.backArrow);
        backArrow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );



    }


    private void setupSettingsList(){

        ListView listView=findViewById(R.id.listViewAccountSettings);
        ArrayList<String> options=new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter= new ArrayAdapter(AccountSettingsActivity.this,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        setViewPager(position);
                    }
                }
        );








    }
public void setupFragments(){
        adapter=new SecionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile_fragment));
        adapter.addFragment(new SignOutFragment(),getString(R.string.sign_out_fragment));


}

private void setViewPager(int fragmentNumber) {

    relativeLayout.setVisibility(View.GONE);
    viewPager.setAdapter(adapter);
    viewPager.setCurrentItem(fragmentNumber);


}


    private void setUpBottomNavigation() {


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        BottomNavHelper.removeShiftMode(bottomNavigationView);
        BottomNavHelper.enableNavigation(AccountSettingsActivity.this, bottomNavigationView);

    }



}

