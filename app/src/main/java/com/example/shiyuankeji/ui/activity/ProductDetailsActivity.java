package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.adapter.WebStringAdapter;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.LoginTokenBean;
import com.example.shiyuankeji.bean.ProductDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ProductDetailsContract;
import com.example.shiyuankeji.presenter.ProductDetailsPresenter;
import com.example.shiyuankeji.ui.activity.login.LoginActivity;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.UIUtil;
import com.example.shiyuankeji.utils.ZoomImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

//toItemsDetail idsa
public class ProductDetailsActivity extends BaseActivity implements ProductDetailsContract.View, View.OnClickListener, WebStringAdapter.WebClickItem {
    private static final String TAG = "stringtimp";
    //    @BindView(R.id.lin_home)
//    LinearLayout linHome;
//    @BindView(R.id.lin_classfy)
//    LinearLayout linClassfy;
//    @BindView(R.id.btn_exchang)
//    ImageView btnExchang;
//    @BindView(R.id.im_beak)
//    ImageView imBeak;
    @BindView(R.id.tv_old_price)
    TextView tvOldIntegral;
    @BindView(R.id.im_head)
    ImageView imHead;
    @BindView(R.id.tv_telet)
    TextView tvTelet;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_stock)
    TextView tvStock;
    @BindView(R.id.scrolls)
    ScrollView scrollss;
    //    @BindView(R.id.lin_call_center)
//    LinearLayout linCallCenter;
    @BindView(R.id.relat_string)
    RecyclerView reatString;
    @BindView(R.id.web_progressBar)
    ProgressBar webProgressBar;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.re_web)
    RelativeLayout reWeb;
    @BindView(R.id.relative_jcvideo)
    RelativeLayout relativeJcvideo;
    @BindView(R.id.relatice_web)
    RelativeLayout relaticWeb;
    @BindView(R.id.videocontroller)
    JCVideoPlayerStandard videocontroller;
    private String ids;
    private ArrayList<StringBuffer> ims;
    private String img;
    private int price;
    private int buynum;
    private int idsa;
    private int freight;
    private int stock;
    private ArrayList<String> strings;
    private WebStringAdapter webStringAdapter;

    private LinearLayout linHome;
    private LinearLayout linClassfy;
    private ImageView btnExchang;
    private ImageView imBeak;
    private LinearLayout linCallCenter;
    private String msg = "";
    //   @BindView(R.id.tv_old_integral)
//    TextView imBeak;


    @Override
    protected IBasePresenter getPresenter() {
        return new ProductDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_new;
    }

    @Override
    protected void initView() {
        scrollss.fullScroll(View.FOCUS_UP);
        reatString.setHasFixedSize(true);
        reatString.setNestedScrollingEnabled(false);
        ids = getIntent().getStringExtra("idsa");
        tvOldIntegral.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线

        initFindviewById();

    }

    private void initWeb(String mp) {
        //webview图片自适应。
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (webProgressBar == null) {
                    return;
                }
                webProgressBar.setProgress(newProgress);//设置进度值
                if (newProgress == 100) {
                    webProgressBar.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    webProgressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    webProgressBar.setProgress(newProgress);//设置进度值
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                navTitle.setText(title);
            }
        });
        webview.loadUrl(mp);
    }

private  void  initJcvideo(String video){

    videocontroller.setUp(video,videocontroller.SCREEN_LAYOUT_NORMAL,"");
}

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initFindviewById() {
        linHome = findViewById(R.id.lin_home);
        linClassfy = findViewById(R.id.lin_classfy);
        btnExchang = findViewById(R.id.btn_exchang);
        imBeak = findViewById(R.id.im_beak);
        linCallCenter = findViewById(R.id.lin_call_center);
        linHome.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);//设置栈顶模式
                intent.putExtra("id", Constant.ONE_TYPE_1);
                startActivityForResult(intent, Constant.ONE_TYPE_1);
                finish();
            }
        });
        linClassfy.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(context, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("id", Constant.TWO_TYPE_2);
                startActivityForResult(intent1, Constant.TWO_TYPE_2);
                finish();
            }
        });
        btnExchang.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                ((ProductDetailsPresenter) mPresenter).logintokens(); //校验是否登录
                //                countDown();//我的模块登录状态初始化处理（判断是否登录） 带秒数的
//                StateHandling();//我的模块登录状态初始化处理（判断是否登录） 不带秒数的

            }
        });
        imBeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JCVideoPlayer.releaseAllVideos();
                finish();
            }
        });
        linCallCenter.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                startActivity(new Intent(context, WebCallCenterActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        ((ProductDetailsPresenter) mPresenter).productDetails(Integer.parseInt(ids));


    }


//    @OnClick({R.id.lin_home, R.id.lin_classfy, R.id.btn_exchang, R.id.im_beak, R.id.lin_call_center})
//    public void onViewClicked(View view) {
//        view.setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
//                switch (v.getId()) {
//                    case R.id.lin_home: //TODO 这里是跳转到 mainActivity的 HomeFragment(首页)
//                        Intent intent = new Intent();
//                        intent.setClass(context, MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);//设置栈顶模式
//                        intent.putExtra("id", Constant.ONE_TYPE_1);
//                        startActivityForResult(intent, Constant.ONE_TYPE_1);
//                        finish();
//                        break;
//                    case R.id.lin_classfy://TODO 这里是跳转到 mainActivity的 ClassfyFragment（分类）
//                        Intent intent1 = new Intent();
//                        intent1.setClass(context, MainActivity.class);
//                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                        intent1.putExtra("id", Constant.TWO_TYPE_2);
//                        startActivityForResult(intent1, Constant.TWO_TYPE_2);
//                        finish();
//                        break;
//                    case R.id.btn_exchang:
////                countDown();//我的模块登录状态初始化处理（判断是否登录） 带秒数的
//                        StateHandling();//我的模块登录状态初始化处理（判断是否登录） 不带秒数的
//
//                        break;
//                    case R.id.im_beak:
//                        finish();
//                        break;
//                    case R.id.lin_call_center: //客服
//                        startActivity(new Intent(context, WebCallCenterActivity.class));
//                        break;
//                }
//            }
//        });
//
//    }

    //    /**
//     * 倒计时显示
//     */
//    private void countDown() {
//        CountDownTimer timer = new CountDownTimer(1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//            }
//
//            @Override
//            public void onFinish() {
////                Toast.makeText(context, "时间就是生命", Toast.LENGTH_SHORT).show();
//                StateHandling();   //TODO 用Token进行判断用户是否是登录状态
//            }
//        }.start();
//
//
//    }
    private void StateHandling() {


        if (msg.equals("001")) {
//            new AlertDialog.Builder(this).setTitle("登录后才可购买，是否前往登录!")
//                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent intent = new Intent();
//                            SharedPreferencesUtil.deleteToken(MyApp.mApp);
//                            intent.setClass(context, LoginActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }).setNegativeButton("否", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    return;
//
//                }
//            }).create().show();
            LayoutInflater inflater = getLayoutInflater();
            //引入自定义好的对话框.xml布局
            View layout = inflater.inflate(R.layout.login_sk_verfiy, null);
            //实列提示对话框对象，并将加载的试图对象设置给对话框对象
            final AlertDialog alertDialog = new AlertDialog.Builder(this).setView(layout).show();
            final TextView yes = layout.findViewById(R.id.tv_ok);
            final TextView no = layout.findViewById(R.id.tv_no);
            final TextView tvTilte = layout.findViewById(R.id.tv_tilte);
            tvTilte.setText(R.string.login_is_string);
            yes.setOnClickListener(new View.OnClickListener() {  //是
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    Intent intent = new Intent();
                    SharedPreferencesUtil.deleteToken(MyApp.mApp);
                    intent.setClass(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {  //否
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();

                }
            });
        } else {
//            Constant.token = token;
//            Intent intent2 = new Intent(context, ExchangeActivity.class);
//            intent2.putExtra("price", price);
//            intent2.putExtra("imgs", img);
//            intent2.putExtra("buynums", buynum);
//            intent2.putExtra("stock_", stock);
//            intent2.putExtra("idsas", idsa);
////                intent2.putExtra("freight_",freight);
//            startActivity(intent2);
        }
    }

    @Override
    public void logintokenReaun(LoginTokenBean loginTokenBean) { //校验是否登录状态
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);
        msg = loginTokenBean.getMsg();
        if (msg.equals("001")) {
            StateHandling();
        } else {
            Constant.token = token;
            if (stock == 0) {
                Toast.makeText(context, R.string.understock_string, Toast.LENGTH_SHORT).show();


                return;
            }
            Intent intent2 = new Intent(context, ExchangeActivity.class);
            intent2.putExtra("price", price);
            intent2.putExtra("imgs", img);
            intent2.putExtra("buynums", buynum);
            intent2.putExtra("stock_", stock);
            intent2.putExtra("idsas", idsa);
//                intent2.putExtra("freight_",freight);
            startActivity(intent2);
        }

    }

    @Override
    public void ProductDetailsReturn(ProductDetailsBean result) {
        if (result != null) {
            winings(result);
        } else {
            failedings();
        }
    }

    private void winings(ProductDetailsBean result) {
//        Toast.makeText(context, "商品详情成功", Toast.LENGTH_SHORT).show();
        idsa = result.getIdsa();
        String name = result.getName();
        //价格
        price = result.getCode_price();
        int src_price = result.getSrc_price_code(); //原价
        //库存
        stock = result.getStock();
        //图
        img = result.getImg();
        //运费
        freight = result.getFreight();
        //限购数量
        buynum = result.getBuynum();
        String sulimg = result.getImges();
        Glide.with(context).load(img).into(imHead);
        tvTelet.setText(name);
        if (String.valueOf(price).equals(String.valueOf(src_price))) {
            tvOldIntegral.setVisibility(View.GONE);
        } else {
            tvOldIntegral.setText(String.valueOf(src_price));
        }
        tvPrice.setText(String.valueOf(price));

        tvFreight.setText("运费：" + String.valueOf(freight));
        tvStock.setText("库存：" + String.valueOf(stock));


//        xiangqing(sulimg); // TODO 详情 ？？？
//        newxingqing(sulimg);
        stringtemp(sulimg);
    }

    private void stringtemp(String sulimg) {
        strings = new ArrayList<>();
        reatString.setLayoutManager(new LinearLayoutManager(context));
        webStringAdapter = new WebStringAdapter(strings);
        webStringAdapter.webClickItem=this;
        reatString.setAdapter(webStringAdapter);
        String[] temp;
        String delimeter = ",";
        temp = sulimg.split(delimeter);
        String videos = temp[0];
//           @BindView(R.id.relative_jcvideo)
//    RelativeLayout relativeJcvideo;
//    @BindView(R.id.relatice_web)
//    RelativeLayout relaticWeb;
//    @BindView(R.id.videocontroller)
//    JCVideoPlayer videocontroller;
        if (videos != null) {
            boolean contains = videos.contains(Constant.CONTAINS);
            boolean iframe = videos.contains(Constant.IFRAME);//
            if (iframe==true) {
                reWeb.setVisibility(View.VISIBLE);
                relaticWeb.setVisibility(View.VISIBLE);
                relativeJcvideo.setVisibility(View.GONE);
                initWeb(videos);
            }else if (contains == true){
                reWeb.setVisibility(View.VISIBLE);
                relativeJcvideo.setVisibility(View.VISIBLE);
                relaticWeb.setVisibility(View.GONE);
                initJcvideo(videos);

            }else {
                reWeb.setVisibility(View.GONE);
            }
        }
        for (int i = 0; i < temp.length; i++) {
            strings.addAll(Collections.singleton(temp[i]));
            webStringAdapter.notifyDataSetChanged();

        }

    }

//    private void newxingqing(String urlsulimg) {
//
//
//        WebSettings settings = webview.getSettings();
//        // 设置WebView支持JavaScript
//        settings.setJavaScriptEnabled(true);
//        //支持自动适配
//        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);
//        settings.setSupportZoom(true);  //支持放大缩小
//        settings.setBuiltInZoomControls(true); //显示缩放按钮
//        settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
//        settings.setAllowFileAccess(true); // 允许访问文件
//        settings.setSaveFormData(true);
//        settings.setGeolocationEnabled(true);
//        settings.setDomStorageEnabled(true);
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        //设置不让其跳转浏览器
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });
//
//        // 添加客户端支持
//        webview.setWebChromeClient(new WebChromeClient());
////        mWebView.loadUrl(TEXTURL);
//
//        //不加这个图片显示不出来
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            webview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//        webview.getSettings().setBlockNetworkImage(false);
//
////允许cookie 不然有的网站无法登陆
//        CookieManager mCookieManager = CookieManager.getInstance();
//        mCookieManager.setAcceptCookie(true);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mCookieManager.setAcceptThirdPartyCookies(webview, true);
//        }
//
//        webview.loadUrl(urlsulimg);
//
//        //-------------------------
////        webview.getSettings()
////                .setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
////
////        webview.getSettings().setLoadWithOverviewMode(true);
////        // 支持javascript
////        webview.getSettings().setJavaScriptEnabled(true);
////        webview.getSettings().setUseWideViewPort(true);
////        webview.getSettings().setLoadWithOverviewMode(true);
////        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
////        // 设置可以支持缩放
////        webview.getSettings().setSupportZoom(false);
////        webview.getSettings().setUseWideViewPort(true);
////        webview.getSettings().setAllowFileAccess(true); // 允许访问文件
////        // 设置出现缩放工具
////        webview.getSettings().setBuiltInZoomControls(false);
////        // 扩大比例的缩放
////        webview.getSettings().setUseWideViewPort(false);
////        webview.getSettings().setDefaultTextEncodingName("UTF-8");
////        webview.getSettings().setLoadsImagesAutomatically(true);  //支持自动加载图片
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
////            webview.getSettings().setMediaPlaybackRequiresUserGesture(false);
////        }
////webview.loadUrl(sulimg);
//        //---------------------------------
//        //webview图片自适应。
////        WebSettings webSettings = webview.getSettings();
////        webSettings.setJavaScriptEnabled(true);
////        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
////        webSettings.setUseWideViewPort(true);//关键点
////        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
////        webSettings.setDisplayZoomControls(false);
////        webSettings.setAllowFileAccess(true); // 允许访问文件
////        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
////        webSettings.setSupportZoom(true); // 支持缩放
////        webSettings.setLoadWithOverviewMode(true);
////        webview.onResume();
////        webview.setWebViewClient(new WebViewClient() {
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                return super.shouldOverrideUrlLoading(view, url);
////            }
////        });
////        webview.loadUrl(urlsulimg);
//////        webview.setWebViewClient(new WebViewClient());
//
//    }

    //    private void xiangqing(String result) {
//
//
//
//        StringBuffer sb = new StringBuffer();
////        以>对数据进行切割 返回一个字符串数组
//        String[] split = result.split(",");
//
//        for (int i = 0; i < split.length; i++) {
////            用<img src=“http:  来替换<img src=”
////            这里的\是为了保留当前的“
//            String replace = split[i].replace("<img src=\"", "<img src=\"https:");
//            //拼接
//            sb.append(replace + " ");
//
//        }
//        //转成字符串
//        String s = sb.toString();
//        ArrayList<String> listimage = new ArrayList<>();
//        listimage.add(s);
//
//    }
    private void failedings() {
//        Toast.makeText(context, "商品详情请求失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        v.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {

            }
        });
    }

    @Override
    public void webclickitem(String items) {
        if (items==null)return;
        Intent intent = new Intent();
        intent.setClass(context,PhotoAcitity.class);
        intent.putExtra("photo",items);
        startActivity(intent);
    }
}
