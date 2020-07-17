package com.example.shiyuankeji.ui.activity.login;


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
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.AddUserBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.RegisterContract;
import com.example.shiyuankeji.presenter.QueryTabPresenter;
import com.example.shiyuankeji.presenter.register.RegisterPresenter;
import com.example.shiyuankeji.ui.activity.VerifyAccountActivity;
import com.example.shiyuankeji.utils.CardUtils;
import com.example.shiyuankeji.utils.NoDoubleClickListener;
import com.example.shiyuankeji.utils.SharedPreferencesUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.utils.Validator;
import com.example.shiyuankeji.widgets.verificationcode.NetUtil;
import com.example.shiyuankeji.widgets.verificationcode.ProgressDialogShowUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private static final int REQUEST_READ_PHONE_STATE = 1;
    @BindView(R.id.ed_re_userpho)
    EditText edReUserpho;
    @BindView(R.id.ed_re_pwd)
    EditText edRePwd;
    //    @BindView(R.id.lin_register)
//    LinearLayout linRegister;
    @BindView(R.id.linshow)
    LinearLayout linshows;
    @BindView(R.id.lins_break)
    ImageView linsBreak;
    @BindView(R.id.tv_pwd01)
    TextView tvPwd01;
    //    @BindView(R.id.tv_show)
//    TextView tvShow;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.getMsgCodeTv)
    TextView getmsgCodeTv;
    @BindView(R.id.re_shuru1)
    CardView cardShou;
    @BindView(R.id.btn_show)
    ImageView btnShow;
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

    @Override
    protected IBasePresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_register;
    }

    @Override
    protected void initView() {
//        CardUtils.setCardShadowColor(cardShou, getResources().getColor(R.color.newnew_bg), getResources().getColor(R.color.newnew_bg));
//        CardUtils.init();
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
                    Toast.makeText(context, "手机号、密码和验证码不能为空！", Toast.LENGTH_SHORT).show();
                    tvPwd01.setText("手机号、密码和验证码不能为空！");
                    return;
                }
                if (!TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd)) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText("请输入密码");
                    return;
                }
                if (TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd)) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText("请输入手机号");
                    return;
                }
                if (Validator.isMobile(userpho) == false) {
                    tvPwd01.setVisibility(View.VISIBLE);
                    tvPwd01.setText("请输入正确的手机号！");
                    return;
                }
                if (Validator.isPwd(pwd) == false) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, "请输入最少6位最多12位的数字加字母组合的密码", Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
                    return;
                }
                if (Validator.isMobile(userpho) == false || Validator.isPwd(pwd) == false) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, "请输入最少6位最多12位的数字加字母组合的密码", Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
                    return;
                }
                if (Validator.shuziss(pwd) == true) {
                    tvPwd01.setText("");//请输入最少6位最多12位的数字加字母组合的密码
                    Toast.makeText(context, "请输入最少6位最多12位的数字加字母组合的密码", Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
                    return;
                }


                if (!TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(edname) &&
                        Validator.isMobile(userpho) == true && Validator.isPwd(pwd) == true) {
//                    Toast.makeText(context, "走注册！", Toast.LENGTH_SHORT).show();
                    tvPwd01.setVisibility(View.GONE);
                    ((RegisterPresenter) mPresenter).registers(userpho, edname, pwd);
                }
            }
        });
        tvShow = findViewById(R.id.tv_show);
        tvShow.setOnClickListener(new NoDoubleClickListener() { //去登陆
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                intent.putExtra("uname_", "");
                intent.putExtra("pawd_", "");
                setResult(type_, intent);
                finish();
            }
        });
    }

    @Override
    protected void initData() {


    }

    @OnClick({R.id.lins_break, R.id.getMsgCodeTv,R.id.btn_show})
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
                    edRePwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码可见                }
                    edRePwd.setSelection(edRePwd.getText().length());//设置光标的位置到末尾
                    break;
                }
                edRePwd.setSelection(edRePwd.getText().length());//设置光标的位置到末尾
            case R.id.getMsgCodeTv: //验证码
                if (edReUserpho.getText().length() == 0) {
                    Toast.makeText(context, "请输入正确手机号！", Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入正确手机号！");
//                    toastUtil2.show();
                    return;
                }
                if (!NetUtil.checkNet(context)) {
                    Toast.makeText(context, "当前网络不可用,请检查网络设置！", Toast.LENGTH_SHORT).show();
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "当前网络不可用,请检查网络设置！");
//                    toastUtil2.show();
                    return;
                }
                if (!sending) {
                    ProgressDialogShowUtil.showProgressDialog(context, "正在请求");
                    initSDK();
                    getSMSCode();
                }
                break;
            case R.id.lins_break:
                intent.setClass(context, LoginActivity.class);
                intent.putExtra("uname_", "");
                intent.putExtra("pawd_", "");
                setResult(type_, intent);
                finish();
                break;
//            case R.id.tv_show: //去登陆
//                intent.setClass(context, LoginActivity.class);
//                intent.putExtra("uname_", "");
//                intent.putExtra("pawd_", "");
//                setResult(type_, intent);
//                finish();
//                break;
//            case R.id.lin_register:  //注册按钮
//                userpho = edReUserpho.getText().toString();
//                pwd = edRePwd.getText().toString();
//                edname = edName.getText().toString();//验证码
//                if (TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd)&&TextUtils.isEmpty(edname)) {
//                    Toast.makeText(context, "手机号、密码和验证码不能为空！", Toast.LENGTH_SHORT).show();
//                    tvPwd01.setText("手机号、密码和验证码不能为空！");
//                    return;
//                }
//                if (!TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd)) {
//                    tvPwd01.setVisibility(View.VISIBLE);
//                    tvPwd01.setText("请输入密码");
//                    return;
//                }
//                if (TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd)) {
//                    tvPwd01.setVisibility(View.VISIBLE);
//                    tvPwd01.setText("请输入手机号");
//                    return;
//                }
//                if (Validator.isMobile(userpho) == false) {
//                    tvPwd01.setVisibility(View.VISIBLE);
//                    tvPwd01.setText("请输入正确的手机号！");
//                    return;
//                }
//                if (Validator.isPwd(pwd) == false) {
//                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
//                    return;
//                }
//                if (Validator.isMobile(userpho) == false || Validator.isPwd(pwd) == false) {
//                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
//                    return;
//                }
//                if (Validator.shuziss(pwd)==true){
//                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
//                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
//                    toastUtil2.show();
//                    return;
//                }
//
//
//                if (!TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd) &&!TextUtils.isEmpty(edname)&&
//                        Validator.isMobile(userpho) == true && Validator.isPwd(pwd) == true) {
//                    Toast.makeText(context, "走注册！", Toast.LENGTH_SHORT).show();
//                    tvPwd01.setVisibility(View.GONE);
//                    ((RegisterPresenter) mPresenter).registers(userpho,edname, pwd);
//                }
//                break;
        }
    }

    private void timerTv() {
        myThread = new MyThread();
        myThread.start();
    }

    private void initSDK() {
//        // 初始化短信SDK
//        EventHandler eventHandler = new EventHandler() {
//            public void afterEvent(int event, int result, Object data) {
        ProgressDialogShowUtil.dismisDialog();
        timerTv();
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    //回调完成
//                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
//
//                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
//                        //获取验证码成功
//
//                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
//                        //返回支持发送验证码的国家列表
//                    }
//                } else {
//                    getErrorMsg((Throwable) data);
//                }
//            }
//        };
//        // 注册回调监听接口
//        SMSSDK.registerEventHandler(eventHandler);
    }

    private void getSMSCode() {
        ((RegisterPresenter) mPresenter).smssend(edReUserpho.getText().toString());
//        if (!TDevice.hasInternet()) {
//            AppContext.showToastShort(R.string.tip_no_internet);
//        } else {
//            String phone = setpswEt1.getText().toString();
//            if (!StringUtils.isEmpty(phone)) {
//                SMSSDK.getVerificationCode("16731316","86", phone);
//            } else {
//                AppContext.showToastShort("手机号不合法");
//            }
//        }
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            sending = true;
            for (int i = 60; i >= 0; i--) {
                if (sending) {
                    final int finalI = i;
                    RegisterActivity.this.runOnUiThread(new Runnable() {
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
                        RegisterActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                sending = false;
                                getmsgCodeTv.setText("获取验证码");
                            }
                        });
                    }
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void registerRean(AddUserBean addUserBean) {
        if (addUserBean != null) {
            int status = addUserBean.getStatus();
            if (status == 200) {
                tvShow.setVisibility(View.INVISIBLE);
                String tokens = addUserBean.getData().getToken();
                SharedPreferencesUtil.addUserToken(context, tokens);// 添加保存token TODO
                Constant.token = tokens;
//                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "注册成功！");
//                toastUtil2.show();
                Toast.makeText(context, "注册成功！", Toast.LENGTH_SHORT).show();
//                if (!tokens.equals("")){
//                Intent intent = new Intent();
//                intent.putExtra("uname_", userpho);
//                intent.putExtra("pawd_", pwd);
//                setResult(type_, intent);
//                finish();}
                Intent intent = new Intent();
                intent.setClass(context, MainActivity.class);
                startActivity(intent);
            } else {
                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, addUserBean.getMsg());
                toastUtil2.show();

                linshows.setVisibility(View.VISIBLE);
                tvPwd01.setVisibility(View.GONE);
                return;
            }
        }
    }

    @Override
    public void smssendRean(SmsSendBean smsSendBean) {
        if (smsSendBean != null) {

            String code = smsSendBean.getCode();
            if (code.equals("0")) {
//                new ToastUtil(context, R.layout.ok_toast_center_horizontal, "发送短息成功").show();
                Toast.makeText(context, "发送短息成功", Toast.LENGTH_SHORT).show();
            } else {
                return;
//                new ToastUtil(context, R.layout.toast_center_horizontal, smsSendBean.getErrorMsg()).show();
            }
        } else {
            return;
        }
    }


}
