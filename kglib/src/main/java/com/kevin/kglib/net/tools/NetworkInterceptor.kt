package com.kevin.kglib.net.tools

import com.kevin.kglib.utils.NetWorkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if (!NetWorkUtils.isConnected()) {
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }

        var response = chain.proceed(request)

        return response
            .newBuilder()
            .header("Cache-Control", "public, max-age=5")
            .removeHeader("Pragma").build()
    }
}