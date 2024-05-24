package com.example.localizationapp.di

import com.example.localizationapp.view_model.HomeScreenViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        viewModelModule(),
        managersModule()
    )
}

fun viewModelModule() = module {
    factory { HomeScreenViewModel() }
}

fun managersModule() = module {

}