package com.example.localizationapp.managers

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.localizationapp.util.enums.AppLanguages

class LanguageSetterManager(private val context: Context) {
    fun setLanguage(language: AppLanguages) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(LocaleManager::class.java).applicationLocales =
                LocaleList.forLanguageTags(language.languageTag)
        } else {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language.languageTag))
        }
    }
}