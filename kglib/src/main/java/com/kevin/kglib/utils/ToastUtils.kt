package com.kevin.kglib.utils

import android.widget.Toast

/**
 *  toast相关的utils
 */
class ToastUtils {
    companion object {
        @JvmStatic
        fun show(string: String) {
            Toast.makeText(ContextUtils.appContext, string, Toast.LENGTH_LONG).show()
        }

        @JvmStatic
        fun show(resId: Int) {
            Toast.makeText(ContextUtils.appContext, resId, Toast.LENGTH_LONG).show()
        }

        @JvmStatic
        fun showShort(String: String) {
            Toast.makeText(ContextUtils.appContext, String, Toast.LENGTH_SHORT).show()
        }

        @JvmStatic
        fun showShort(resId: Int) {
            Toast.makeText(ContextUtils.appContext, resId, Toast.LENGTH_SHORT).show()
        }
    }
}