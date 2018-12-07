package com.kevin.kglib

import android.app.Application
import com.kevin.kglib.utils.ContextUtils
import retrofit2.Converter


abstract class LibBaseApplication : Application() {

    /**
     * 设置主URL
     * @return
     */
    protected abstract val defaultBaseUrl: String

    /**
     * 设置CoverterFactory 目前主要是Gson和Moshi
     * @return
     */
    protected abstract val converterFactory: Converter.Factory

    override fun onCreate() {
        super.onCreate()

        ContextUtils.init(this)

        LibConfig.baseUrl = defaultBaseUrl
        LibConfig.factory = converterFactory
    }
}