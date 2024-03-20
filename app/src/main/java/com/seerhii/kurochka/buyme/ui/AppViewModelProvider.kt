package com.seerhii.kurochka.buyme.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.seerhii.kurochka.buyme.BuyMeApplication
import com.seerhii.kurochka.buyme.ui.homePage.HomeViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(buyMeApplication().container.buyMeRepository)
        }
    }
}

fun CreationExtras.buyMeApplication(): BuyMeApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BuyMeApplication)