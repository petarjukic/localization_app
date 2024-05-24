package com.example.localizationapp.ui.scaffold

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.localizationapp.ui.NavGraphs
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScaffold() {
    val navHostEngine = rememberAnimatedNavHostEngine()
    val navHostController = navHostEngine.rememberNavController()

    Box(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            DestinationsNavHost(
                navGraph = NavGraphs.root,
                navController = navHostController,
                dependenciesContainerBuilder = {
                    dependency(paddingValues)
                }
            )
        }
    }
}