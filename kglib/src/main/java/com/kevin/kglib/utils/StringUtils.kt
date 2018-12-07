package com.kevin.kglib.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * 格式和判断的字符串相关
 */
class StringUtils {
    companion object {
        /**
         * 是否为移动手机号码
         */
        @JvmStatic
        fun isMobile(mobiles: String): Boolean {
            val p = Pattern.compile("^1[0-9]{10}$")
            val m = p.matcher(mobiles)
            return m.matches()
        }

        /**
         * 是否为邮箱
         */
        @JvmStatic
        fun isEmail(emai: String): Boolean {
            val p = Pattern.compile("^//s*//w+(?://.{0,1}[//w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*//.[a-zA-Z]+//s*\$")
            val m = p.matcher(emai)
            return m.matches()
        }

        /**
         * 获取format日期
         */
        @JvmStatic
        fun getDate(dateString: Long, format: String): String {
            var date = Date(dateString)
            var sdf = SimpleDateFormat(format)

            return sdf.format(date)
        }
    }
}