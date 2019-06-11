package com.zhaoxiao.androidformworkapp.presenter.zhihu;

import com.zhaoxiao.androidformworkapp.base.RxPresenter;
import com.zhaoxiao.androidformworkapp.base.contract.zhihu.DailyContract;
import com.zhaoxiao.androidformworkapp.component.RxBus;
import com.zhaoxiao.androidformworkapp.model.DataManager;
import com.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import com.zhaoxiao.androidformworkapp.model.bean.DailyListBean;
import com.zhaoxiao.androidformworkapp.utils.DateUtil;
import com.zhaoxiao.androidformworkapp.utils.RxUtil;
import com.zhaoxiao.androidformworkapp.widget.CommonSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 16/8/11.
 * 日期为明天时，取latest接口的数据
 * 其他日期，取before接口的数据
 */

public class DailyPresenter extends RxPresenter<DailyContract.View> implements DailyContract.Presenter{

    private DataManager mDataManager;
    private Disposable intervalSubscription;

    private static final int INTERVAL_INSTANCE = 6;

    private int topCount = 0;
    private int currentTopCount = 0;

    @Inject
    public DailyPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(DailyContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {

    }

    @Override
    public void getDailyData() {
        addSubscribe(mDataManager.fetchDailyListInfo()
                .compose(RxUtil.<DailyListBean>rxSchedulerHelper())
                .map(new Function<DailyListBean, DailyListBean>() {
                    @Override
                    public DailyListBean apply(DailyListBean dailyListBean) {
                        List<DailyListBean.StoriesBean> list = dailyListBean.getStories();
                        for(DailyListBean.StoriesBean item : list) {
                            item.setReadState(mDataManager.queryNewsId(item.getId()));
                        }
                        return dailyListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<DailyListBean>(mView) {
                    @Override
                    public void onNext(DailyListBean dailyListBean) {
                        topCount = dailyListBean.getTop_stories().size();
                        mView.showContent(dailyListBean);
                    }
                })
        );
    }

    @Override
    public void getBeforeData(String date) {
        addSubscribe(mDataManager.fetchDailyBeforeListInfo(date)
                .compose(RxUtil.<DailyBeforeListBean>rxSchedulerHelper())
                .map(new Function<DailyBeforeListBean, DailyBeforeListBean>() {
                    @Override
                    public DailyBeforeListBean apply(DailyBeforeListBean dailyBeforeListBean) {
                        List<DailyListBean.StoriesBean> list = dailyBeforeListBean.getStories();
                        for(DailyListBean.StoriesBean item : list) {
                            item.setReadState(mDataManager.queryNewsId(item.getId()));
                        }
                        return dailyBeforeListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<DailyBeforeListBean>(mView) {
                    @Override
                    public void onNext(DailyBeforeListBean dailyBeforeListBean) {
                        int year = Integer.valueOf(dailyBeforeListBean.getDate().substring(0,4));
                        int month = Integer.valueOf(dailyBeforeListBean.getDate().substring(4,6));
                        int day = Integer.valueOf(dailyBeforeListBean.getDate().substring(6,8));
                        mView.showMoreContent(String.format("%d年%d月%d日",year,month,day),dailyBeforeListBean);
                    }
                })
        );
    }

    @Override
    public void startInterval() {
        if (intervalSubscription != null && !intervalSubscription.isDisposed()) {
            return;
        }
        intervalSubscription = Flowable.interval(INTERVAL_INSTANCE, TimeUnit.SECONDS)
                .onBackpressureDrop()
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        if(currentTopCount == topCount)
                            currentTopCount = 0;
                        mView.doInterval(currentTopCount++);
                    }
                });
        addSubscribe(intervalSubscription);
    }

    @Override
    public void stopInterval() {
        if (intervalSubscription != null && !intervalSubscription.isDisposed()) {
            intervalSubscription.dispose();
        }
    }

    @Override
    public void insertReadToDB(int id) {
        mDataManager.insertNewsId(id);
    }
}
