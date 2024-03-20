package com.seerhii.kurochka.buyme.data

import com.seerhii.kurochka.buyme.network.BuyMeApiService
import com.seerhii.kurochka.buyme.network.ItemNet
import kotlinx.coroutines.flow.Flow

interface BuyMeRepository {
     suspend fun getListAllData(): List<ItemNet>
}

class NetworkBuyMeRepository(private val buyMeApiService: BuyMeApiService): BuyMeRepository{
    override suspend fun getListAllData(): List<ItemNet> {
        return buyMeApiService.getListAllData()
    }

}