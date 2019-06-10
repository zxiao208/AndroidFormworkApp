package com.zhaoxiao.androidformworkapp.ui.gold.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;


import com.zhaoxiao.androidformworkapp.base.Constants;
import com.zhaoxiao.androidformworkapp.base.SimpleActivity;
import com.zhaoxiao.androidformworkapp.component.RxBus;
import com.zhaoxiao.androidformworkapp.model.bean.GoldManagerBean;
import com.zhaoxiao.androidformworkapp.model.bean.GoldManagerItemBean;
import com.zhaoxiao.androidformworkapp.ui.gold.adapter.GoldManagerAdapter;
import com.zhaoxiao.androidformworkapp.widget.DefaultItemTouchHelpCallback;

import java.util.Collections;

import butterknife.BindView;
import io.realm.RealmList;
import vip.zhaoxiao.androidformworkapp.androidformworkapp.R;

/**
 * Created by codeest on 16/11/27.
 */

public class GoldManagerActivity extends SimpleActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv_gold_manager_list)
    RecyclerView rvGoldManagerList;

    RealmList<GoldManagerItemBean> mList;
    GoldManagerAdapter mAdapter;
    DefaultItemTouchHelpCallback mCallback;

    @Override
    protected int getLayout() {
        return R.layout.activity_gold_manager;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(toolBar, "首页特别展示");
        mList = ((GoldManagerBean) getIntent().getParcelableExtra(Constants.IT_GOLD_MANAGER)).getManagerList();
        mAdapter = new GoldManagerAdapter(mContext, mList);
        rvGoldManagerList.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoldManagerList.setAdapter(mAdapter);
        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mList != null) {
                    Collections.swap(mList, srcPosition, targetPosition);
                    mAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(rvGoldManagerList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getDefault().post(new GoldManagerBean(mList));
    }
}
