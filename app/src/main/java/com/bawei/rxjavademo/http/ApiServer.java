package com.bawei.rxjavademo.http;

import com.bawei.rxjavademo.http.bean.Joker;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public interface ApiServer {
    @GET("randJoke.php?key=26e9ed96a3ea69201844871a9ef4acec")
    Observable<HttpResult<List<Joker>>> requestData(@Query("type") String type);
}
