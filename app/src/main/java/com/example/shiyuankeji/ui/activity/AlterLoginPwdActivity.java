package com.example.shiyuankeji.ui.activity;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.MainActivity;
import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.app.MyApp;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.bean.AlterBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.AlterContract;
import com.example.shiyuankeji.presenter.AlterPresenter;
import com.example.shiyuankeji.presenter.register.RegisterPresenter;
import com.example.shiyuankeji.ui.activity.login.LoginActivity;
import com.example.shiyuankeji.ui.activity.login.RegisterActivity;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.Validator;
import com.example.shiyuankeji.widgets.verificationcode.NetUtil;
import com.example.shiyuankeji.widgets.verificationcode.ProgressDialogShowUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AlterLoginPwdActivity extends BaseActivity implements AlterContract.View {
    @BindView(R.id.ed_re_userpho)
    EditText edReUserpho;
    @BindView(R.id.ed_re_pwd)
    EditText edRePwd;

    //    @BindView(R.id.linshow)
//    LinearLayout linshows;
    @BindView(R.id.lins_break)
    ImageView linsBreak;
    @BindView(R.id.tv_pwd01)
    TextView tvPwd01;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.getMsgCodeTv)
    TextView getmsgCodeTv;
    @BindView(R.id.re_shuru1)
    CardView cardShou;
    @BindView(R.id.btn_show)
    ImageView btnShow;
    @BindView(R.id.title_tou)
    TextView titletou;
    private MyThread myThread;
    private int time = 0;  //限制注册次数
    private boolean indxler = false;
    private String userpho = "";
    private String pwd = "";
    private int type_;
    public static boolean sending = false;
    private String edname = "";
    private LinearLayout linRegister;
    private TextView tvShow;
    private final static int TYPE_NORMAL = 200;//修改成功

    @Override
    protected IBasePresenter getPresenter() {
        return new AlterPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_alterloginpwd;
    }

    @Override
    protected void initView() {
        String forgepwd = getIntent().getStringExtra("forgepwd");
        titletou.setText(forgepwd);
        type_ = getIntent().getIntExtra("type_", 0);
        tvPwd01.setVisibility(View.VISIBLE);
        tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
        initFindViewById();
    }

    private void initFindViewById() {
        linRegister = findViewById(R.id.lin_register);
        linRegister.setOnClickListener(new NoDoubleClickListener() { //注册按钮
            @Override
            protected void onNoDoubleClick(View v) {
                userpho = edReUserpho.getText().toString();
                pwd = edRePwd.getText().toString();
                edname = edName.getText().toString();//验证码
                if (TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd) && TextUtils.isEmpty(edname)) {
                    Toast.makeText(context, R.string.regoster_pho_null_string, Toast.LENGTH_SHORT).show();
                    tvPwd01.setText(R.string.regoster_pho_null_string);
                    return;
                }
                if (!TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd)) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText(R.string.login_pwd_string);
                    return;
                }
                if (TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd)) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText(R.string.regoster_pho_string);
                    return;
                }
                if (Validator.isMobile(userpho) == false) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText(R.string.regoster_pho_ok_string);
                    return;
                }
                if (Validator.isPwd(pwd) == false) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, R.string.regoster_ok_string, Toast.LENGTH_SHORT).show();

                    return;
                }
                if (Validator.isMobile(userpho) == false || Validator.isPwd(pwd) == false) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, R.string.regoster_ok_string, Toast.LENGTH_SHORT).show();

                    return;
                }
                if (Validator.shuziss(pwd) == true) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, R.string.regoster_ok_string, Toast.LENGTH_SHORT).show();

                    return;
                }


                if (!TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(edname) &&
                        Validator.isMobile(userpho) == true && Validator.isPwd(pwd) == true) {
//                    Toast.makeText(context, "走注册！", Toast.LENGTH_SHORT).show();
                    tvPwd01.setVisibility(View.GONE);
                    ((AlterPresenter) mPresenter).alters(userpho, pwd, edname); //TODO
                }
            }
        });
//        tvShow = findViewById(R.id.tv_show);
//        tvShow.setOnClickListener(new NoDoubleClickListener() { //去登陆
//            @Override
//            protected void onNoDoubleClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(context, LoginActivity.class);
//                intent.putExtra("uname_", "");
//                intent.putExtra("pawd_", "");
//                setResult(type_, intent);
//                finish();
//            }
//        });
    }


    @OnClick({R.id.lins_break, R.id.getMsgCodeTv, R.id.btn_show})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_show:
                if (btnShow.isSelected()) {
                    btnShow.setSelected(false);
                    edRePwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);//设置密码不可见
                    edRePwd.setSelection(edRePwd.getText().length());//设置光标的位置到末尾
                } else {
                    btnShow.setSelected(true);
                    edRePwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码可见
                    edRePwd.setSelection(edRePwd.getText().length());//设置光标的位置到末尾
                    break;
                }
                edRePwd.setSelection(edRePwd.getText().length());//设置光标的位置到末尾
            case R.id.getMsgCodeTv: //验证码
                if (edReUserpho.getText().length() == 0) {
                    Toast.makeText(context, R.string.regoster_pho_ok_string, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!NetUtil.checkNet(context)) {
                    Toast.makeText(context, R.string.regoster_no_wifi_string, Toast.LENGTH_SHORT).show();

                    return;
                }
                if (!sending) {
                    ProgressDialogShowUtil.showProgressDialog(context, "正在请求");
                    initSDK();
                    getSMSCode();
                }
                break;
            case R.id.lins_break:
//                intent.setClass(context, LoginActivity.class);
//                intent.putExtra("uname_", "");
//                intent.putExtra("pawd_", "");
//                setResult(type_, intent);
                finish();
                break;

        }
    }

    private void timerTv() {
        myThread = new MyThread();
        myThread.start();
    }

    private void initSDK() {

        ProgressDialogShowUtil.dismisDialog();
        timerTv();

    }

    private void getSMSCode() {
        ((AlterPresenter) mPresenter).smssend(edReUserpho.getText().toString());// TODO

    }

    @Override
    public void alterRean(AlterBean alterBean) {

        if (alterBean != null) {
            int status = alterBean.getStatus();
            //修改成功
            if (status == TYPE_NORMAL) {
                SharedPreferencesUtil.deleteToken(MyApp.mApp);//删除token
                Intent intent2 = new Intent();
                intent2.setClass(context, LoginActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                finish();
            }
            Toast.makeText(context, alterBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void smssendRean(SmsSendBean smsSendBean) {

    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            sending = true;
            for (int i = 120; i >= 0; i--) {
                if (sending) {
                    final int finalI = i;
                    AlterLoginPwdActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (getmsgCodeTv != null) {
                                getmsgCodeTv.setText(finalI + "s");
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 0) {
                        AlterLoginPwdActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                sending = false;
                                if (getmsgCodeTv != null) {
                                    getmsgCodeTv.setText(R.string.regoster_code_string);
                                }
                            }
                        });
                    }
                } else {
                    break;
                }
            }
        }
    }


}
