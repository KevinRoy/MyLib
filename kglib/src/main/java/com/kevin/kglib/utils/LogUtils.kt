package com.kevin.kglib.utils

import com.kevin.kglib.BuildConfig
import android.text.TextUtils
import android.util.Log

/**
 * log 相关的utils
 */
class LogUtils {
    companion object {
        val LOGTAG = "logtag"
        val isLog = BuildConfig.DEBUG

        fun d(tag: String, d: String) {
            if (isLog)
                Log.d(if (TextUtils.isEmpty(tag)) LOGTAG else tag, d)
        }

        fun d(d: String) {
            d("", d)
        }

        fun e(tag: String, e: String) {
            if (isLog)
                Log.e(if (TextUtils.isEmpty(tag)) LOGTAG else tag, e)
        }

        fun e(e: String) {
            e("", e)
        }

        fun i(tag: String, i: String) {
            if (isLog)
                Log.i(if (TextUtils.isEmpty(tag)) LOGTAG else tag, i)
        }

        fun i(i: String) {
            i("", i)
        }
    }
}