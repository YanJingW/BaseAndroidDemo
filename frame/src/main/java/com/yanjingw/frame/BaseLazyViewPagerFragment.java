package com.yanjingw.frame;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseLazyFragment class.
 * 只适用于viewpager嵌套的fragment
 * Fragment生命周期控制
 * 懒加载
 * 子类不能复写onCreateView()方法
 */
public abstract class BaseLazyViewPagerFragment extends Fragment {

    /**
     * 页面的显示状态，用来控制onInvisible()，保持onVisible()和onInvisible()两个生命周期成对出现
     */
    private boolean isVisible = false;

    /**
     * 判断Fragment是否完成视图的构建
     */
    private boolean mIsViewInit = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mFragmentView = setContentView(inflater, container);
        mIsViewInit = true;
        tryLazyLoad();
        return mFragmentView;
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
        tryLazyLoad();
    }

    /**
     * make it invisible
     */
    protected void onInvisible() {
    }


    /**
     * 根据对ViewPager中Fragment的生命周期的表现，当Fragment对用户可见时，onVisible和onCreateView的执行顺序不能保证。所以必须两个方法都被调用。
     */
    private void tryLazyLoad() {
        if (isVisible && mIsViewInit) {
            onVisibleWithViewPrepared();
        }
    }

    /**
     * 懒加载的核心方法，Fragment完成视图的构建并且Fragment对用户可见
     */
    protected abstract void onVisibleWithViewPrepared();

    /**
     * 只能在此方法中完成对View的初始化，此方法被onCreateView控制调用
     *
     * @param inflater
     * @param container
     * @return fragment布局
     */
    protected abstract View setContentView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
