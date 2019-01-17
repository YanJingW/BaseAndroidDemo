package com.yanjingw.fragmentdemo.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanjingw.fragmentdemo.R;
import com.yanjingw.frame.BaseLazyFragment;


/**


 1.Activity和Fragment生命周期之间的关联：
 Activity 的每次生命周期回调都会引发每个fragment的类似回调。 例如，当 Activity 收到 onPause() 时，Activity 中的每个片段也会收到 onPause()。
 onStart.onResume.onPause.onStop四个生命周期与activity保持一致
 activity的onCreate和Fragment的onAttach.onCreate.onCreateView.onActivityCreated关联
 Activity的onDestroy和Fragment的onDestroyView.onDestroy.onDetach关联

 2.onVisible和onInVisible是由BaseLazyFragment复写setUserVisibleHint()进行控制的，此方法在单个Fragment中没有被调用执行。在viewpager的FragmentPagerAdapter被控制执行




 */
public class SingleLifeCycleFragment extends BaseLazyFragment {


    private static final String TAG = "DemoLifeCycleFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.i(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_lifecycle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    protected void onVisible() {
        super.onVisible();

        Log.i(TAG, "onVisible");
    }

    @Override
    protected void onInvisible() {
        super.onInvisible();

        Log.i(TAG, "onInvisible");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i(TAG, "onDetach");
    }

}
