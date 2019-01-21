package com.yanjingw.fragmentdemo.singlefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanjingw.fragmentdemo.R;
import com.yanjingw.frame.BaseLazyLoadFragment;
import com.yanjingw.utils.LogUitls;


/**
 * 1.onVisible和onInVisible是由BaseLazyViewPagerFragment复写setUserVisibleHint()进行控制的，此方法在单个Fragment中没有被调用执行。在viewpager的FragmentPagerAdapter被控制执行
 */
public class LifeCycleFragment extends BaseLazyLoadFragment {

    public static final String TAG = LifeCycleFragment.class.getSimpleName();
    private String dataStr;
    private TextView tv_detail;

    public LifeCycleFragment() {
        LogUitls.i(TAG, "new", this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        LogUitls.i(TAG, "onAttach", this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUitls.i(TAG, "onCreate", this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUitls.i(TAG, "onCreateView", this);
        // TODO: 2019/1/18 在onCreateView()中对Fragment完成视图的构建。
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected View setContentView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_detail, container, false);
        tv_detail = inflate.findViewById(R.id.tv_detail);
        tv_detail.setText("从内存中取得的数据");
        return inflate;
    }

    @Override
    protected void onLoadData() {
        LogUitls.i(TAG, "onLoadData", this);
        if (!TextUtils.isEmpty(dataStr)) {
            tv_detail.setText(dataStr);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LogUitls.i(TAG, "onActivityCreated", this);
    }

    @Override
    public void onStart() {
        super.onStart();

        LogUitls.i(TAG, "onStart", this);
    }

    @Override
    public void onResume() {
        super.onResume();

        LogUitls.i(TAG, "onResume", this);
    }

    @Override
    protected void onVisible() {
        super.onVisible();

        LogUitls.i(TAG, "onVisible", this);
    }

    @Override
    protected void onInvisible() {
        super.onInvisible();

        LogUitls.i(TAG, "onInvisible", this);
    }

    @Override
    public void onPause() {
        super.onPause();

        LogUitls.i(TAG, "onPause", this);
    }

    @Override
    public void onStop() {
        super.onStop();

        LogUitls.i(TAG, "onStop", this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        LogUitls.i(TAG, "onDestroyView", this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        LogUitls.i(TAG, "onDestroy", this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        LogUitls.i(TAG, "onDetach", this);
    }

    public void setData(String detail) {
        this.dataStr = detail;
    }
}
