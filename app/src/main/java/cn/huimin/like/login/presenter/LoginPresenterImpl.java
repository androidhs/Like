package cn.huimin.like.login.presenter;

import cn.huimin.like.login.model.IUser;
import cn.huimin.like.login.model.UserModel;
import cn.huimin.like.login.request.LoginRequest;
import cn.huimin.like.login.view.ILoginView;

/**
 * Created by 胡森森 on 2017/1/18.
 */
public class LoginPresenterImpl extends LoginRequest implements ILoginPresenter {
    IUser user;
    ILoginView view;
    public LoginPresenterImpl(ILoginView view){
        this.view = view;
        user = new UserModel();
    }
    //数据解析成功后填充布局
    @Override
    public void onSuccessed(String result) {
        super.onSuccessed(result);

        view.onLoginResult(true,2);
    }

    @Override
    public void onFailed(String result) {
        super.onFailed(result);
        view.onLoginResult(false,3);
    }

    @Override
    public void clear() {

    }

    //网络请求并获得返回内容
    @Override
    public void doLogin(String username, String password) {
        int result = user.checkUserValidity(username,password);
        if(result==0){
            //用户名为空
            view.onLoginResult(false,0);
        }else if(result==1){
            //密码为空
            view.onLoginResult(false,1);
        }else{
            //可以登录
            Login(username,password);
        }


    }
}
