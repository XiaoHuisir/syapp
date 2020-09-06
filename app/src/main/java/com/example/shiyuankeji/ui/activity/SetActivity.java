package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.ui.activity.login.LoginActivity;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.UtilsClicktime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends BaseActivity {
    @BindView(R.id.im_wbeak)
    ImageView imWbeak;
    @BindView(R.id.re_site)
    RelativeLayout reSite;
    @BindView(R.id.re_ID)
    RelativeLayout reID;
    @BindView(R.id.re_exit)
    RelativeLayout reExit;
    @BindView(R.id.re_alter_pwd)
    RelativeLayout reAlterPwd;
    @BindView(R.id.scrollview)
    ScrollView scrollview;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }


    @OnClick({R.id.im_wbeak, R.id.re_site, R.id.re_ID, R.id.re_exit, R.id.re_alter_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_alter_pwd://修改密码
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                Intent intentalter = new Intent();
                intentalter.setClass(context, AlterLoginPwdActivity.class);
                intentalter.putExtra("forgepwd","修改密码");
                startActivity(intentalter);

                break;
            case R.id.im_wbeak:
                finish();
                break;
            case R.id.re_site: //收货地址
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                Intent intent1 = new Intent();
                intent1.setClass(context, SelectAddressActivity.class);
                intent1.putExtra("mine_", "个人中心");
                Constant.IS_MINE = true;
                Constant.IS_MINE_IS = "2";
                startActivity(intent1);
                break;
            case R.id.re_ID:  //订单管理
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                Intent intents = new Intent();
                intents.setClass(context, MainActivity.class);
                intents.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intents.putExtra("id", Constant.TWO_TYPE_3);
                startActivityForResult(intents, Constant.TWO_TYPE_3);
                finish();
                break;
            case R.id.re_exit: //退出
                if (UtilsClicktime.isFastDoubleClick()) {
                    return;
                }
                LayoutInflater inflater = getLayoutInflater();
                //引入自定义好的对话框.xml布局
                View layout = inflater.inflate(R.layout.login_sk_verfiy, null);
                //实列提示对话框对象，并将加载的试图对象设置给对话框对象
                final AlertDialog alertDialog = new AlertDialog.Builder(context).setView(layout).show();
                final TextView yes = layout.findViewById(R.id.tv_ok);
                final TextView no = layout.findViewById(R.id.tv_no);
                final TextView tvTilte = layout.findViewById(R.id.tv_tilte);
                tvTilte.setText(R.string.do_you_want_to_log_out);
                yes.setText(R.string.exit_string);
                no.setText(R.string.cancel_string);
                yes.setOnClickListener(new View.OnClickListener() {  //是
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        SharedPreferencesUtil.deleteToken(MyApp.mApp);//删除token
                        Intent intent2 = new Intent();
                        intent2.setClass(context, LoginActivity.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent2);
                        finish();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {  //否
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });
                //----------
//                new AlertDialog.Builder(getActivity()).setTitle("是否退出账号")
//                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                SharedPreferencesUtil.deleteToken(MyApp.mApp);//删除token
//                                Intent intent2 = new Intent();
//                                intent2.setClass(context, LoginActivity.class);
//                                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent2);
//                                getActivity().finish();
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                }).create().show();

                break;
        }
    }
}
