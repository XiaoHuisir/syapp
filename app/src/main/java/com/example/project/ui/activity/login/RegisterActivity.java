package com.example.project.ui.activity.login;


import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.app.Constant;
import com.example.project.base.BaseActivity;
import com.example.project.bean.AddUserBean;
import com.example.project.interfaces.IBasePresenter;
import com.example.project.interfaces.contract.RegisterContract;
import com.example.project.presenter.register.RegisterPresenter;
import com.example.project.utils.ToastUtil;
import com.example.project.utils.Validator;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private static final int REQUEST_READ_PHONE_STATE = 1;
    @BindView(R.id.ed_re_userpho)
    EditText edReUserpho;
    @BindView(R.id.ed_re_pwd)
    EditText edRePwd;
    @BindView(R.id.lin_register)
    LinearLayout linRegister;
    @BindView(R.id.linshow)
    LinearLayout linshows;
    @BindView(R.id.lins_break)
    LinearLayout linsBreak;
    @BindView(R.id.tv_pwd01)
    TextView tvPwd01;
    @BindView(R.id.tv_show)
    TextView tvShow;
    private int time = 0;  //限制注册次数
    private boolean indxler = false;
    private String userpho = "";
    private String pwd = "";
    private int type_;

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
        type_ = getIntent().getIntExtra("type_", 0);
        tvPwd01.setVisibility(View.VISIBLE);
        tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.lin_register, R.id.tv_show, R.id.lins_break})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.lins_break:
                intent.setClass(context, LoginActivity.class);
                intent.putExtra("uname_", "");
                intent.putExtra("pawd_", "");
                setResult(type_, intent);
                finish();
                break;
            case R.id.tv_show: //去登陆
                intent.setClass(context, LoginActivity.class);
                intent.putExtra("uname_", "");
                intent.putExtra("pawd_", "");
                setResult(type_, intent);
                finish();
                break;
            case R.id.lin_register:
                userpho = edReUserpho.getText().toString();
                pwd = edRePwd.getText().toString();
                if (TextUtils.isEmpty(userpho) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(context, "手机号和密码不能为空！", Toast.LENGTH_SHORT).show();
                    tvPwd01.setText("手机号和密码不能为空！");
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
                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
                    toastUtil2.show();
                    return;
                }
                if (Validator.isMobile(userpho) == false || Validator.isPwd(pwd) == false) {
                    tvPwd01.setText("请输入最少6位最多12位的数字加字母组合的密码");
                    ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, "请输入最少6位最多12位的数字加字母组合的密码");
                    toastUtil2.show();
                    return;
                }


                if (!TextUtils.isEmpty(userpho) && !TextUtils.isEmpty(pwd) &&
                        Validator.isMobile(userpho) == true && Validator.isPwd(pwd) == true) {
                    Toast.makeText(context, "走注册！", Toast.LENGTH_SHORT).show();
                    tvPwd01.setVisibility(View.GONE);
                    ((RegisterPresenter) mPresenter).registers(userpho, pwd);
                }


                break;
        }
    }

    @Override
    public void registerRean(AddUserBean addUserBean) {
        if (addUserBean != null) {
            int status = addUserBean.getStatus();
            if (status == 200) {
                tvShow.setVisibility(View.INVISIBLE);
                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.ok_toast_center_horizontal, addUserBean.getData());
                toastUtil2.show();
                Intent intent = new Intent();
                intent.putExtra("uname_", userpho);
                intent.putExtra("pawd_", pwd);
                setResult(type_, intent);
                finish();
            } else {
                ToastUtil toastUtil2 = new ToastUtil(context, R.layout.toast_center_horizontal, addUserBean.getData());
                toastUtil2.show();

                linshows.setVisibility(View.VISIBLE);
                tvPwd01.setVisibility(View.GONE);
                return;
            }
        }
    }


}
