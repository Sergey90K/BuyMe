package com.seerhii.kurochka.buyme.data

import com.seerhii.kurochka.buyme.network.BuyMeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val buyMeRepository: BuyMeRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://vps56996.hyperhost.name/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val retrofitService: BuyMeApiService by lazy {
        retrofit.create(BuyMeApiService::class.java)
    }
    override val buyMeRepository: BuyMeRepository by lazy {
        NetworkBuyMeRepository(retrofitService)
    }

}