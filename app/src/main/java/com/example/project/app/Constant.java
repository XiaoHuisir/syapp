package com.example.project.app;


import android.os.Environment;

import java.io.File;

public class Constant {

    //    public static final String URl = "http://123.206.58.124:8025/index/user/login";
    public static final String URl = "http://sc.minxj.com/api/";
    public static final String BaseUrl = "http://123.206.58.124:8025/";
    public static final String IndexBaseUrl = "http://www.sosoapi.com/pass/mock/";

    public static final String ResUrl = "http://images.ciotimes.com/"; //七牛图片地址

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/cilo";

    public static final String PATH_PDF = MyApp.mApp.getFilesDir().getAbsolutePath()+"/pdfs/";
    public static final String PATH_APK = MyApp.mApp.getFilesDir().getAbsolutePath()+"/apks/";
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
    public static final int COURSE_TYPE_1 = 1; //课外学习
    public static final int COURSE_TYPE_2 = 2; //培训

    public static final int STUDY_TYPE_1 = 1; //智慧课堂
    public static final int STUDY_TYPE_2 = 2; //内部培训
    public static final int STUDY_TYPE_3 = 3; //其他培训

    public static final int ONE_CODE = 10000;

    public static String CURTYPE = "";
    public static final String STUD_TYPE_0 = "0";
    public static final String STUD_TYPE_1 = "1";
    public static final String STUD_TYPE_2 = "2";


}
