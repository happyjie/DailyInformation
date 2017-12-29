package com.story.happyjie.dailyinformation.helper;

import android.content.Context;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by llj on 2017/12/29.
 */

public class ObservableHelper {
    public static <T>  void simpleEvent(Context context, T object, simpleEventCallBack<T> callBack){
        Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onNext(object);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(T result) {
                        callBack.doSomething(result);
                    }
                });
    }

    public interface simpleEventCallBack<T>{
        void doSomething(T result);
    }

}
