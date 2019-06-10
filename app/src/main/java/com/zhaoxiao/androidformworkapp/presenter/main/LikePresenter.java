package com.zhaoxiao.androidformworkapp.presenter.main;

import com.zhaoxiao.androidformworkapp.base.RxPresenter;
import com.zhaoxiao.androidformworkapp.base.contract.main.LikeContract;
import com.zhaoxiao.androidformworkapp.model.DataManager;

import javax.inject.Inject;

/**
 * Created by codeest on 2016/8/23.
 */
public class LikePresenter extends RxPresenter<LikeContract.View> implements LikeContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public LikePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getLikeData() {
        mView.showContent(mDataManager.getLikeList());
    }

    @Override
    public void deleteLikeData(String id) {
        mDataManager.deleteLikeBean(id);
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mDataManager.changeLikeTime(id,time,isPlus);
    }

    @Override
    public boolean getLikePoint() {
        return mDataManager.getLikePoint();
    }

    @Override
    public void setLikePoint(boolean b) {
        mDataManager.setLikePoint(b);
    }
}
