package com.bawei.rxjavademo.http;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public class Api {

    public static ApiServer getRetrofit(){
        return RetrofitInstance.apiserver;
    }

    static class RetrofitInstance{
         private static ApiServer apiserver = new Retrofit.Builder()
                 .baseUrl("http://v.juhe.cn/joke/")
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
                 .create(ApiServer.class);

    }
}
