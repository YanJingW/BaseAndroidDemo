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
import com.yanjingw.frame.BaseLazyFragment;
import com.yanjingw.utils.LogUitls;


/**
 * 1.Activity和Fragment生命周期之间的关联：
 * Activity 的每次生命周期回调都会引发每个fragment的类似回调。 例如，当 Activity 收到 onPause() 时，Activity 中的每个片段也会收到 onPause()。
 * onStart.onResume.onPause.onStop四个生命周期与activity保持一致
 * activity的onCreate和Fragment的onAttach.onCreate.onCreateView.onActivityCreated关联
 * Activity的onDestroy和Fragment的onDestroyView.onDestroy.onDetach关联
 * <p>
 * 2.onVisible和onInVisible是由BaseLazyFragment复写setUserVisibleHint()进行控制的，此方法在单个Fragment中没有被调用执行。在viewpager的FragmentPagerAdapter被控制执行
 */
public class SingleLifeCycleFragment extends BaseLazyFragment {

    public static final String TAG = SingleLifeCycleFragment.class.getSimpleName();
    private String dataStr;

    public SingleLifeCycleFragment() {
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUitls.i(TAG, "onCreateView", this);
        View inflate = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        TextView tv_detail = inflate.findViewById(R.id.tv_detail);
        if (!TextUtils.isEmpty(dataStr)) {
            tv_detail.setText(dataStr);
        }
        return inflate;
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
