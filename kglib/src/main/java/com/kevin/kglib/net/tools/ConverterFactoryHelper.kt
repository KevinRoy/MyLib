package com.kevin.kglib.net.tools

import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

class ConverterFactoryHelper {
    companion object {

        @JvmStatic
        fun createMoshiFactory(): Converter.Factory {
            return MoshiConverterFactory.create()
        }
    }
}