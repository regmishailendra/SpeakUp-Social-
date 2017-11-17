package com.example.shailendra.speakup.Utils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by shailendra on 11/17/17.
 */
//to search directory and take everything in the directory

public class FileSearch {

    //searches directory and returns all directory

public static ArrayList<String> getDirectoryPaths(String directory){

    ArrayList<String> pathArray= new ArrayList<>();
    File file= new File(directory);
    File[] listfiles=file.listFiles();

    for(int i=0;i<listfiles.length;i++){

        if(listfiles[i].isDirectory()){
            pathArray.add(listfiles[i].getAbsolutePath());



        }






    }




    return pathArray;


}



public static ArrayList<String> getFilePaths(String directory){
    //searchs file and return
    ArrayList<String> fileArray=new ArrayList<>();

    File file= new File(directory);
    File[] listFile=file.listFiles();

    for(int i=0;i<listFile.length;i++){

        if(listFile[i].isFile()){

            fileArray.add(listFile[i].getAbsolutePath());

        }



    }

    return fileArray;

}




}
