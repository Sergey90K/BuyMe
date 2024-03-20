package com.seerhii.kurochka.buyme

import android.app.Application
import com.seerhii.kurochka.buyme.data.AppContainer
import com.seerhii.kurochka.buyme.data.DefaultAppContainer

class BuyMeApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}