package cn.huimin.like.login.request;

import cn.huimin.like.login.entity.Account;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 胡森森 on 2017/1/18.
 */
public interface LoginService {
    @GET("")    //请求连接的后缀
    Call<Account> login(@Query("username")String username,@Query("password")String password);
}
