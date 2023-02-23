package com.example.kmm_s2s_test2

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun init() {
    startKoin {
        modules(dktAnalyticsTrackingModule)
    }
}

class DKTAnalyticsTrackingHelper
    : KoinComponent {
        val dktAnalyticsTracking: DKTAnalyticsTracking by inject()
    }