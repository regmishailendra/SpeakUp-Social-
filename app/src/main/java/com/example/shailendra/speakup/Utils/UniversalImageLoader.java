package com.example.shailendra.speakup.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.shailendra.speakup.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by shailendra on 11/16/17.
 */

public class UniversalImageLoader {



    private Context context;

    public UniversalImageLoader(Context context){

        this.context=context;
    }

    public ImageLoaderConfiguration getConfig(){

        DisplayImageOptions defaultOptions= new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_android)
                .showImageForEmptyUri(R.drawable.ic_android)
                .showImageOnFail(R.drawable.ic_android)
//                .cacheOnDisk(true)
//                .cacheInMemory(true)
               // .resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();


        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024).build();


        return config;


    }





    public static void setImage(String imageUrl, ImageView image, final ProgressBar mProgressbar, String append){

        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(append + imageUrl, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(mProgressbar!=null){
                    mProgressbar.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (mProgressbar != null) {
                    mProgressbar.setVisibility(View.GONE);

                }
            }
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(mProgressbar!=null) {
                    mProgressbar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(mProgressbar!=null){
                    mProgressbar.setVisibility(View.GONE);

            }}
        });



    }



}
