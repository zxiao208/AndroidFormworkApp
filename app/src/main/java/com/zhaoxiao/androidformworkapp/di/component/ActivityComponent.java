package com.zhaoxiao.androidformworkapp.di.component;

import android.app.Activity;


import com.zhaoxiao.androidformworkapp.di.module.ActivityModule;
import com.zhaoxiao.androidformworkapp.di.scope.ActivityScope;
import com.zhaoxiao.androidformworkapp.ui.main.activity.MainActivity;
import com.zhaoxiao.androidformworkapp.ui.main.activity.WelcomeActivity;
import com.zhaoxiao.androidformworkapp.ui.vtex.activity.NodeListActivity;
import com.zhaoxiao.androidformworkapp.ui.vtex.activity.RepliesActivity;
import com.zhaoxiao.androidformworkapp.ui.zhihu.activity.SectionActivity;
import com.zhaoxiao.androidformworkapp.ui.zhihu.activity.ThemeActivity;
import com.zhaoxiao.androidformworkapp.ui.zhihu.activity.ZhihuDetailActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

    void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);

    void inject(RepliesActivity repliesActivity);

    void inject(NodeListActivity nodeListActivity);
}
