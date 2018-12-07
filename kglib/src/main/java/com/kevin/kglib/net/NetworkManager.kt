package com.kevin.kglib.net

import android.text.TextUtils
import com.kevin.kglib.LibConfig
import com.kevin.kglib.R
import com.kevin.kglib.net.cookie.PersistentCookieJar
import com.kevin.kglib.net.cookie.cache.SetCookieCache
import com.kevin.kglib.net.cookie.persistence.SharedPrefsCookiePersistor
import com.kevin.kglib.net.tools.ConverterFactoryHelper
import com.kevin.kglib.net.tools.HttpLoggingHelper
import com.kevin.kglib.net.tools.NetworkInterceptor
import com.kevin.kglib.utils.ContextUtils
import com.kevin.kglib.utils.FileUtils
import com.kevin.kglib.utils.NetWorkUtils
import com.kevin.kglib.utils.ToastUtils
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class NetworkManager {

    private var retrofit: Retrofit
    private var okHttpClient: OkHttpClient
    private var baseUrl: String
    private var factory: Converter.Factory

    companion object {
        @JvmStatic
        private val TIMEOUT = 15

        @JvmStatic
        @Volatile
        private lateinit var networkManager: NetworkManager

        @JvmStatic
        fun getInstance(): NetworkManager? {
            if (networkManager == null) {
                synchronized(NetworkManager::class.java) {
                    if (networkManager == null) {
                        networkManager = NetworkManager()
                    }
                }
            }
            return networkManager
        }
    }


    constructor() {
        baseUrl = LibConfig.baseUrl

        if (TextUtils.isEmpty(baseUrl))
            throw NullPointerException("baseUrl is null")

        factory = LibConfig.factory

        if (factory == null)
            factory = ConverterFactoryHelper.createMoshiFactory()

        val cookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(ContextUtils.appContext))

//        RxBus.INSTACE.asFlowable()
//            .subscribe({ o ->
//                if (o is LoginoutEvent) {
//                    cookieJar.clear()
//                }
//            })

        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .cookieJar(cookieJar)
            .cache(getCache())
            .addInterceptor(HttpLoggingHelper.setBody())
            .addNetworkInterceptor(NetworkInterceptor())
            .build()

        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)

        retrofit = builder.build()
    }

    /**
     * 缓存
     *
     * @return
     */
    private fun getCache(): Cache {
        var cacheSize: Long
        val cachePath = FileUtils.getCacheDir()
        if (FileUtils.isSDCardMounted()) {
            cacheSize = 100 * 1024 * 1024
        } else {
            cacheSize = 20 * 1024 * 1024
        }
        return Cache(File(cachePath), cacheSize)
    }

    fun <T> create(clasz: Class<T>): T {
        if (!NetWorkUtils.isConnected()) {
            ToastUtils.show(R.string.error_network)
        }

        return retrofit.create(clasz)
    }
}