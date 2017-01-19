package cn.huimin.like.login.presenter;

import android.text.TextUtils;

import cn.huimin.data.common.FeedSubscriber;
import cn.huimin.data.common.impl.CheckAccountRJ;
import cn.huimin.data.entity.AccountEntity;
import cn.huimin.like.login.view.ILoginView;

/**
 * Created by 胡森森 on 2017/1/18.
 */
public class LoginPresenterImpl {
//    IUser user;
    ILoginView view;
    public LoginPresenterImpl(ILoginView view){
        this.view = view;
//        user = new UserModel();
    }
    //被activity调用，实现请求数据，返回结果的作用
    public void checkAccount(AccountEntity account){
        CheckAccountRJ checkInfo = new CheckAccountRJ(account);
        checkInfo.execute(new FeedSubscriber<AccountEntity>(){
            @Override
            public void onFailed(Throwable throwable) {
                super.onFailed(throwable);
            }

            @Override
            public void onEmpty() {
                super.onEmpty();
            }

            @Override
            public void onSuccess(AccountEntity data) {
                if(null!=data){
                    //更新ui操作
                }
            }
        });
    }
}
