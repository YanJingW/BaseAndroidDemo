package com.yanjingw.utils;

import android.util.Log;

public class LogUitls {
    public static void i(String tag, String message, Object object) {
        Log.i(tag, "[" + object.getClass().getSimpleName() + " : " + object.hashCode() + "]   " + message);
    }
}
