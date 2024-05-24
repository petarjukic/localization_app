package com.example.localizationapp.ui.home_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.localizationapp.R
import com.example.localizationapp.ui.destinations.PageCurlScreenDestination
import com.example.localizationapp.ui.tab_bar.TabBar
import com.example.localizationapp.ui.theme.Dimensions
import com.example.localizationapp.util.enums.AppLanguages
import com.example.localizationapp.util.extensions.title
import com.example.localizationapp.view_model.HomeScreenViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

object HomeScreenView {
    @Composable
    fun Compose(homeScreenViewModel: HomeScreenViewModel, navigator: DestinationsNavigator) {
        val homeScreenState = homeScreenViewModel.homeScreenState.collectAsState()

        Column(modifier = Modifier.fillMaxSize()) {
            TabBar(selectedIndex = homeScreenState.value.selectedIndex) {
                homeScreenViewModel.updateSelectedIndex(index = it)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Dimensions.PADDING_DEFAULT, horizontal = Dimensions.PADDING_MINIMUM),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = when (homeScreenState.value.selectedIndex) {
                        0 -> stringResource(R.string.home_text)
                        1 -> stringResource(id = R.string.home_screen_two)
                        2 -> stringResource(id = R.string.home_screen_three)
                        else -> stringResource(id = R.string.error_message)
                    }
                )
                AnimatedVisibility(visible = homeScreenState.value.selectedIndex == 0) {
                    TextButton(onClick = { navigator.navigate(PageCurlScreenDestination) }) {
                        Text(text = stringResource(id = R.string.page_curl_screen))
                    }
                }
                AnimatedVisibility(visible = homeScreenState.value.selectedIndex == 1) {
                    LanguageChooser {

                    }
                }
            }
        }
    }

    @Composable
    fun LanguageChooser(onLanguageClick: (Int) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimensions.PADDING_BIG),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AppLanguages.entries.forEachIndexed { index, appLanguage ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                    )
                    Text(text = appLanguage.title())
                }
            }
        }
    }
}