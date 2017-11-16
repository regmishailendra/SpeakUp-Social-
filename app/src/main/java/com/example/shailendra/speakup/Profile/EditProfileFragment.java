package com.example.shailendra.speakup.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by shailendra on 11/16/17.
 */

public class EditProfileFragment extends Fragment {

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        imageView = view.findViewById(R.id.profilePhoto);
        initImageLoader();
        setProfileImage();


        return view;

    }

    public void initImageLoader() {

        UniversalImageLoader imageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(imageLoader.getConfig());


    }


    private void setProfileImage() {

        UniversalImageLoader.setImage("http://tctechcrunch2011.files.wordpress.com/2012/09/mark.jpeg",

                imageView, null, "");


    }


}
