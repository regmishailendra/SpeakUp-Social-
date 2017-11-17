package com.example.shailendra.speakup.Share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shailendra.speakup.R;

/**
 * Created by shailendra on 11/15/17.
 */

public class PhotoFragment extends Fragment {

    private static final int CAMERA_REQUEST_CODE=501;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
 View view=inflater.inflate(R.layout.fragment_photo,container,false);


        Button launchCamera=view.findViewById(R.id.launchCamera);
        launchCamera.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((ShareActivity)getActivity()).getCurrentTabNumber()==1)
                        {

                            //check for permission and ask if not ..will do it later as it is for debug now

                            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,CAMERA_REQUEST_CODE);




                        }
                    }
                }
        );





 return view;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

      if (requestCode==CAMERA_REQUEST_CODE && resultCode== Activity.RESULT_OK){






      }



    }
}
