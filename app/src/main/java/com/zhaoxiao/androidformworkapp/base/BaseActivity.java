package com.zhaoxiao.androidformworkapp.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends SimpleActivity {
    private P presenter;
    private V view;

    public P getPresenter() {
        return presenter;
    }

    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("presenter，空指针异常...");
        }
        view = createView();
        if (view == null){
            throw new NullPointerException("view，空指针异常...");
        }
        presenter.attachView(view);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public abstract P createPresenter();
    public abstract V createView();

    protected abstract int getLayout();

    protected abstract void initEventAndData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
