package com.example.myapplication

import android.app.Application
import com.example.myapplication.core.di.favoriteModule
import com.example.myapplication.core.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(homeModule, favoriteModule)
        }
    }
}