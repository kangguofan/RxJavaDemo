package com.bawei.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.rxjavademo.http.Api;
import com.bawei.rxjavademo.http.CustomDialog;
import com.bawei.rxjavademo.http.CustomObserver;
import com.bawei.rxjavademo.http.HttpResult;
import com.bawei.rxjavademo.http.RxHelper;
import com.bawei.rxjavademo.http.bean.Joker;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<HttpResult<List<Joker>>> observable = Api.getRetrofit().requestData("");
//        observable.observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<HttpResult<List<Joker>>>() {
//                    @Override
//                    public void accept(HttpResult<List<Joker>> listHttpResult) throws Exception {
//
//                    }
//                });

//        CustomDialog c = CustomDialog.getInstance(this,null);
//        c.show();
        RxHelper.toSubscriber(observable, new CustomObserver<List<Joker>>(this) {
            @Override
            public void onSuccess(List<Joker> jokers) {
                Log.d("TAG","jokers:"+jokers.get(1).getContent());
            }
        });


    }
}
