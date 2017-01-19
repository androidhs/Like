package cn.huimin.like.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cn.huimin.like.MainActivity;
import cn.huimin.like.R;
import cn.huimin.like.base.BaseActivity;
import cn.huimin.like.login.presenter.LoginPresenterImpl;
import cn.huimin.like.login.view.ILoginView;


public class LoginView extends BaseActivity implements ILoginView, View.OnClickListener {
    private EditText username;
    private EditText password;
//    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

//        loginPresenter = new LoginPresenterImpl(this);
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
    }

    @Override
    public void onClearText() {

    }
    //返回请求结果
    @Override
    public void onLoginResult(Boolean result, int code) {
        if(result){
            startActivity(new Intent(context,MainActivity.class));
        }else{
            if(code==0){
                showToast("请输入账号");
            }else if(code==1){
                showToast("请输入密码");
            }else if(code==3){
                showToast("账号或密码不正确");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
//                loginPresenter.doLogin(username.getText().toString().trim(),password.getText().toString().trim());
                break;
        }
    }
}
