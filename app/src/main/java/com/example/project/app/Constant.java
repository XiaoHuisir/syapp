package com.example.project.app;


import android.os.Environment;

import java.io.File;

/**
 * Created by zhanghui on 20-3-30.
 */
public class Constant {
//        public static final String BaseUrl = "http://192.168.124.13:8080/"; //识缘  （局域网）  TODO  张文端
//    public static final String BaseUrl = "http://192.168.124.14:8080/"; //识缘  （局域网）  TODO  李聪
    public static final String BaseUrl = "http://api.mb.knowfate.com.cn/shiyuanshop-0.0.1-SNAPSHOT/"; //识缘 （服务器）


    //    public static final String URl = "http://123.206.58.124:8025/index/user/login";
    public static final String URl = "http://sc.minxj.com/api/";
    //    public static final String BaseUr = "http://123.206.58.124:8025/"; //TODO IW
    public static final String IndexBaseUrl = "http://www.sosoapi.com/pass/mock/";
    public static final String ResUrl = "http://images.ciotimes.com/"; //七牛图片地址

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/shiyuan";//cilo

    public static final String PATH_PDF = MyApp.mApp.getFilesDir().getAbsolutePath() + "/pdfs/";
    public static final String PATH_APK = MyApp.mApp.getFilesDir().getAbsolutePath() + "/apks/";
    public static String DEFAULT_SAVE_IMAGE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "com.example.myapplication"
            + File.separator + "user_img" + File.separator;


    public static String token = "";

    public static String NUM_VIEW = "";

    public static int CourseType = 2;

    public static String mobiles = "";
    public static String passwords = "";

    public static final int STATUS = 1;
    public static final int ZERO = 0;
    public static final int ONE_TYPE_1 = 1;
    public static final int TWO_TYPE_2 = 2;

    public static final int STUDY_TYPE_1 = 0; //
    public static final int STUDY_TYPE_2 = 1; //
    public static final int STUDY_TYPE_3 = 3; //

    public static final int ONE_CODE = 10000;

    public static String CURTYPE = "";
    public static final String STUD_TYPE_0 = "0";
    public static final String STUD_TYPE_1 = "1";
    public static final String STUD_TYPE_2 = "2";
    public static final int IS_ID = 0;
    public static int DYNAMIC_DIGITAL = 1;
    public static int DYNAMIC_PRICE = 0;

}
