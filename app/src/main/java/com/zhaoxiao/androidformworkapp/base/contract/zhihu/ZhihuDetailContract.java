package com.zhaoxiao.androidformworkapp.base.contract.zhihu;


import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.DetailExtraBean;
import com.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;

/**
 * Created by codeest on 16/8/13.
 */

public interface ZhihuDetailContract {

    interface View extends BaseView {

        void showContent(ZhihuDetailBean zhihuDetailBean);

        void showExtraInfo(DetailExtraBean detailExtraBean);

        void setLikeButtonState(boolean isLiked);
    }

    interface  Presenter extends BasePresenter<View> {

        void getDetailData(int id);

        void getExtraData(int id);

        void insertLikeData();

        void deleteLikeData();

        void queryLikeData(int id);

        boolean getNoImageState();

        boolean getAutoCacheState();
    }
}
