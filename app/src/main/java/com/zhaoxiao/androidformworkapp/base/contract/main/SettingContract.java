package com.zhaoxiao.androidformworkapp.base.contract.main;


import com.zhaoxiao.androidformworkapp.base.BasePresenter;
import com.zhaoxiao.androidformworkapp.base.BaseView;
import com.zhaoxiao.androidformworkapp.model.bean.VersionBean;

/**
 * Created by codeest on 16/10/17.
 */

public interface SettingContract {

    interface View extends BaseView {

        void showUpdateDialog(VersionBean bean);

    }

    interface  Presenter extends BasePresenter<SettingContract.View> {

        void checkVersion(String currentVersion);

        void setNightModeState(boolean b);

        void setNoImageState(boolean b);

        void setAutoCacheState(boolean b);

        boolean getNightModeState();

        boolean getNoImageState();

        boolean getAutoCacheState();
    }
}
