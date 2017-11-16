package com.example.shailendra.speakup.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shailendra on 11/16/17.
 */

public class SecionsStatePagerAdapter extends FragmentStatePagerAdapter{

    List<Fragment> mFragmentList=new ArrayList<>();
    HashMap<Fragment,Integer> mFragments=new HashMap<>();
    HashMap<String,Integer> mFragmentNumbers=new HashMap<>();
    HashMap<Integer,String> mFragmentNames=new HashMap<>();




    public SecionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment,String fragmentName){
        mFragmentList.add(fragment);
        mFragments.put(fragment,mFragmentList.size()-1);
        mFragmentNumbers.put(fragmentName,mFragmentList.size()-1);
        mFragmentNames.put(mFragmentList.size()-1,fragmentName);
    }
    public Integer getFragmentNumber(String fragmentName){
        if(mFragmentNumbers.containsKey(fragmentName)){


            return mFragmentNumbers.get(fragmentName);}
            else {return null;}
        }



    public Integer getFragmentNumber(Fragment fragment){
        if(mFragments.containsKey(fragment)){


            return mFragments.get(fragment);}
            else {return null;}
        }


            public String getFragmentName(Integer fragmentNumber){
        if(mFragmentNames.containsKey(fragmentNumber)){


            return mFragmentNames.get(fragmentNumber);}
            else {return null;}
        }





    }






