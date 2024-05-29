package com.example.localizationapp.ui.app_language_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.localizationapp.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AppLanguageScreen() {
    AppLanguageView.Compose()
}

enum class SetAppLanguage {
    CROATIAN, GERMAN, ENGLISH
}

@Composable
fun SetAppLanguage.title() = when (this) {
    SetAppLanguage.GERMAN -> stringResource(id = R.string.german_language)
    SetAppLanguage.ENGLISH -> stringResource(id = R.string.english_language)
    SetAppLanguage.CROATIAN -> stringResource(id = R.string.croatian_language)
}

@Composable
fun SetAppLanguage.image() = when (this) {
    SetAppLanguage.CROATIAN -> painterResource(id = R.drawable.croatina_flag)
    SetAppLanguage.GERMAN -> painterResource(id = R.drawable.german_flag)
    SetAppLanguage.ENGLISH -> painterResource(id = R.drawable.english)
}