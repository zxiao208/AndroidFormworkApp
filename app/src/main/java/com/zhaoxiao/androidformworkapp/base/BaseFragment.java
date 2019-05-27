package com.zhaoxiao.androidformworkapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

/**
 * MVP Fragment基类
 */
public abstract class BaseFragment<V extends BaseView,T extends BasePresenter> extends SimpleFragment implements BaseView {

}