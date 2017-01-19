package cn.huimin.data.common;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by it on 2017/1/19.
 */

public abstract class BaseRxJava {
    //本地
    protected Subscription subscription = Subscriptions.empty();

    //构建抽象方法，绑定Observable
    protected abstract Observable bindObservable();

    //控制被观察者在子线程执行，观察者在主线程中执行
    public void execute(Subscriber subscriber){
        subscription = this.bindObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //取消订阅
    public void unsubscribe(){
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }
}
