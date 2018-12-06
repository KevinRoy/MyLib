package com.kevin.kglib.utils

import android.util.TypedValue

/**
 * dp的操作和转化
 */
class RuleUtils {
    companion object {
        /**
         * 将dp转换成对应的px值
         */
        fun dp2Px(dp: Float): Int {
            val metrics = ContextUtils.appContext.resources.displayMetrics
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics).toInt()
        }

        /**
         * 将px转换成对应的dp值
         */
        fun px2Dp(px: Float): Int {
            val scale = ContextUtils.appContext.resources.displayMetrics.density
            return (px / scale + 0.5f).toInt()
        }

        /**
         * 将sp转换成对应的px值
         */
        fun sp2Px(sp: Float): Int {
            val metrics = ContextUtils.appContext.resources.displayMetrics
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, metrics).toInt()
        }
    }
}