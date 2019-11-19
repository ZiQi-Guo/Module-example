package com.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * @author guozq
 * @date 2019/7/4 0004下午 17:13
 * @desc
 */
public class ToastUtil {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void show(CharSequence text, int duration) {
        Toast.makeText(mContext, text, duration).show();
    }

    public static void show(CharSequence text) {
        Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
    }

    public static void show(@StringRes int stringId) {
        show(stringId, Toast.LENGTH_LONG);
    }

    public static void show(@StringRes int stringId, int duration) {
        show(mContext.getResources().getText(stringId), duration);
    }
}
