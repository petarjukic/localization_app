package com.example.localizationapp.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String, defaultValue: String) = sharedPreferences.getString(key, defaultValue) ?: defaultValue
}

enum class Preference(val key: String) {
    AppLanguage(key = "app_language")
}