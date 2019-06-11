package com.zhaoxiao.androidformworkapp.presenter.zhihu;


import com.zhaoxiao.androidformworkapp.base.RxPresenter;
import com.zhaoxiao.androidformworkapp.base.contract.zhihu.ThemeContract;
import com.zhaoxiao.androidformworkapp.model.DataManager;
import com.zhaoxiao.androidformworkapp.model.bean.ThemeListBean;
import com.zhaoxiao.androidformworkapp.utils.RxUtil;
import com.zhaoxiao.androidformworkapp.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/12.
 */

public class ThemePresenter extends RxPresenter<ThemeContract.View> implements ThemeContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public ThemePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getThemeData() {
        mDataManager.fetchDailyThemeListInfo()
                .compose(RxUtil.<ThemeListBean>rxSchedulerHelper())
                .subscribe(new CommonSubscriber<ThemeListBean>(mView) {
                    @Override
                    public void onNext(ThemeListBean themeListBean) {
                        mView.showContent(themeListBean);
                    }
                });
    }
}
