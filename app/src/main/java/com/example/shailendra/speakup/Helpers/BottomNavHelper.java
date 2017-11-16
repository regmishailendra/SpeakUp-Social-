package com.example.shailendra.speakup.Helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.shailendra.speakup.Likes.LikesActivity;
import com.example.shailendra.speakup.Profile.ProfileActivity;
import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Home.HomeActivity;
import com.example.shailendra.speakup.Search.SearchActivity;
import com.example.shailendra.speakup.Share.ShareActivity;

import java.lang.reflect.Field;

/**
 * Created by shailendra on 11/14/17.
 */

public class BottomNavHelper {
   @SuppressLint("RestrictedApi")
   public static void removeShiftMode(BottomNavigationView view){

        BottomNavigationMenuView menuView= (BottomNavigationMenuView) view.getChildAt(0);

        try {
            Field shiftingMode=menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }




        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void enableNavigation(final Context context, BottomNavigationView view){
       view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){

                   case R.id.ic_house:
                       Intent intent1=new Intent(context, HomeActivity.class);
                       context.startActivity(intent1);

                       break;

                   case R.id.ic_search:
                       Intent intent2=new Intent(context, SearchActivity.class);
                       context.startActivity(intent2);

                       break;

                   case R.id.ic_circle:
                       Intent intent3=new Intent(context, ShareActivity.class);
                       context.startActivity(intent3);
                       break;

                   case R.id.ic_alert:
                       Intent intent4=new Intent(context, LikesActivity.class);
                       context.startActivity(intent4);
                       break;

                   case R.id.ic_android:
                       Intent intent5=new Intent(context, ProfileActivity.class);
                       context.startActivity(intent5);
                       break;






               }
return false;
           }
       });




    }




}
