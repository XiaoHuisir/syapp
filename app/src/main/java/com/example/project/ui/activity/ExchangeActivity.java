package com.example.project.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExchangeActivity extends Activity {
    @BindView(R.id.cancel)
    View cancel;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_minus)
    TextView tvMinus;
    @BindView(R.id.btn_exchang)
    Button btnExchang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.cancel, R.id.tv_add, R.id.tv_minus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                finish();
                break;
            case R.id.tv_add:

                break;
            case R.id.tv_minus:

                break;
        }
    }
}
