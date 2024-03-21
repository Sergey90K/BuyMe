package com.seerhii.kurochka.buyme.ui.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seerhii.kurochka.buyme.data.BuyMeRepository
import com.seerhii.kurochka.buyme.network.ItemNet
import kotlinx.coroutines.launch
import java.io.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface BuyMeState {
    data class Success(val allListBuyMe: List<ItemNet>) : BuyMeState
    data object Error : BuyMeState
    data object Loading : BuyMeState
}

class HomeViewModel(private val dataListRepository: BuyMeRepository) : ViewModel() {
    private var _allItemUiState: MutableStateFlow<BuyMeState> = MutableStateFlow(BuyMeState.Loading)
    var allItemUiState: StateFlow<BuyMeState> = _allItemUiState.asStateFlow()

    private var _doneItemUiState: MutableStateFlow<BuyMeState> = MutableStateFlow(BuyMeState.Loading)
    var doneItemUiState: StateFlow<BuyMeState> = _doneItemUiState.asStateFlow()

    private var _optionsForOwner: MutableStateFlow<OwnerOptions> = MutableStateFlow(OwnerOptions())
    var optionsForOwner: StateFlow<OwnerOptions> = _optionsForOwner.asStateFlow()

    private var _selectedOptionsOwner: MutableStateFlow<String> =
        MutableStateFlow(optionsForOwner.value.options[0])
    var selectedOptionsOwner: StateFlow<String> = _selectedOptionsOwner.asStateFlow()

    init {
        getAllItem()
    }

    private fun getAllItem() {
        viewModelScope.launch {
            _allItemUiState.value = try {
                val innerData = dataListRepository.getListAllData()
                val options: MutableList<String> = mutableListOf()
                val workList:MutableList<ItemNet> = mutableListOf()
                val doneList:MutableList<ItemNet> = mutableListOf()
                for (a in innerData) {
                    options.add(a.ownerOrDoes)
                    when (a.status) {
                        StatusValue.ACTIVE.status -> {
                            workList.add(a)
                        }
                        StatusValue.APPOINT_REJECT.status -> {
                            workList.add(a)
                        }
                        StatusValue.APPOINT_REQUEST.status -> {
                            workList.add(a)
                        }
                        StatusValue.DONE.status -> {
                            doneList.add(a)
                        }
                        else ->{
                            workList.add(a)
                        }
                    }
                }
                _doneItemUiState.value = BuyMeState.Success(doneList)
                _optionsForOwner.value = OwnerOptions(options)
                BuyMeState.Success(workList)
            } catch (e: IOException) {
                BuyMeState.Error
            }
        }
    }

    fun selectOptionsForOwner(ownerName: String) {
        _selectedOptionsOwner.value = ownerName
    }

    fun sortAboutTime() {
        //add sorted for list Owner
        val data = _allItemUiState.value as List<ItemNet>
        data.sorted()
        _allItemUiState.value = BuyMeState.Success(data)
    }

    fun doneItem(idUser: Int) {
        // show window and done Item
        // Send to the server ID
    }

    fun editItem(idUser: Int) {
        // show window and edit item
        //Send to the server Item / cost/ value
    }

    fun deleteItem(idUser: Int) {
        // show window and delete item
        //Send to the server ID
    }
}

data class OwnerOptions(val options: List<String> = listOf("Loading", "Loading"))

enum class StatusValue(val status: String) {
    ACTIVE("active"),
    APPOINT_REQUEST("appoint_request"),
    APPOINT_REJECT("appoint_reject"),
    DONE("done")
}