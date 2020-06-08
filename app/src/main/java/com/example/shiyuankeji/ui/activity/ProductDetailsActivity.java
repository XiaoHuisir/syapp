package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.ProductDetailsBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.ProductDetailsContract;
import com.example.shiyuankeji.presenter.ProductDetailsPresenter;
import com.example.shiyuankeji.ui.activity.login.LoginActivity;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//toItemsDetail idsa
public class ProductDetailsActivity extends BaseActivity implements ProductDetailsContract.View {
    @BindView(R.id.lin_home)
    LinearLayout linHome;
    @BindView(R.id.lin_classfy)
    LinearLayout linClassfy;
    @BindView(R.id.btn_exchang)
    Button btnExchang;
    @BindView(R.id.im_beak)
    ImageView imBeak;
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
    @BindView(R.id.web_xiang)
    WebView webview;
    @BindView(R.id.lin_call_center)
    LinearLayout linCallCenter;

    private String ids;
    private ArrayList<StringBuffer> ims;
    private String img;
    private int price;
    private int buynum;
    private int idsa;
    private int freight;
    private int stock;
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
        ids = getIntent().getStringExtra("idsa");
        tvOldIntegral.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线
    }

    @Override
    protected void initData() {
        ((ProductDetailsPresenter) mPresenter).productDetails(Integer.parseInt(ids));

    }


    @OnClick({R.id.lin_home, R.id.lin_classfy, R.id.btn_exchang, R.id.im_beak, R.id.lin_call_center})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_home: //TODO 这里是跳转到 mainActivity的 HomeFragment(首页)
                Intent intent = new Intent();
                intent.setClass(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);//设置栈顶模式
                intent.putExtra("id", Constant.ONE_TYPE_1);
                startActivityForResult(intent, Constant.ONE_TYPE_1);
                finish();
                break;
            case R.id.lin_classfy://TODO 这里是跳转到 mainActivity的 ClassfyFragment（分类）
                Intent intent1 = new Intent();
                intent1.setClass(context, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("id", Constant.TWO_TYPE_2);
                startActivityForResult(intent1, Constant.TWO_TYPE_2);
                finish();
                break;
            case R.id.btn_exchang:
//                countDown();//我的模块登录状态初始化处理（判断是否登录） 带秒数的
                StateHandling();//我的模块登录状态初始化处理（判断是否登录） 不带秒数的

                break;
            case R.id.im_beak:
                finish();
                break;
            case R.id.lin_call_center: //客服
                startActivity(new Intent(context, WebCallCenterActivity.class));
                break;
        }
    }

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
        String token = SharedPreferencesUtil.getToken(MyApp.mApp);

        if (TextUtils.isEmpty(token)) {
            new AlertDialog.Builder(this).setTitle("登录后才可购买，是否前往登录!")
                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            SharedPreferencesUtil.deleteToken(MyApp.mApp);
                            intent.setClass(context, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;

                }
            }).create().show();

        } else {
            Constant.token = token;
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
        Toast.makeText(context, "商品详情成功", Toast.LENGTH_SHORT).show();
        idsa = result.getIdsa();
        String name = result.getName();
        //价格
        price = result.getPrice();
        int src_price = result.getSrc_price(); //原价
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
        tvPrice.setText(String.valueOf(price));
        tvOldIntegral.setText(String.valueOf(src_price));
        tvFreight.setText("运费：" + String.valueOf(freight));
        tvStock.setText("库存：" + String.valueOf(stock));


//        xiangqing(result); // TODO 详情 ？？？
        newxingqing(sulimg);
    }

    private void newxingqing(String sulimg) {
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
        webview.onResume();
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webview.loadUrl(sulimg);
//        webview.setWebViewClient(new WebViewClient());
    }

    private void xiangqing(ProductDetailsBean result) {

        String im = result.getImgs();

        StringBuffer sb = new StringBuffer();
//        以>对数据进行切割 返回一个字符串数组
        String[] split = im.split(",");

        for (int i = 0; i < split.length; i++) {
//            用<img src=“http:  来替换<img src=”
//            这里的\是为了保留当前的“
            String replace = split[i].replace("<img src=\"", "<img src=\"https:");
            //拼接
            sb.append(replace + " ");

        }
        //转成字符串
        String s = sb.toString();
        ArrayList<String> listimage = new ArrayList<>();
        listimage.add(s);

    }

    private void failedings() {
        Toast.makeText(context, "商品详情请求失败", Toast.LENGTH_SHORT).show();
    }


}
