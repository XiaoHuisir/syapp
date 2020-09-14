package com.example.shiyuankeji.app;


import android.os.Environment;

import java.io.File;

/**
 * Created by zhanghui on 20-3-30.
 */
public class Constant {
    public static final String BaseUrl = "http://192.168.124.6:8080/"; //识缘  （局域网）  TODO  张文端
//        public static final String BaseUrl = "http://192.168.124.7:8080/"; //识缘  （局域网）  TODO  李聪
//    public static final String BaseUrl = "http://api.mb.knowfate.com.cn/shiyuanshop-0.0.1-SNAPSHOT/"; //识缘 （服务器）
//    public static final String BaseUrl = "http://api.mb.knowfate.com.cn:8080/shiyuanshop-0.0.1-SNAPSHOT/"; //new 识缘 （服务器）
//    public static final String BaseUrl = "https://api.mb.knowfate.com.cn:8080/"; //new 识缘 （ssl 服务器）


    //    public static final String URl = "http://123.206.58.124:8025/index/user/login";
    public static final String URl = "http://sc.minxj.com/api/";
    //    public static final String BaseUr = "http://123.206.58.124:8025/"; //TODO IW
    public static final String IndexBaseUrl = "http://www.sosoapi.com/pass/mock/";
    public static final String ResUrl = "http://images.ciotimes.com/"; //七牛图片地址

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/cilo";//shiyuan

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

    public static final int REGISTER = 156;
    public static final int STATUS = 1;
    public static final int ZERO = 0;
    public static final int ONE_TYPE_1 = 1;
    public static final int TWO_TYPE_2 = 2;
    public static final int TWO_TYPE_3 = 3;

    public static final int STUDY_TYPE_1 = 0; //
    public static final int STUDY_TYPE_2 = 1; //
    public static final int STUDY_TYPE_3 = 3; //

    public static final int ONE_CODE = 10000;
    public static String IDS_CLASSFY = "";
    public static String CURTYPE = "";
    public static String MINE = "";
    public static final String STUD_TYPE_0 = "0";
    public static final String STUD_TYPE_1 = "1";
    public static final String STUD_TYPE_2 = "2";
    public static final int IS_ID = 0;
    public static int DYNAMIC_DIGITAL = 1; // 动态兑换数量
    public static int DYNAMIC_PRICE = 0;

    //    0，订单待确认、1，待发货、2，待收货、3，兑换完成、4，积分不够

    public static final int ORDER_STATE_0 = 0;
    public static final int ORDER_STATE_1 = 1;
    public static final int ORDER_STATE_2 = 2;
    public static final int ORDER_STATE_3 = 3;
    public static final int ORDER_STATE_4 = 4;
    public static final int ORDER_STATE_5 = 5;

    public static String IMG = "";
    public static String NAME = "";
    public static int FREIGHT = 0;
    public static int SRC_PRICE = 0;
    public static int IDSAS = 0;
    public static int ZONG_JIA = 0;
    public static int NUM = 0;
    public static final String CONTAINS = ".mp4";
    public static final String IFRAME = "iframe";
    public static boolean IS_MINE = false;
    public static String IS_MINE_IS = "";

    public static boolean INXDLER = false;
    public static boolean CLASS_BOOLEAN = false;

    //判断服务器是否异常
    public  static  boolean SWEVER_SIDE=false;

}
