package cn.huimin.like.base;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 胡森森 on 2017/1/18.
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
