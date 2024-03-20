package com.seerhii.kurochka.buyme.ui.homePage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seerhii.kurochka.buyme.data.BuyMeRepository
import com.seerhii.kurochka.buyme.network.ItemNet
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BuyMeState {
    data class Success(val allListBuyMe: List<ItemNet>) : BuyMeState
    data object Error : BuyMeState
    data object Loading : BuyMeState

}

class HomeViewModel(private val dataListRepository: BuyMeRepository) : ViewModel() {
    var allItemUiState: BuyMeState by mutableStateOf(BuyMeState.Loading)
        private set

    var optionsForOwner: OwnerOptions by mutableStateOf(OwnerOptions())
        private set

    var selectedOptionsOwner: String by mutableStateOf(optionsForOwner.options[0])
        private set

    init {
        getAllItem()
    }

    private fun getAllItem() {
        viewModelScope.launch {
            allItemUiState = try {
                val innerData = dataListRepository.getListAllData()
                val options: MutableList<String> = mutableListOf()
                for (a in innerData) {
                    options.add(a.ownerOrDoes)
                }
                options.also { optionsForOwner = OwnerOptions(it) }
                BuyMeState.Success(innerData)

            } catch (e: IOException) {
                BuyMeState.Error
            }
        }
    }

    fun selectOptionsForOwner(ownerName: String) {
        selectedOptionsOwner = ownerName
    }

    fun sortAboutTime(){}

    fun doneItem(){}

    fun editItem(){}

    fun deleteItem(){}

}

data class OwnerOptions(val options: List<String> = listOf("Loading", "Loading"))