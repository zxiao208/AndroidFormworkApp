package com.zhaoxiao.androidformworkapp.base.contract.zhihu;


import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.CommentBean;

/**
 * Created by codeest on 16/8/18.
 */

public interface CommentContract {

    interface View extends BaseView {

        void showContent(CommentBean commentBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getCommentData(int id, int commentKind);

    }
}
