package com.kevin.kglib.utils

import com.kevin.kglib.BuildConfig
import android.text.TextUtils
import android.util.Log

/**
 * log 相关的utils
 */
class LogUtils {
    companion object{
        val LOGTAG = "logtag"
        val isLog = BuildConfig.DEBUG

        @JvmStatic
        fun d(tag: String, d: String) {
            if (isLog)
                Log.d(if (TextUtils.isEmpty(tag)) LOGTAG else tag, d)
        }

        @JvmStatic
        fun d(d: String) {
            d("", d)
        }

        @JvmStatic
        fun e(tag: String, e: String) {
            if (isLog)
                Log.e(if (TextUtils.isEmpty(tag)) LOGTAG else tag, e)
        }

        @JvmStatic
        fun e(e: String) {
            e("", e)
        }

        @JvmStatic
        fun i(tag: String, i: String) {
            if (isLog)
                Log.i(if (TextUtils.isEmpty(tag)) LOGTAG else tag, i)
        }

        @JvmStatic
        fun i(i: String) {
            i("", i)
        }
    }
}
