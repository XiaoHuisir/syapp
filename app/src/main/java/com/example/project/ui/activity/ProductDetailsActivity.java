package com.example.project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.ui.fragment.ClassifyFragment;
import com.example.project.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsActivity extends BaseActivity {
    @BindView(R.id.lin_home)
    LinearLayout linHome;
    @BindView(R.id.lin_classfy)
    LinearLayout linClassfy;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.lin_home, R.id.lin_classfy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_home:
                Intent intent=new Intent(context, MainActivity.class);
                intent.putExtra("id", Constant.ONE_TYPE_1);
                startActivity(intent);

                break;
            case R.id.lin_classfy:
                Intent intent1=new Intent(context, MainActivity.class);
                intent1.putExtra("id", Constant.TWO_TYPE_2);
                startActivity(intent1);
                break;
        }
    }
}
