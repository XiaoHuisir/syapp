package com.example.shiyuankeji.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {

    /**
     * 判断文件是否存在
     * @param path
     * @return
     */
    public static int checkFile(String path){
        File file = new File(path);
        if(file.exists()){
            try {
                FileInputStream inputStream = new FileInputStream(file);
                return inputStream.available();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean checkDir(String path){
        File file = new File(path);
        if(!file.exists()){
            return file.mkdir();
        }
        return true;
    }

}
