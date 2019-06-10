package com.zhaoxiao.androidformworkapp.di.component;

import android.app.Activity;


import com.zhaoxiao.androidformworkapp.di.module.FragmentModule;
import com.zhaoxiao.androidformworkapp.di.scope.FragmentScope;
import com.zhaoxiao.androidformworkapp.ui.gank.fragment.GirlFragment;
import com.zhaoxiao.androidformworkapp.ui.gank.fragment.TechFragment;
import com.zhaoxiao.androidformworkapp.ui.gold.fragment.GoldMainFragment;
import com.zhaoxiao.androidformworkapp.ui.gold.fragment.GoldPagerFragment;
import com.zhaoxiao.androidformworkapp.ui.main.fragment.LikeFragment;
import com.zhaoxiao.androidformworkapp.ui.main.fragment.SettingFragment;
import com.zhaoxiao.androidformworkapp.ui.vtex.fragment.VtexPagerFragment;
import com.zhaoxiao.androidformworkapp.ui.wechat.fragment.WechatMainFragment;
import com.zhaoxiao.androidformworkapp.ui.zhihu.fragment.CommentFragment;
import com.zhaoxiao.androidformworkapp.ui.zhihu.fragment.DailyFragment;
import com.zhaoxiao.androidformworkapp.ui.zhihu.fragment.HotFragment;
import com.zhaoxiao.androidformworkapp.ui.zhihu.fragment.SectionFragment;
import com.zhaoxiao.androidformworkapp.ui.zhihu.fragment.ThemeFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(DailyFragment dailyFragment);

    void inject(ThemeFragment themeFragment);

    void inject(SectionFragment sectionFragment);

    void inject(HotFragment hotFragment);

    void inject(CommentFragment longCommentFragment);

    void inject(TechFragment techFragment);

    void inject(GirlFragment girlFragment);

    void inject(LikeFragment likeFragment);

    void inject(WechatMainFragment wechatMainFragment);

    void inject(SettingFragment settingFragment);

    void inject(GoldMainFragment goldMainFragment);

    void inject(GoldPagerFragment goldPagerFragment);

    void inject(VtexPagerFragment vtexPagerFragment);
}
