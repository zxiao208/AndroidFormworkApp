package vip.zhaoxiao.androidformworkapp.ui.vtex.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vip.zhaoxiao.androidformworkapp.R;
import vip.zhaoxiao.androidformworkapp.component.ImageLoader;
import vip.zhaoxiao.androidformworkapp.model.bean.NodeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.RepliesListBean;
import vip.zhaoxiao.androidformworkapp.presenter.vtex.VtexPresenter;
import vip.zhaoxiao.androidformworkapp.utils.DateUtil;
import vip.zhaoxiao.androidformworkapp.widget.SquareImageView;

/**
 * Created by codeest on 16/12/19.
 */

public class RepliesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<RepliesListBean> mList;
    private NodeListBean mTopBean;

    public RepliesAdapter(Context context, List<RepliesListBean> mList, NodeListBean mTopBean) {
        this.mContext = context;
        this.mList = mList;
        this.mTopBean = mTopBean;
        inflater = LayoutInflater.from(mContext);
    }

    public enum ITEM_TYPE {
        ITEM_TOP,           //作者发言
        ITEM_CONTENT,       //回复
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.ITEM_TOP.ordinal();
        }
        return ITEM_TYPE.ITEM_CONTENT.ordinal();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TOP.ordinal()) {
            return new TopViewHolder(inflater.inflate(R.layout.item_replies_top, parent, false));
        }
        return new ViewHolder(inflater.inflate(R.layout.item_replies, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopViewHolder) {
            TopViewHolder topHolder = ((TopViewHolder) holder);
            if (mTopBean == null) {
                return;
            }
            ImageLoader.load(mContext, VtexPresenter.parseImg(mTopBean.getMember().getavatar_normal()), topHolder.ivRepliesTopFace);
            topHolder.tvRepliesTopName.setText(mTopBean.getMember().getUsername());
            topHolder.tvRepliesTopTitle.setText(mTopBean.getTitle());
            topHolder.tvRepliesTopNum.setText(String.format("%s,   共%s条回复", DateUtil.formatTime2String(mTopBean.getCreated()), mTopBean.getReplies()));
        } else {
            ViewHolder contentHolder = ((ViewHolder) holder);
            RepliesListBean bean = mList.get(position - 1);
            if (bean == null)
                return;
            ImageLoader.load(mContext, VtexPresenter.parseImg(bean.getMember().getavatar_normal()), contentHolder.ivRepliesFace);
            contentHolder.tvRepliesName.setText(bean.getMember().getUsername());
            contentHolder.tvRepliesTips.setText(String.format("%d楼 %s", position, DateUtil.formatTime2String(bean.getCreated())));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_replies_top_title)
        TextView tvRepliesTopTitle;
        @BindView(R.id.iv_replies_top_face)
        SquareImageView ivRepliesTopFace;
        @BindView(R.id.tv_replies_top_name)
        TextView tvRepliesTopName;
        @BindView(R.id.tv_replies_top_num)
        TextView tvRepliesTopNum;


        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_replies_face)
        SquareImageView ivRepliesFace;
        @BindView(R.id.tv_replies_name)
        TextView tvRepliesName;
        @BindView(R.id.tv_replies_tips)
        TextView tvRepliesTips;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setTopData(NodeListBean mTopBean) {
        this.mTopBean = mTopBean;
        notifyItemChanged(0);
    }

    public void setContentData(List<RepliesListBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }
}
