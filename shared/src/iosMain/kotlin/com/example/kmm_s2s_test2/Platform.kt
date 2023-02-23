package com.example.kmm_s2s_test2

import platform.UIKit.UIDevice

import org.openapitools.client.apis.PetApi

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    fun ios() {
        PetApi()
    }
}

actual fun getPlatform(): Platform = IOSPlatform()