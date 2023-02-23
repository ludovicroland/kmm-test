package com.example.kmm_s2s_test2

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import org.openapitools.client.apis.PetApi
import org.openapitools.client.models.Pet

val dktAnalyticsTrackingModule = module {
    single { DKTAnalyticsTracking() }
    single { PetApi() }
}

class DKTAnalyticsTracking
    : KoinComponent {

    private val api: PetApi by inject()

    suspend fun getRequestWithResult(): List<Pet> {
        return api.findPetsByStatus(listOf()).body()
    }

    suspend fun getRequestNoResult() {
        api.findPetsByStatus(listOf())
    }

}