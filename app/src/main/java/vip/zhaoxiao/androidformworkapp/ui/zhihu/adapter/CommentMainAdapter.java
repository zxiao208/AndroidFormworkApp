package vip.zhaoxiao.androidformworkapp.ui.zhihu.adapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import vip.zhaoxiao.androidformworkapp.ui.zhihu.fragment.CommentFragment;

/**
 * Created by codeest on 16/8/19.
 */

public class CommentMainAdapter extends FragmentPagerAdapter {

    private List<CommentFragment> fragments;

    public CommentMainAdapter(FragmentManager fm, List<CommentFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
