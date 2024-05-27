package com.example.localizationapp.managers

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.localizationapp.preferences.Preference
import com.example.localizationapp.preferences.SharedPreferencesManager
import com.example.localizationapp.util.enums.AppLanguages

class LanguageSetterManager(
    private val context: Context,
    sharedPreferencesManager: SharedPreferencesManager
) {
    init {
        val language = sharedPreferencesManager.getString(
            key = Preference.AppLanguage.key,
            defaultValue = AppLanguages.ENGLISH.name
        )
        setLanguage(language = AppLanguages.valueOf(language))
    }

    fun setLanguage(language: AppLanguages) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(LocaleManager::class.java).applicationLocales =
                LocaleList.forLanguageTags(language.languageTag)
        } else {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(language.languageTag))
        }
    }
}