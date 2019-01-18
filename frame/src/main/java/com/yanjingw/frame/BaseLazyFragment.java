package com.yanjingw.frame;

import android.support.v4.app.Fragment;

/**
 * BaseFragment class.
 * Fragment生命周期控制
 * 懒加载
 */
public class BaseLazyFragment extends Fragment {

    /**
     * 页面的显示状态，用来控制onInvisible()，保持onVisible()和onInvisible()两个生命周期成对出现
     */
    private boolean isVisible = false;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            if (!isVisible) {
                isVisible = true;
                onVisible();
            }
        } else {
            if (isVisible) {
                isVisible = false;
                onInvisible();
            }
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
