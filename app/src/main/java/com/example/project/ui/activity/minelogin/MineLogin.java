package com.example.project.ui.activity.minelogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.example.project.R;

import butterknife.ButterKnife;

/**
 * 我的模块login版本之一（暂时无用）
 * Created by zhanghui on 20-4-20.
 */
public class MineLogin extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_minelogin);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {

    }
}
