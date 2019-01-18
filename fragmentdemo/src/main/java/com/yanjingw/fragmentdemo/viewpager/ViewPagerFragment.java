/*
 * <copyright file="SmartSceneFragment.java" company="Qihoo 360 Corporation">
 * Copyright (c) Qihoo 360 Corporation. All rights reserved.
 * </copyright>
 */
package com.yanjingw.fragmentdemo.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanjingw.fragmentdemo.R;
import com.yanjingw.frame.BaseLazyFragment;
import com.yanjingw.utils.LogUitls;

import java.util.List;

public class ViewPagerFragment extends BaseLazyFragment {

    public static final String TAG = ViewPagerFragment.class.getSimpleName();

    private ViewPager mVpDevice;
    private FragmentAdapter fragmentAdapter;
    private List<String> secondTabData;
    private View mFragmentView;

    public ViewPagerFragment() {
        LogUitls.i(TAG, "new", this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mFragmentView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        initView();
        refreshData();
        return mFragmentView;
    }

    private void initView() {
        mVpDevice = mFragmentView.findViewById(R.id.vp);
        mVpDevice.setOffscreenPageLimit(1);
    }

    public void setData(List<String> value) {
        this.secondTabData = value;
    }

    private void refreshData() {
        if (fragmentAdapter == null) {
            fragmentAdapter = new FragmentAdapter(this, getChildFragmentManager(), this.getActivity());
            fragmentAdapter.setData(secondTabData);
            mVpDevice.setAdapter(fragmentAdapter);
        } else {
            fragmentAdapter.notifyDataSetChanged();
        }
    }
}
