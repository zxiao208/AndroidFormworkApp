package com.zhaoxiao.androidformworkapp.ui.vtex.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.zhaoxiao.androidformworkapp.base.Constants;
import com.zhaoxiao.androidformworkapp.base.RootActivity;
import com.zhaoxiao.androidformworkapp.base.contract.vtex.NodeContract;
import com.zhaoxiao.androidformworkapp.model.bean.NodeBean;
import com.zhaoxiao.androidformworkapp.model.bean.NodeListBean;
import com.zhaoxiao.androidformworkapp.presenter.vtex.NodePresenter;
import com.zhaoxiao.androidformworkapp.ui.vtex.adapter.NodeListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import vip.zhaoxiao.androidformworkapp.androidformworkapp.R;

/**
 * Created by codeest on 16/12/19.
 */

public class NodeListActivity extends RootActivity<NodePresenter> implements NodeContract.View {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.view_main)
    RecyclerView rvContent;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private NodeListAdapter mAdapter;
    private String nodeName;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_replies;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        nodeName = getIntent().getStringExtra(Constants.IT_VTEX_NODE_NAME);
        setToolBar(toolBar, nodeName);
        mAdapter = new NodeListAdapter(mContext, new ArrayList<NodeListBean>());
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        rvContent.setAdapter(mAdapter);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getContent(nodeName);
            }
        });
        stateLoading();
        mPresenter.getContent(nodeName);
        mPresenter.getTopInfo(nodeName);
    }

    @Override
    public void stateError() {
        super.stateError();
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void showContent(List<NodeListBean> mList) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
        stateMain();
        mAdapter.setContentData(mList);
    }

    @Override
    public void showTopInfo(NodeBean mTopInfo) {
        mAdapter.setTopData(mTopInfo);
    }
}
