package vip.zhaoxiao.androidformworkapp.ui.main.fragment;



import vip.zhaoxiao.androidformworkapp.R;
import vip.zhaoxiao.androidformworkapp.base.Constants;
import vip.zhaoxiao.androidformworkapp.base.SimpleFragment;
import vip.zhaoxiao.androidformworkapp.utils.AlipayUtil;
import vip.zhaoxiao.androidformworkapp.utils.SnackbarUtil;

import butterknife.OnClick;


/**
 * Created by codeest on 16/8/23.
 */

public class AboutFragment extends SimpleFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initEventAndData() {
    }

    @OnClick(R.id.cv_about_award)
    void awardAuthor() {
        if (AlipayUtil.hasInstalledAlipayClient(mContext)) {
            AlipayUtil.startAlipayClient(getActivity(), Constants.KEY_ALIPAY);
        } else {
            SnackbarUtil.showShort(getActivity().getWindow().getDecorView(), "木有检测到支付宝客户端 T T");
        }
    }

}
