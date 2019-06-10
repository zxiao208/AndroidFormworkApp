package com.zhaoxiao.androidformworkapp.base.contract.vtex;

import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.TopicListBean;

import java.util.List;

/**
 * Created by codeest on 16/12/23.
 */

public interface VtexContract {

    interface View extends BaseView {

        void showContent(List<TopicListBean> mList);

    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String type);

    }
}
