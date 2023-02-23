package com.example.kmm_s2s_test2

import org.openapitools.client.apis.PetApi

interface Platform {
    val name: String

    fun common() {
        PetApi()
    }
}

expect fun getPlatform(): Platform