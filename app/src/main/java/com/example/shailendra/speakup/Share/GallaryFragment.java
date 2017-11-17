package com.example.shailendra.speakup.Share;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shailendra.speakup.R;
import com.example.shailendra.speakup.Utils.FilePaths;
import com.example.shailendra.speakup.Utils.FileSearch;
import com.example.shailendra.speakup.Utils.GridImageAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

/**
 * Created by shailendra on 11/15/17.
 */

public class GallaryFragment extends Fragment {


    GridView gridView;
    ImageView imageView;
    ProgressBar progressBar;
    Spinner spinner;
    String selectedImage;

    ArrayList<String> directories;
    private int noOfColumns = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallary, container, false);

        imageView = view.findViewById(R.id.gallaryimageview);
        gridView = view.findViewById(R.id.gridView);
        spinner = view.findViewById(R.id.spinnerDir);
        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        directories = new ArrayList<>();


        ImageView shareClose = view.findViewById(R.id.imageviewcloseshare);

        shareClose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                    }
                }
        );

        TextView nextString = view.findViewById(R.id.textviewnext);
        nextString.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent= new Intent(getActivity(),NextActivity.class);
                        intent.putExtra("selectedimage",selectedImage);
                        startActivity(intent);


                    }
                }

        );


        init();


        return view;


    }


    public void init() {

        FilePaths filePaths = new FilePaths();

        if (FileSearch.getDirectoryPaths(filePaths.PICTURES) != null) {
            Log.i("gallaryman", "inside here");
            directories = FileSearch.getDirectoryPaths(filePaths.PICTURES);
        } else {

            Log.i("gallaryman", "outside here");

        }


        ArrayList<String> directoryNames = new ArrayList<>();
        for (int i = 0; i < directories.size(); i++) {

            int index = directories.get(i).lastIndexOf("/");
            String string = directories.get(i).substring(index + 1);

            directoryNames.add(string);


        }


        directories.add(filePaths.CAMERA);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, directories);
        // ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,directoryNames); //camera didnt show up when managing names
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                        setUpGridView(directories.get(position));


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );


    }


    private void setUpGridView(String directory) {

        final ArrayList<String> imageUrl = FileSearch.getFilePaths(directory);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth / noOfColumns;

        gridView.setColumnWidth(imageWidth);

        GridImageAdapter gridImageAdapter = new GridImageAdapter(getActivity(),
                R.layout.layout_grid_imageview, imageUrl, "file:/"); //this should be file:/ according to uil so /storage is default absoult path  //in this layout we have made a imageview like class for same height and width of imageview
        gridView.setAdapter(gridImageAdapter);

        setImage(imageUrl.get(0), imageView, "file:/");

        selectedImage = imageUrl.get(0);

        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        setImage(imageUrl.get(position), imageView, "file:/");
                        selectedImage = imageUrl.get(position);

                    }
                }
        );


    }

//set  first image to be displayed when activity fragment view is inflated

    private void setImage(String imageUrl, ImageView image, String append) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(append + imageUrl, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);

            }
        });


    }


}
