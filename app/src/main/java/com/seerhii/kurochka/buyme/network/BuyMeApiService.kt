package com.seerhii.kurochka.buyme.network

import retrofit2.http.GET
import retrofit2.http.POST

interface BuyMeApiService {
    @GET("buy-list/get")
    suspend fun getListAllData(): List<ItemNet>

    @POST("")
    suspend fun deleteItem():Boolean

    @POST("")
    suspend fun editItem(): Boolean

    @POST("")
    suspend fun doneItem(): Boolean
}