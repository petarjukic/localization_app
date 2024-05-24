package com.example.localizationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.localizationapp.ui.scaffold.AppScaffold
import com.example.localizationapp.ui.theme.LocalizationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocalizationAppTheme {
                AppScaffold()
            }
        }
    }
}