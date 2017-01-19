package cn.huimin.data.presenter.impl;



import android.text.TextUtils;

import cn.huimin.data.base.BaseRequest;
import cn.huimin.data.entity.AccountEntity;
import cn.huimin.data.net.LoginService;
import cn.huimin.data.presenter.ICheckAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
/**
 * Created by it on 2017/1/19.
 */

public class CheckAccount implements ICheckAccount {
    private Call<AccountEntity> mCall;
    private LoginService loginService;

    //初始化 请求接口
    public CheckAccount(){
        loginService = BaseRequest.getRetrofit().create(LoginService.class);
    }
    @Override
    public Observable loginCheck(final AccountEntity account) {
        //中括号中是返回的实体类型
        Observable<AccountEntity> observable = Observable.create(new Observable.OnSubscribe<AccountEntity>(){

            @Override
            public void call(final Subscriber<? super AccountEntity> subscriber) {
                mCall = loginService.login(account.getUsername(),account.getPassword());
                mCall.enqueue(new Callback<AccountEntity>() {

                    //成功的回调
                    @Override
                    public void onResponse(Call<AccountEntity> call, Response<AccountEntity> response) {
                        if(!TextUtils.isEmpty(response.toString())){
                            if(response.isSuccessful()){
                                //处理返回值，json转换为实体
//                                subscriber.onNext();
                            }
                        }
                    }
                    //失败的回调
                    @Override
                    public void onFailure(Call<AccountEntity> call, Throwable t) {
                        //处理失败的信息
                    }
                });

            }
        });

        return observable;
    }
}
