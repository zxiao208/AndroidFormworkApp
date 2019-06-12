package vip.zhaoxiao.androidformworkapp.ui.main.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;


import butterknife.BindView;
import vip.zhaoxiao.androidformworkapp.R;
import vip.zhaoxiao.androidformworkapp.base.BaseActivity;
import vip.zhaoxiao.androidformworkapp.base.contract.main.WelcomeContract;
import vip.zhaoxiao.androidformworkapp.component.ImageLoader;
import vip.zhaoxiao.androidformworkapp.model.bean.WelcomeBean;
import vip.zhaoxiao.androidformworkapp.presenter.main.WelcomePresenter;

/**
 * Created by codeest on 16/8/15.
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tvWelcomeAuthor;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        ImageLoader.load(this, welcomeBean.getImg(), ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        tvWelcomeAuthor.setText(welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        Glide.clear(ivWelcomeBg);
        super.onDestroy();
    }
}
