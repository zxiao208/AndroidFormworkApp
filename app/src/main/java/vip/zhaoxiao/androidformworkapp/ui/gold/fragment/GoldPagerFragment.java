package vip.zhaoxiao.androidformworkapp.ui.gold.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;




import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import vip.zhaoxiao.androidformworkapp.R;
import vip.zhaoxiao.androidformworkapp.base.Constants;
import vip.zhaoxiao.androidformworkapp.base.RootFragment;
import vip.zhaoxiao.androidformworkapp.base.contract.gold.GoldContract;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldListBean;
import vip.zhaoxiao.androidformworkapp.presenter.gold.GoldPresenter;
import vip.zhaoxiao.androidformworkapp.ui.gold.adapter.GoldListAdapter;
import vip.zhaoxiao.androidformworkapp.widget.GoldItemDecoration;
import vip.zhaoxiao.androidformworkapp.widget.TouchSwipeRefreshLayout;

/**
 * Created by codeest on 16/11/27.
 */

public class GoldPagerFragment extends RootFragment<GoldPresenter> implements GoldContract.View {

    @BindView(R.id.view_main)
    RecyclerView rvGoldList;
    @BindView(R.id.swipe_refresh)
    TouchSwipeRefreshLayout swipeRefresh;

    private GoldListAdapter mAdapter;
    private GoldItemDecoration mDecoration;

    private boolean isLoadingMore = false;
    private String mType;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_page;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        mType = getArguments().getString(Constants.IT_GOLD_TYPE);
        mDecoration = new GoldItemDecoration();
        mAdapter = new GoldListAdapter(mContext, new ArrayList<GoldListBean>(), getArguments().getString(Constants.IT_GOLD_TYPE_STR));
        rvGoldList.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoldList.setAdapter(mAdapter);
        rvGoldList.addItemDecoration(mDecoration);
        rvGoldList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) rvGoldList.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = rvGoldList.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {
                    if(!isLoadingMore){
                        isLoadingMore = true;
                        mPresenter.getMoreGoldData();
                    }
                }
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!mAdapter.getHotFlag()) {
                    rvGoldList.addItemDecoration(mDecoration);
                }
                mAdapter.setHotFlag(true);
                mPresenter.getGoldData(mType);
            }
        });
        mAdapter.setOnHotCloseListener(new GoldListAdapter.OnHotCloseListener() {
            @Override
            public void onClose() {
                rvGoldList.removeItemDecoration(mDecoration);
            }
        });
        stateLoading();
        mPresenter.getGoldData(mType);
    }

    @Override
    public void showContent(List<GoldListBean> goldListBean) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
        stateMain();
        mAdapter.updateData(goldListBean);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(List<GoldListBean> goldMoreListBean, int start, int end) {
        mAdapter.updateData(goldMoreListBean);
        mAdapter.notifyItemRangeInserted(start, end);
        isLoadingMore = false;
    }

    @Override
    public void stateError() {
        super.stateError();
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }
}
