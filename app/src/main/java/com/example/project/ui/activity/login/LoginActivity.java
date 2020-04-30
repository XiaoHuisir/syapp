package com.example.project.ui.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.app.MyApp;
import com.example.project.base.BaseActivity;
import com.example.project.bean.LoginBean;
import com.example.project.bean.LoginsBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.LoginContract;
import com.example.project.interfaces.contract.LoginsContract;
import com.example.project.presenter.login.LoginPresenter;
import com.example.project.presenter.login.LoginsPresenter;
import com.example.project.utils.SharedPreferencesUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//http://198.168.124.14:8080/user_login
public class LoginActivity extends BaseActivity implements LoginsContract.Views {

    private static final String TAG = "t";
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pw)
    EditText edPw;
    @BindView(R.id.re)
    RelativeLayout re;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_show)
    Button btnShow;
    @BindView(R.id.wxlogin)
    LinearLayout wxlogin;
    private String mobile;
    private String password;
    private int code;
    IWXAPI api; //微信api

//TODO

//    @Override
//    protected IBasePresenter getPresenter() {
//        return new LoginPresenter();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //判断是否有登录过
        String username = SharedPreferencesUtil.getUserName(MyApp.mApp);
        String pw = SharedPreferencesUtil.getPw(MyApp.mApp);
        if (!TextUtils.isEmpty(username)) {
            edPhone.setText(username);
            if (!TextUtils.isEmpty(pw)) {
                edPw.setText(pw);
            }
        }
        edPhone.setText("sy001");
        edPw.setText("123456");
//        edPhone.setFocusable(false);
//        edPw.setFocusable(false);

//        edPw.setSelection(edPw.getText().length());
        edPw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);//设置密码不可见

    }

    @Override
    protected IBasePresenter getPresenter() {
        return new LoginsPresenter();
    }


    @OnClick({R.id.btn_login, R.id.btn_show, R.id.ed_pw, R.id.ed_phone, R.id.wxlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wxlogin://微信登录
                loginWX();
                Toast.makeText(context, "欢迎使用微信三方登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ed_pw:

//                edPhone.setInputType(InputType.TYPE_CLASS_NUMBER);
//                edPhone.setInputType(EditorInfo.TYPE_CLASS_PHONE);//设置数字键盘显示
                break;
            case R.id.btn_login:
                mobile = edPhone.getText().toString();
                password = edPw.getText().toString();
                closeKeyboard();
                closeKeyboardedPhone();

//                edPw.setInputType(EditorInfo.TYPE_CLASS_PHONE);//设置数字键盘显示
                Constant.mobiles = mobile;
                Constant.passwords = password;
                if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                    if (!TextUtils.isEmpty(mobile) && TextUtils.isEmpty(password)) {
                        Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(password)) {
                        Toast.makeText(context, "请输入用户名", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
//                if (mobile.equals("123") && password.equals("123")) {
//                    context.startActivity(new Intent(context, MainActivity.class));
                ((LoginsPresenter) mPresenter).logins(mobile, password);
//     TODO
//
//      ((LoginPresenter) mPresenter).login(mobile, password);

                break;
            case R.id.btn_show:

                if (btnShow.isSelected()) {
                    btnShow.setSelected(false);
                    edPw.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);//设置密码不可见
                    edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾
                } else {
                    btnShow.setSelected(true);
                    edPw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//设置密码可见                }
                    edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾
                    break;
                }


                edPw.setSelection(edPw.getText().length());//设置光标的位置到末尾

        }
    }

    private void loginWX() {

        api = WXAPIFactory.createWXAPI(this, "wxf03d722bd25a1519", true);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wx_login_duzun";
        api.sendReq(req);
    }

    //TODO
//    @Override
//    public void loginReturn(LoginBean result) {
//        code = result.getCode();
//        if (code == 10000) {
//            SharedPreferencesUtil.addUserToken(context, result.getData().getUserToken());
//            Constant.token = result.getData().getUserToken();
//            Intent intent = new Intent();
//            intent.setClass(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        } else {
//            Toast.makeText(context, result.getMsg(), Toast.LENGTH_SHORT).show();
//        }
//    }
    @Override
    public void loginsReturn(LoginsBean result) {
        LoginsBean.DataBean data = result.getData();
        String message = result.getMsg();
        int code = Integer.parseInt(message);
        if (code==200) {
            SharedPreferencesUtil.addUserToken(context, data.getToken());// 添加保存token TODO ？？？
            Constant.token = result.getData().getToken();
            Log.i(TAG, "loginsReturn: "+result.getData().getToken());
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
        }
//        data.errorcode
//        Toast.makeText(context, "" + user_name, Toast.LENGTH_SHORT).show();
////        SharedPreferencesUtil.addUserToken(context,);// 添加保存token TODO ？？？

    }

    //关闭指定文本输入框的软键盘
    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edPw.getWindowToken(), 0);
    }

    private void closeKeyboardedPhone() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edPhone.getWindowToken(), 0);
    }


}
