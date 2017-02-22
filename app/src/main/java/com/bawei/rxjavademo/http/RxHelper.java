package com.bawei.rxjavademo.http;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public class RxHelper {

    public static <T>void toSubscriber(Observable<HttpResult<T>> observable, Observer<T> observer){
        observable
                .subscribeOn(Schedulers.io())
                .map(new Function<HttpResult<T>, T>() {
                    @Override
                    public T apply(HttpResult<T> httpResult) throws Exception {
                        if(httpResult.getError_code() != 0){
                            throw new ApiException(httpResult.getError_code());
                        }
                        return httpResult.getResult();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public static <T>void toSubscriber1(Observable<HttpResult<T>> observable, Observer<T> observer){
        observable
                .subscribeOn(Schedulers.io())
                .map(new Function<HttpResult<T>, T>() {
                    @Override
                    public T apply(HttpResult<T> httpResult) throws Exception {
                        if(httpResult.getError_code() != 0){
                            throw new ApiException(httpResult.getError_code());
                        }
                        return httpResult.getResult();
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(observer);

    }

}
