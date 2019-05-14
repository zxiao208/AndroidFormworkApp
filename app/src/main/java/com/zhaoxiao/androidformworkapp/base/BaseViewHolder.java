package com.zhaoxiao.androidformworkapp.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    // SparseArray 是Android特有的数组，用来替代HashMap降低内存占有和提高效率
    private SparseArray<View> views;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public View getRootView() {
        return itemView;
    }
}
