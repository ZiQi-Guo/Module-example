package com.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author guozq
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    /**
     * 页面布局
     *
     * @return 页面布局
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化 activity
     */
    protected abstract void initView();


}
