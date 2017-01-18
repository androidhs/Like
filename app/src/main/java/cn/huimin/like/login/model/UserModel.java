package cn.huimin.like.login.model;

import android.text.TextUtils;

/**
 * Created by 胡森森 on 2017/1/18.
 */
public class UserModel implements IUser {
//    private String username;
//    private String psw;

    public UserModel(){

    }
//    //参数是返回的内容
//    public UserModel(String username,String psw){
//        this.username = username;
//        this.psw = psw;
//    }


    @Override
    public int checkUserValidity(String username, String psw) {
        if(TextUtils.isEmpty(username)){
            return 0;
        }
        if(TextUtils.isEmpty(psw)){
            return 1;
        }

        return 2;
    }
}
