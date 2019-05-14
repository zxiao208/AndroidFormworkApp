package com.zhaoxiao.androidformworkapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vip.zhaoxiao.androidformworkapp.androidformworkapp.R;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {
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
        //activity专场动画
//        if (toggleOverridePendingTransition()) {
//            switch (getOverridePendingTransitionMode()) {
//                case LEFT:
//                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
//                    break;
//                case RIGHT:
//                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
//                    break;
//                case TOP:
//                    overridePendingTransition(R.anim.top_in, R.anim.top_out);
//                    break;
//                case BOTTOM:
//                    overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
//                    break;
//                case SCALE:
//                    overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
//                    break;
//                case FADE:
//                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                    break;
//            }
//        }
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

//    protected abstract boolean toggleOverridePendingTransition();

//    protected abstract TransitionMode getOverridePendingTransitionMode();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
