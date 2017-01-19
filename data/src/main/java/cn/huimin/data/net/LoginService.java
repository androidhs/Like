package cn.huimin.data.net;

import cn.huimin.data.entity.AccountEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by it on 2017/1/19.
 */

public interface LoginService {
    @GET("")    //请求连接的后缀
    Call<AccountEntity> login(@Query("username")String username, @Query("password")String password);
}
