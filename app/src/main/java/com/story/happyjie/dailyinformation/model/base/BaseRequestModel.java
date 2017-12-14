package com.story.happyjie.dailyinformation.model.base;

import com.orhanobut.logger.Logger;
import com.story.happyjie.dailyinformation.api.ApiService;
import com.story.happyjie.dailyinformation.http.HttpUtils;
import com.story.happyjie.dailyinformation.http.RequestCallBack;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by llj on 2017/12/13.
 */

public abstract class BaseRequestModel {

    protected  <T> void request(Observable<T> observable, RequestCallBack<T> callBack) {
        Subscription subscription = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e("onError", e);
                        callBack.onError(e);
                    }

                    @Override
                    public void onNext(T t) {
                        Logger.d("onNext()");
                        callBack.onSuccess(t);
                    }
                });
        callBack.returnSubscription(subscription);
    }
}
