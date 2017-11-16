package com.example.shailendra.speakup.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.shailendra.speakup.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shailendra on 11/16/17.
 */

public class GridImageAdapter extends ArrayAdapter<String>{

    private Context context;
    LayoutInflater inflater;
    int layoutResource;
    String append;
    ArrayList<String> imageUrl;


    public GridImageAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> imageUrl,String append) {
        super(context, resource, imageUrl);

        this.context=context;
        this.layoutResource=resource;
        this.imageUrl=imageUrl;
        this.append=append;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    private static class ViewHolder{
        SquareImageView profileImage;
        ProgressBar progressBar;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;
        if(convertView==null){


            convertView=inflater.inflate(layoutResource,parent,false);
            holder=new ViewHolder();
            holder.progressBar=convertView.findViewById(R.id.gridImagePB);
            holder.profileImage=(SquareImageView) convertView.findViewById(R.id.gridImageView);

            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();

        }


        String imageUrl=getItem(position);

        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(append + imageUrl, holder.profileImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(holder.progressBar!=null){
                    holder.progressBar.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (holder.progressBar != null) {
                    holder.progressBar.setVisibility(View.GONE);

                }
            }
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(holder.progressBar!=null) {
                    holder.progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(holder.progressBar!=null){
                    holder.progressBar.setVisibility(View.GONE);

                }}
        });


        return convertView;
    }



}
