package com.example.localizationapp.ui.page_curl_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.localizationapp.R
import com.example.localizationapp.ui.theme.Dimensions
import eu.wewox.pagecurl.ExperimentalPageCurlApi
import eu.wewox.pagecurl.page.PageCurl
import eu.wewox.pagecurl.page.rememberPageCurlState
import kotlinx.coroutines.launch

object PageCurlView {
    @Composable
    fun Compose(textList: List<String>, images: List<Painter>) {
        Column {
            Content(textList = textList, images = images)
        }
    }

    @OptIn(ExperimentalPageCurlApi::class)
    @Composable
    fun Content(textList: List<String>, images: List<Painter>) {
        val scope = rememberCoroutineScope()
        val state = rememberPageCurlState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.PADDING_DEFAULT),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { scope.launch { state.prev() } }) {
                Text(text = stringResource(id = R.string.previous_page))
            }
            Button(onClick = { scope.launch { state.next() } }) {
                Text(text = stringResource(id = R.string.next_page))
            }
        }
        PageCurl(
            count = textList.size,
            state = state
        ) { indexPage ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
            ) {
                Image(
                    painter = images[indexPage],
                    contentDescription = stringResource(id = R.string.image),
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = textList[indexPage],
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green,
                    fontSize = 22.sp
                )
            }
        }
    }
}