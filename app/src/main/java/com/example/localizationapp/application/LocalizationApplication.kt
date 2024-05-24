package com.example.localizationapp.application

import android.app.Application
import com.example.localizationapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class LocalizationApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@LocalizationApplication)
            androidLogger()
        }
    }
}