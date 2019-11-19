package com.utils;

import android.util.Log;

/**
 * @author guozq
 * @date 2019/7/4 0004下午 17:28
 * @desc
 */
public class LogUtil {

    /**
     * 默认开户debug模式
     */
    private static boolean isDebug = true;
    private static String tag = "TAG";


    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebug(boolean isDebug) {
        LogUtil.isDebug = isDebug;
    }

    public static void setTag(String tag) {
        if (tag == null || "".equalsIgnoreCase(tag.trim())) {
            //tag 设置失败 使用默认设置
            return;
        }
        LogUtil.tag = tag;
    }

    public static String getTag() {
        return tag;
    }


    public static void v(String string) {
        if (isDebug) {
            Log.v(tag, string);
        }
    }


    public static void d(String string) {
        Log.d(tag, string);
    }


    public static void i(String string) {
        Log.i(tag, string);
    }


    public static void w(String string) {
        Log.w(tag, string);
    }

    public static void e(String string) {
        Log.e(tag, string);
    }


}
