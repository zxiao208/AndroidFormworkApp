package com.zhaoxiao.androidformworkapp.base.contract.gank;

import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by codeest on 16/8/19.
 */

public interface GirlContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> list);

        void showMoreContent(List<GankItemBean> list);
    }

    interface Presenter extends BasePresenter<View> {

        void getGirlData();

        void getMoreGirlData();

    }
}
