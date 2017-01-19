package cn.huimin.data.presenter;



import cn.huimin.data.entity.AccountEntity;
import rx.Observable;

/**
 * Created by it on 2017/1/19.
 */

public interface ICheckAccount {


    //检查登录信息的合法性
    Observable loginCheck(AccountEntity account);
}
