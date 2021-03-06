package com.example.shiyuankeji.ui.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.JoinBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.JoinContract;
import com.example.shiyuankeji.presenter.JoinPresenter;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.jwkj.libzxing.OnQRCodeScanCallback;
import com.jwkj.libzxing.QRCodeManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public class MyScanCodeActivity extends BaseActivity implements JoinContract.View {
    @BindView(R.id.btn_navi_back)
    LinearLayout btnNaviBack;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.web_progressBar)
    ProgressBar webProgressBar;
    @BindView(R.id.rl_web_top)
    RelativeLayout rlwebtop;
    @BindView(R.id.tv_err_tilte)
    TextView tv_err_tilte;
    private String saomao_ = "";


    @Override
    protected IBasePresenter getPresenter() {
        return new JoinPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scan_code;
    }

    @Override
    protected void initView() {

//        //隐藏系统默认的标题
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
        boolean isBool = SharedPreferencesUtil.getIsBool(context);
        boolean xiangIsBool = SharedPreferencesUtil.getXiangIsBool(context);

        if (isBool == false) {
            new AlertDialog.Builder(this).setTitle(R.string.scan_string)
                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            camera(); //相机权限
//                            same(); //相册权限
                        }
                    }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            }).create().show();

        } else {
            if (xiangIsBool == false) {
                new AlertDialog.Builder(this).setTitle(R.string.photo_album_string)
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                            camera(); //相机权限
                                same(); //相册权限
                            }
                        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                }).create().show();
            } else {

                scancodes(); //扫描功能
            }
        }

    }

    @Override
    protected void initData() {

    }

    private void same() {
        // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限（储存）

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                new AlertDialog.Builder(MyScanCodeActivity.this).setTitle(R.string.dianji_scan_string)
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 申请权限（储存）
                                ActivityCompat.requestPermissions(MyScanCodeActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
                                SharedPreferencesUtil.addXiangIsBool(context,true);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferencesUtil.addXiangIsBool(context, false);
                        finish();
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(MyScanCodeActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);

            }
        }else {
            return;
        }
    }

    private void camera() {
//        same();
//        checkSelfPermission 检测有没有 权限
//        PackageManager.PERMISSION_GRANTED 有权限
//        PackageManager.PERMISSION_DENIED  拒绝权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //权限发生了改变 true  //  false 小米
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {


                new AlertDialog.Builder(this).setTitle(R.string.dianji_photo_album_string)
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 请求授权 (相机)
                                ActivityCompat.requestPermissions(MyScanCodeActivity.this, new String[]{Manifest.permission.CAMERA}, 1);

//                                same();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferencesUtil.addIsBool(context, false);
                        finish();
                    }
                }).create().show();


            } else {
                ActivityCompat.requestPermissions(MyScanCodeActivity.this, new String[]{Manifest.permission.CAMERA}, 1);

            }

        } else {

//            camear(); //相机

            return;

        }


    }

    /**
     * @param requestCode
     * @param permissions  请求的权限
     * @param grantResults 请求权限返回的结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == 1) {
            // camear 权限回调

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // 表示用户授权
                Toast.makeText(this, R.string.allow_the_authorized_string, Toast.LENGTH_SHORT).show();

//                camear();
//                same();
                SharedPreferencesUtil.addIsBool(context, true);
//                SharedPreferencesUtil.addXiangIsBool(context,true);
                if (SharedPreferencesUtil.getIsBool(context) == true && SharedPreferencesUtil.getXiangIsBool(context) == true) {
                    scancodes(); //扫描功能
                } else {
                    same();
                }
            } else {
                //用户拒绝权限
                Toast.makeText(this, R.string.no_allow_the_authorized_string, Toast.LENGTH_SHORT).show();
//                same();
                camera();
                SharedPreferencesUtil.addIsBool(context, false);
//                SharedPreferencesUtil.addXiangIsBool(context, false);
            }


        }
        if (requestCode == 2) {
            // camear 权限回调

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                                SharedPreferencesUtil.addXiangIsBool(context,true);
                if (SharedPreferencesUtil.getIsBool(context) == true && SharedPreferencesUtil.getXiangIsBool(context) == true) {
                    scancodes(); //扫描功能
                } else {
                    same();
                }
            }else {

            //用户拒绝权限
            Toast.makeText(this, R.string.no_scan_string, Toast.LENGTH_SHORT).show();
                same();
//            camera();
//            SharedPreferencesUtil.addIsBool(context, false);
                SharedPreferencesUtil.addXiangIsBool(context, false);
        }}
//                // 表示用户授权
//                Toast.makeText(this, " 允许授权", Toast.LENGTH_SHORT).show();
//
////                camear();
////                scancodes(); //扫描功能
////                same();
//                SharedPreferencesUtil.addIsBool(context, true);
//
//            } else {
//                //用户拒绝权限
//                Toast.makeText(this, " 未允许授权", Toast.LENGTH_SHORT).show();
//                same();
////                camera();
//                SharedPreferencesUtil.addIsBool(context, false);
//            }


//        }

    }


    private void scancodes() {
//                same();
        QRCodeManager.getInstance().with(this).setReqeustType(0).scanningQRCode(new OnQRCodeScanCallback() {
            @Override
            public void onCompleted(String s) {
//                Toast toast = Toast.makeText(context, "结果:" + s, Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                Pattern p = Pattern.compile(".*shiyuanInvitationCode.*"); //判断是否为识缘指定字段 shiyuanInvitationCode
                Matcher m = p.matcher(s);
                boolean isValid = m.matches();
                if (isValid == true) {
                    // 截取=号前的字符串
                    String str = s.substring(0, s.indexOf("="));
                    // 截取=号后的字符串
                    String bb = s.substring(str.length() + 1, s.length());
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "为识缘指定字段code:" + bb);
//                    toastUtil2.show();
                    if (bb != null) {
                        ((JoinPresenter) mPresenter).isjoin(bb);
                    }
                    //TODO （未完成。。。。带实现）
                } else {
                    tv_err_tilte.setVisibility(View.GONE);
                    webshow(s);
//                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
                String s = throwable.toString();
                Toast.makeText(context,R.string.scan_cuowu_string + s,Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "扫描错误信息：" + s);
//                toastUtil2.show();
            }

            @Override
            public void onCancel() {

            }
        });
    }


    private void webshow(String s) {
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
        webview.loadUrl(s);
        webview.setWebViewClient(new WebViewClient());
    }

    //扫描
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Toast.makeText(context, "走了:", Toast.LENGTH_SHORT).show();
        //注册onActivityResult
        QRCodeManager.getInstance().with(this).onActivityResult(requestCode, resultCode, data);


    }

//    public void camear(){
//        try {
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            startActivityForResult(intent,1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @OnClick(R.id.btn_navi_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void isjoinRrean(JoinBean joinBean) { //1
        if (joinBean != null) {
            final int id = joinBean.getId();
//      "nick_name": "N号初级合作组",
//    "level": 1,
//    "affiliated_userid": 8,
//    "people_num": 4,
            String nick_name = joinBean.getNick_name(); //合作团名称
            int people_num = joinBean.getPeople_num();//团人数
            new AlertDialog.Builder(this).setTitle(nick_name + "  " + "当前人数：" + people_num + "人")
                    .setPositiveButton("加入", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((JoinPresenter) mPresenter).joins(id);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            }).create().show();
        }
    }

    @Override
    public void joinRrean(JoinBean joinBean) {//2
//           /**
//     * status : 500
//     * data :
//     * msg : 您已经加入其它的合作组！
//     */
        if (joinBean != null) {
            int status = joinBean.getStatus();

            Intent intent = new Intent();
            if (status == 200) {//加入成功
//                Toast toast = Toast.makeText(context, "成功：" + joinBean.getMsg(), Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                Toast.makeText(context,R.string.ok_string + joinBean.getMsg(),Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal,  "成功：" + joinBean.getMsg());
//                toastUtil2.show();
                intent.setClass(context, SynergicActivity.class);
                finish();
            } else {//加入失败、已加入其他组
//                Toast toast = Toast.makeText(context, joinBean.getMsg(), Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                Toast.makeText(context,R.string.no_string + joinBean.getMsg(),Toast.LENGTH_SHORT).show();
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal,  "失败：" + joinBean.getMsg());
//                toastUtil2.show();
                intent.setClass(context, SynergicActivity.class);
                finish();
            }

            startActivity(intent);
        } else {
            return;
        }
    }
}
