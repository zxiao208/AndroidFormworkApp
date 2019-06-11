package com.zhaoxiao.androidformworkapp.base.contract.zhihu;

import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import com.zhaoxiao.androidformworkapp.model.bean.DailyListBean;

/**
 * Created by codeest on 16/8/11.
 */

public interface DailyContract {

    interface View extends BaseView {

        void showContent(DailyListBean info);

        void showMoreContent(String date, DailyBeforeListBean info);

        void doInterval(int currentCount);
    }

    interface Presenter extends BasePresenter<View> {

        void getDailyData();

        void getBeforeData(String date);

        void startInterval();

        void stopInterval();

        void insertReadToDB(int id);
    }
}
