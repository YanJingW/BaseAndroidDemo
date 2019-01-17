package com.yanjingw.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * BaseFragment class.
 * Fragment生命周期控制
 * 懒加载
 */
public abstract class BaseFragment extends Fragment {

    protected boolean mIsVisible = false;
    protected boolean mIsPrepared = false;

    protected boolean mIsFetchData = false;

    protected View mFragmentView;
    private BaseFragment parentFragment;

    protected boolean isLoad = false;//加载过

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Fragment parentFragment = getParentFragment();
        boolean isParentVisible = parentFragment != null ? parentFragment.getUserVisibleHint() : (this.parentFragment != null ? this.parentFragment.getUserVisibleHint() : true);
        super.setUserVisibleHint(isVisibleToUser && isParentVisible);
        if (getUserVisibleHint()) {
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }
    }

    /**
     * make it visible
     */
    protected void onVisible() {
        onLazyLoad();
        isLoad = true;
    }


    /**
     * make it invisible
     */
    protected void onInvisible() {
        if (isLoad) {
            stopLoad();
        }
    }

    protected void stopLoad() {

    }

    /**
     * lazy loading
     */
    protected void onLazyLoad() {
        if (!mIsPrepared || !mIsVisible) {
            return;
        }
        if (!mIsFetchData) {
            prepareFetchData();
        }
    }

    protected abstract void prepareFetchData();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransitionEnter();
    }

    protected void overridePendingTransitionEnter() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }
}
