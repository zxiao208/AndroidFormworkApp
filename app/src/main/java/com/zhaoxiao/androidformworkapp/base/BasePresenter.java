package com.zhaoxiao.androidformworkapp.base;

public abstract class BasePresenter<V extends BaseView> {
    private V loginView;

    public V getLoginView() {
        return loginView;
    }

    public void attachView(V loginView){
        this.loginView = loginView;
    }

    public void detachView(){
        this.loginView = null;
    }
}
