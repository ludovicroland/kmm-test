package com.example.kmm_s2s_test2

import org.openapitools.client.apis.PetApi

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"

    fun android() {
        PetApi()
    }
}

actual fun getPlatform(): Platform = AndroidPlatform()