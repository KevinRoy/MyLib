package com.kevin.kglib

import retrofit2.Converter

class LibConfig {
    companion object {

        @JvmStatic
        lateinit var baseUrl: String

        @JvmStatic
        lateinit var factory: Converter.Factory
    }
}