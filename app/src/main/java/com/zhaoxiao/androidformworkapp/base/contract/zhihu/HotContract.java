package com.zhaoxiao.androidformworkapp.base.contract.zhihu;


import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.HotListBean;

/**
 * Created by codeest on 16/8/12.
 */

public interface HotContract {

    interface View extends BaseView {

        void showContent(HotListBean hotListBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getHotData();

        void insertReadToDB(int id);

    }
}
