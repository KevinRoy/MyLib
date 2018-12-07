package com.kevin.kglib.utils

import android.content.Context

/**
 * 上下文utils
 */
class ContextUtils {
    companion object {
        lateinit var appContext: Context

        @JvmStatic
        fun init(context: Context) {
            appContext = context.applicationContext
        }
    }
}