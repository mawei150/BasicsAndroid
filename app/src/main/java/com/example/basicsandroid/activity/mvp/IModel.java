package com.example.basicsandroid.activity.mvp;

import rx.Subscription;

/**
 * @author MW
 * @date 2021/3/28
 * <p>
 * 描述： 由于项目使用Rxjava+Retrofit2.0+Okhttp，所以我在model层对Rxjava进行绑定和解绑，防止内存泄漏
 */

public interface IModel {
    void unSubscribe();

    void addSubscribe(Subscription subscription);

}
