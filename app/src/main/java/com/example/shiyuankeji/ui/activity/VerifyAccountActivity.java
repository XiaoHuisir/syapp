package com.example.shiyuankeji.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiyuankeji.R;
import com.example.shiyuankeji.app.Constant;
import com.example.shiyuankeji.base.BaseActivity;
import com.example.shiyuankeji.bean.QueryTabBean;
import com.example.shiyuankeji.bean.SmsSendBean;
import com.example.shiyuankeji.interfaces.IBasePresenter;
import com.example.shiyuankeji.interfaces.contract.QueryTabContract;
import com.example.shiyuankeji.presenter.QueryTabPresenter;
import com.example.shiyuankeji.widgets.verificationcode.NetUtil;
import com.example.shiyuankeji.utils.ToastUtil;
import com.example.shiyuankeji.widgets.verificationcode.ProgressDialogShowUtil;
import com.google.zxing.common.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class VerifyAccountActivity extends BaseActivity implements QueryTabContract.View {
    @BindView(R.id.ed_username)
    EditText edUsername;
    @BindView(R.id.ed_pho)
    EditText edPho;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.linear_validation)
    LinearLayout linearValidation;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.getMsgCodeTv)
    TextView getmsgCodeTv;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MyThread myThread;
    public static boolean noDestory = true;
    public static boolean sending = false;
    private String pho="";

    @Override
    protected IBasePresenter getPresenter() {
        return new QueryTabPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activit_verify_account;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.linear_validation, R.id.tv_service, R.id.getMsgCodeTv})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.linear_validation:  //校验
                String username = edUsername.getText().toString();
                pho = edPho.getText().toString();
                String name = edName.getText().toString();
              if (pho.length()<=0&&name.length()<=0){
                  return;
              }
//                ((QueryTabPresenter) mPresenter).quertytab(username, pho, name); //old 校验
                ((QueryTabPresenter) mPresenter).isverifycode(pho, name);
                break;
            case R.id.tv_service:  //客服
                intent.setClass(context, WebCallCenterActivity.class);
                startActivity(intent);
                break;
            case R.id.getMsgCodeTv:  //验证码
                if (edPho.getText().length() == 0) {
                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入正确手机号！");
                    toastUtil2.show();
                    return;
                }
                if (!NetUtil.checkNet(context)) {
                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "当前网络不可用,请检查网络设置！");
                    toastUtil2.show();
                    return;
                }
                if (!sending) {
                    ProgressDialogShowUtil.showProgressDialog(context, "正在请求");
                    initSDK();
                    getSMSCode();
                }
                break;
        }
    }

    private void timerTv() {
        myThread = new MyThread();
        myThread.start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            sending = true;
            for (int i = 60; i >= 0; i--) {
                if (sending) {
                    final int finalI = i;
                    VerifyAccountActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getmsgCodeTv.setText(finalI + "s");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 0) {
                        VerifyAccountActivity.this.runOnUiThread(new Runnable() {
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
        ((QueryTabPresenter) mPresenter).smssend(edPho.getText().toString());
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

    @Override
    public void querytabRean(QueryTabBean queryTabBean) { //old
//        if (queryTabBean != null) {
//            int status = queryTabBean.getStatus();
//            if (status == 200) { //匹配成功 去修改密码
//                Intent intent = new Intent();
//                Constant.DYNAMIC_PRICE = 0;
//                intent.setClass(context, UpdatePasswrdActivity.class);
//                startActivity(intent);
//            } else { //匹配不成功找客服(匹配不成功1次提示找客服 此处记录状态 未实现。。。。)
//                new AlertDialog.Builder(this).setTitle("账号验证失败！请重新填写，或找客服")
//                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent();
//                                intent.setClass(context, WebCallCenterActivity.class);
//                                startActivity(intent);
//                            }
//                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create().show();
//            }
//        }
    }

    @Override
    public void smssendRean(SmsSendBean smsSendBean) { //获取验证码
        if (smsSendBean != null) {

            String code = smsSendBean.getCode();
            if (code.equals("0")) {
//                new ToastUtil(context, R.layout.ok_toast_center_horizontal, "发送短息成功").show();
                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, "发送短息成功！");
                toastUtil2.show();
            } else {
                return;
//                new ToastUtil(context, R.layout.toast_center_horizontal, smsSendBean.getErrorMsg()).show();
            }
        }else {
            return;
        }
    }

    @Override
    public void isVerifyCode(SmsSendBean smsSendBean) {
        if (smsSendBean != null) {

            if (smsSendBean.getStatus()==200) {
                new ToastUtil(context, R.layout.toast_center_horizontal, smsSendBean.getMsg()).show();
                Intent intent = new Intent();
//                Constant.DYNAMIC_PRICE = 0;
                intent.setClass(context, UpdatePasswrdActivity.class);
                intent.putExtra("pho_",pho);
                startActivity(intent);
            } else {
                new ToastUtil(context, R.layout.toast_center_horizontal, smsSendBean.getMsg()).show();
                new AlertDialog.Builder(this).setTitle("账号验证失败！请重新填写，或找客服")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setClass(context, WebCallCenterActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
            }
        }
    }
}
