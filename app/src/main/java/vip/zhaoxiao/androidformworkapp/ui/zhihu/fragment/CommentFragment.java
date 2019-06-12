package vip.zhaoxiao.androidformworkapp.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import vip.zhaoxiao.androidformworkapp.R;
import vip.zhaoxiao.androidformworkapp.base.RootFragment;
import vip.zhaoxiao.androidformworkapp.base.contract.zhihu.CommentContract;
import vip.zhaoxiao.androidformworkapp.model.bean.CommentBean;
import vip.zhaoxiao.androidformworkapp.presenter.zhihu.CommentPresenter;
import vip.zhaoxiao.androidformworkapp.ui.zhihu.adapter.CommentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by codeest on 16/8/18.
 */

public class CommentFragment extends RootFragment<CommentPresenter> implements CommentContract.View {

    @BindView(R.id.view_main)
    RecyclerView rvCommentList;

    CommentAdapter mAdapter;
    List<CommentBean.CommentsBean> mList;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        Bundle bundle = getArguments();
        stateLoading();
        mPresenter.getCommentData(bundle.getInt("id"),bundle.getInt("kind"));
        rvCommentList.setVisibility(View.INVISIBLE);
        mList = new ArrayList<>();
        mAdapter = new CommentAdapter(mContext,mList);
        rvCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvCommentList.setAdapter(mAdapter);
    }

    @Override
    public void showContent(CommentBean commentBean) {
        rvCommentList.setVisibility(View.VISIBLE);
        mList.clear();
        mList.addAll(commentBean.getComments());
        mAdapter.notifyDataSetChanged();
    }
}
