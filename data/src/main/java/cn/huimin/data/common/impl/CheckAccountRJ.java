package cn.huimin.data.common.impl;

import cn.huimin.data.common.BaseRxJava;
import cn.huimin.data.entity.AccountEntity;
import cn.huimin.data.presenter.impl.CheckAccount;
import rx.Observable;

/**
 * Created by it on 2017/1/19.
 */

public class CheckAccountRJ extends BaseRxJava {
    private AccountEntity account;
    public CheckAccountRJ(AccountEntity account){
        this.account = account;
    }

    //网络请求返回
    @Override
    protected Observable bindObservable() {
        return new CheckAccount().loginCheck(account);
    }
}
