package com.zhaoxiao.androidformworkapp.base.contract.zhihu;
import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.SectionListBean;

/**
 * Created by codeest on 16/8/12.
 */

public interface SectionContract {

    interface View extends BaseView {

        void showContent(SectionListBean sectionListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getSectionData();
    }
}
