package com.example.basicsandroid.activity.mvp;

/**
 * @author MW
 * @date 2021/3/28
 * <p>
 * 描述：一般情况下，做数据请求都有显示加载框、请求成功、请求失败等操作，
 * 我们把这些共有的功能封装到IView中。
 */

public interface IView {

    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void dismissLoading();

    /**
     * 网络请求失败
     *
     * @param ex   异常信息
     * @param code 错误码
     * @param msg  错误信息
     */
    void onFail(Throwable ex, String code, String msg);

    /**
     * 网络       错误
     */
    void onNetError();

}
