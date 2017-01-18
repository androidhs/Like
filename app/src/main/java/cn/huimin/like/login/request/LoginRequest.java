package cn.huimin.like.login.request;

import android.text.TextUtils;

import cn.huimin.like.base.BaseRequest;
import cn.huimin.like.login.entity.Account;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 胡森森 on 2017/1/18.
 */
public class LoginRequest {
    private Call<Account> mCall;
    private LoginService mLoginService;

    public void onSuccessed(String result){

    }

    public void onFailed(String result){

    }
    public LoginRequest(){
        init();
    }

    private void init() {
        mLoginService = BaseRequest.getRetrofit().create(LoginService.class);
    }

    protected void Login(String username,String password){
        mCall = mLoginService.login(username,password);
        mCall.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(!TextUtils.isEmpty(response.toString())){
                    if(response.isSuccessful()){
                        //获得返回值
                        onSuccessed(response.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                //请求失败
                onFailed(t.toString());
            }
        });
    }
}
