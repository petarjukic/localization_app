package com.example.localizationapp.ui.page_curl_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.localizationapp.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PageCurlScreen() {
    val textList = listOf(
        stringResource(id = R.string.screen_one_text),
        stringResource(id = R.string.screen_two_text),
        stringResource(id = R.string.screen_three_text)
    )
    val images = listOf(
        painterResource(id = R.drawable.image_1),
        painterResource(id = R.drawable.image_2),
        painterResource(id = R.drawable.image_3)
    )

    PageCurlView.Compose(textList = textList, images = images)
}