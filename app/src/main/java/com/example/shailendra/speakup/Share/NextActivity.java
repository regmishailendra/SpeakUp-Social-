package com.example.shailendra.speakup.Share;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.UniversalImageLoader;

/**
 * Created by shailendra on 11/17/17.
 */

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "NextActivity";

TextView share;
ImageView imageShare,backArow;
EditText description;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);




        share=findViewById(R.id.sharetextview);
        imageShare=findViewById(R.id.imageShare);
        backArow=findViewById(R.id.backArrow);
        description=findViewById(R.id.description);


        Intent intent=getIntent();
       String imageUri= intent.getStringExtra("selectedimage");



        //set image


        UniversalImageLoader.setImage(imageUri,imageShare,null,"file:/");


backArow.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }
);



share.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
);


    }
}
