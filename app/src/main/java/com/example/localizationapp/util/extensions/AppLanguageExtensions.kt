package com.example.localizationapp.util.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.localizationapp.R
import com.example.localizationapp.util.enums.AppLanguages

@Composable
fun AppLanguages.title() = when (this) {
    AppLanguages.ENGLISH -> stringResource(id = R.string.english_language)
    AppLanguages.GERMAN -> stringResource(id = R.string.german_language)
    AppLanguages.SPANISH -> stringResource(id = R.string.spanish_language)
}