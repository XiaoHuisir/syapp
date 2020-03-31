package com.example.project.utils;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtils {

    private static URL url;

    public void downFile(String urlStr, String path,DownLoadListener callback) {

        InputStream inputStream = null;
        try {
            File file = new File(path);
            if(file.exists()){
                Log.i("DownLoad","file is exists");
            } else {
                file.createNewFile();
                //得到io流
                HttpURLConnection urlConn;
                int size=0;
                try {
                    url = new URL(urlStr);
                    urlConn = (HttpURLConnection) url.openConnection();
                    inputStream = urlConn.getInputStream();
                    size = urlConn.getContentLength();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //从input流中将文件写入SD卡中
                write2SDFromInput(file, inputStream,size,callback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void write2SDFromInput(File file,InputStream input,int size,DownLoadListener callback) {
        OutputStream output = null;
        try {
            int total,loaded=0;
            total = size;
            // 开启输出流，准备写入文件
            output = new FileOutputStream(file);
            // 缓冲区
            byte[] buffer = new byte[1024*4];
            int count;
            while ((count = input.read(buffer)) != -1) {
                // 这里，请一定按该方式写入文件，不然时而会出现文件写入错误，数据丢失问题
                loaded += count;
                output.write(buffer, 0, count);
                callback.loading(loaded,total);
            }
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface DownLoadListener{
        void loading(int loaded, int total);
    }

}
