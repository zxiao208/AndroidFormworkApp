package com.zhaoxiao.androidformworkapp.base.contract.main;

import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.RealmLikeBean;

import java.util.List;

/**
 * Created by codeest on 2016/8/23.
 */
public interface LikeContract {

    interface View extends  BaseView {

        void showContent(List<RealmLikeBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getLikeData();

        void deleteLikeData(String id);

        void changeLikeTime(String id, long time, boolean isPlus);

        boolean getLikePoint();

        void setLikePoint(boolean b);
    }
}
