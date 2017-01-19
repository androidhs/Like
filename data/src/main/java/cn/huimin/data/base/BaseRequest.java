package cn.huimin.data.base;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by it on 2017/1/19.
 */

public class BaseRequest {
    //获取retrofit对象，并绑定域名
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("")
                .build();
        return  retrofit;
    }
}
