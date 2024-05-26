package com.example.localizationapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localizationapp.managers.LanguageSetterManager
import com.example.localizationapp.preferences.Preference
import com.example.localizationapp.preferences.SharedPreferencesManager
import com.example.localizationapp.util.enums.AppLanguages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val sharedPreferencesManager: SharedPreferencesManager,
    private val languageSetterManager: LanguageSetterManager
) : ViewModel() {
    private val _homeScreenState = MutableStateFlow(value = HomeScreenViewModelState())

    val homeScreenState = _homeScreenState.asStateFlow()

    init {
        viewModelScope.launch {
            val language = sharedPreferencesManager.getString(
                key = Preference.AppLanguage.key,
                defaultValue = AppLanguages.ENGLISH.name
            )

            _homeScreenState.update { state -> state.copy(selectedLanguage = language) }
        }
    }

    fun updateSelectedIndex(index: Int) {
        _homeScreenState.update { state ->
            state.copy(selectedIndex = index)
        }
    }

    fun setAppLanguage(language: String) {
        if (language != sharedPreferencesManager.getString(
                key = Preference.AppLanguage.key,
                defaultValue = AppLanguages.ENGLISH.name
            )
        ) {
            sharedPreferencesManager.removeValue(key = Preference.AppLanguage.key)
            sharedPreferencesManager.saveString(key = Preference.AppLanguage.key, value = language)

            languageSetterManager.setLanguage(language = AppLanguages.valueOf(language))

            _homeScreenState.update { state -> state.copy(selectedLanguage = language) }
        }
    }
}

data class HomeScreenViewModelState(
    val selectedIndex: Int = 0,
    val selectedLanguage: String = AppLanguages.ENGLISH.name
)