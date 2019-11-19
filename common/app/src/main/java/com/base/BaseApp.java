package com.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.utils.LogUtil;
import com.utils.ToastUtil;

/**
 * @author guozq
 * @date 2019/7/4 0004下午 15:53
 * @desc
 */
public abstract class BaseApp extends MultiDexApplication {

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        ToastUtil.init(this);

    }
}
