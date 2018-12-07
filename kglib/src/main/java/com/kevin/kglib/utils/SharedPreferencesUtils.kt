package com.kevin.kglib.utils

import android.content.SharedPreferences
import android.preference.PreferenceManager


/**
 * SharedPreferences相关
 */
class SharedPreferencesUtils {
    companion object {
        /**
         * 获取
         */
        @JvmStatic
        fun <T> get(key: String, defValue: T): T {
            when (defValue) {
                String -> return getPreference().getString(key, defValue as String) as T
                Int -> return getPreference().getInt(key, defValue as Int) as T
                Boolean -> return getPreference().getBoolean(key, defValue as Boolean) as T
                Float -> return getPreference().getFloat(key, defValue as Float) as T
                Double -> return getPreference().getFloat(key, (defValue as Double).toFloat()) as T
                Long -> return getPreference().getLong(key, defValue as Long) as T
            }
            return Any() as T
        }

        /**
         * 保存
         */
        @JvmStatic
        fun <T> save(key: String, value: T): Boolean {
            val editor = getPreference().edit()
            when (value) {
                String -> editor.putString(key, value as String)
                Int -> editor.putInt(key, value as Int)
                Boolean -> editor.putBoolean(key, value as Boolean)
                Float -> editor.putFloat(key, value as Float)
                Double -> editor.putFloat(key, (value as Double).toFloat())
                Long -> editor.putLong(key, value as Long)
            }
            return editor.commit()
        }

        /**
         * 初始化
         */
        @JvmStatic
        fun getPreference(): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(ContextUtils.appContext)
        }

        @JvmStatic
        fun getPreference(name: String): SharedPreferences {
            return ContextUtils.appContext.getSharedPreferences(name, 0)
        }
    }
}