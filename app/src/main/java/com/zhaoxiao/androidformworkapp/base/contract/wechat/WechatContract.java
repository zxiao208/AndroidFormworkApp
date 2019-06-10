package com.zhaoxiao.androidformworkapp.base.contract.wechat;

import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.WXItemBean;

import java.util.List;

/**
 * Created by codeest on 16/8/29.
 */

public interface WechatContract {

    interface View extends BaseView {

        void showContent(List<WXItemBean> mList);

        void showMoreContent(List<WXItemBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getWechatData();

        void getMoreWechatData();
    }
}
