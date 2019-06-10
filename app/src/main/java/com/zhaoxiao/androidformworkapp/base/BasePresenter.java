package com.zhaoxiao.androidformworkapp.base;

public abstract interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
