package com.zhaoxiao.androidformworkapp.presenter.zhihu;


import com.zhaoxiao.androidformworkapp.base.RxPresenter;
import com.zhaoxiao.androidformworkapp.base.contract.zhihu.HotContract;
import com.zhaoxiao.androidformworkapp.model.DataManager;
import com.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import com.zhaoxiao.androidformworkapp.utils.RxUtil;
import com.zhaoxiao.androidformworkapp.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by codeest on 16/8/12.
 */

public class HotPresenter extends RxPresenter<HotContract.View> implements HotContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public HotPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getHotData() {
        addSubscribe(mDataManager.fetchHotListInfo()
                .compose(RxUtil.<HotListBean>rxSchedulerHelper())
                .map(new Function<HotListBean, HotListBean>() {
                    @Override
                    public HotListBean apply(HotListBean hotListBean) {
                        List<HotListBean.RecentBean> list = hotListBean.getRecent();
                        for(HotListBean.RecentBean item : list) {
                            item.setReadState(mDataManager.queryNewsId(item.getNews_id()));
                        }
                        return hotListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<HotListBean>(mView) {
                    @Override
                    public void onNext(HotListBean hotListBean) {
                        mView.showContent(hotListBean);
                    }
                })
        );
    }

    @Override
    public void insertReadToDB(int id) {
        mDataManager.insertNewsId(id);
    }
}
