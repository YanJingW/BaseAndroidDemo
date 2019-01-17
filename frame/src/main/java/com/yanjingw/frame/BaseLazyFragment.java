package com.yanjingw.frame;

import android.support.v4.app.Fragment;

/**
 * BaseFragment class.
 * Fragment生命周期控制
 * 懒加载
 */
public class BaseLazyFragment extends Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     * make it visible
     */
    protected void onVisible() {
    }

    /**
     * make it invisible
     */
    protected void onInvisible() {
    }
}
