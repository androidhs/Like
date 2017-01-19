package cn.huimin.data.common;


import org.json.JSONException;

import rx.Subscriber;

/**
 * Created by it on 2017/1/19.
 */

public abstract class FeedSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof Exception || throwable instanceof JSONException) {
            onEmpty();
        } else {
            onFailed(throwable);
        }
    }

    @Override
    public void onNext(T o) {
        onSuccess(o);
    }

    public void onFailed(Throwable throwable) {
    }

    public void onEmpty() {
    }

    public void onSuccess(T data) {
    }

}
