package com.example.shiyuankeji.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestingCenterActivity extends BaseActivity {
    @BindView(R.id.btn_navi_back)
    LinearLayout btnNaviBack;
    @BindView(R.id.web_progressBar)
    ProgressBar webProgressBar;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_testingcenter;
    }




    @OnClick({R.id.btn_navi_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_navi_back:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        //webview图片自适应。
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(false); // 支持缩放
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
        webview.loadUrl("http://bc.knowfate.com.cn/zhjczx/");
    }
}
