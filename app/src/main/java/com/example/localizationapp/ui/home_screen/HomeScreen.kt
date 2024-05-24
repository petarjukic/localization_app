package com.example.localizationapp.ui.home_screen

import androidx.compose.runtime.Composable
import com.example.localizationapp.view_model.HomeScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel = koinViewModel(), navigator: DestinationsNavigator) {
    HomeScreenView.Compose(homeScreenViewModel = homeScreenViewModel, navigator = navigator)
}