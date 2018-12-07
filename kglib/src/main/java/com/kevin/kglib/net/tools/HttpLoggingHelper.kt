package com.kevin.kglib.net.tools

import com.kevin.kglib.utils.LogUtils
import okhttp3.logging.HttpLoggingInterceptor


class HttpLoggingHelper {
    companion object {
        val LOGTAG = "okhttp"

        private val logging = HttpLoggingInterceptor { message -> LogUtils.d(LOGTAG, message) }

        @JvmStatic
        fun setBody(): HttpLoggingInterceptor {
            logging.level = HttpLoggingInterceptor.Level.BODY
            return logging
        }

        @JvmStatic
        fun setBasic(): HttpLoggingInterceptor {
            logging.level = HttpLoggingInterceptor.Level.BASIC
            return logging
        }

        @JvmStatic
        fun setHeaders(): HttpLoggingInterceptor {
            logging.level = HttpLoggingInterceptor.Level.HEADERS
            return logging
        }
    }
}