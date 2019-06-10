package com.zhaoxiao.androidformworkapp.di.component;


import com.zhaoxiao.androidformworkapp.base.App;
import com.zhaoxiao.androidformworkapp.di.module.AppModule;
import com.zhaoxiao.androidformworkapp.di.module.HttpModule;
import com.zhaoxiao.androidformworkapp.model.DataManager;
import com.zhaoxiao.androidformworkapp.model.db.RealmHelper;
import com.zhaoxiao.androidformworkapp.model.http.RetrofitHelper;
import com.zhaoxiao.androidformworkapp.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
