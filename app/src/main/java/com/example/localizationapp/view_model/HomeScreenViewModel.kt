package com.example.localizationapp.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel : ViewModel() {
    private val _homeScreenState = MutableStateFlow(value = HomeScreenViewModelState())

    val homeScreenState = _homeScreenState.asStateFlow()

    fun updateSelectedIndex(index: Int) {
        _homeScreenState.update { state ->
            state.copy(selectedIndex = index)
        }
    }
}

data class HomeScreenViewModelState(val selectedIndex: Int = 0)