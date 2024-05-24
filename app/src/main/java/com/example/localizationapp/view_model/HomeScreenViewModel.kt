package com.example.localizationapp.view_model

import androidx.lifecycle.ViewModel
import com.example.localizationapp.preferences.Preference
import com.example.localizationapp.preferences.SharedPreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel(private val sharedPreferencesManager: SharedPreferencesManager) : ViewModel() {
    private val _homeScreenState = MutableStateFlow(value = HomeScreenViewModelState())

    val homeScreenState = _homeScreenState.asStateFlow()

    fun updateSelectedIndex(index: Int) {
        _homeScreenState.update { state ->
            state.copy(selectedIndex = index)
        }
    }

    fun saveAppLanguage(language: String) {
        sharedPreferencesManager.saveString(key = Preference.AppLanguage.key, value = language)
    }
}

data class HomeScreenViewModelState(val selectedIndex: Int = 0)