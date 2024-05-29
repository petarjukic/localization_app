package com.example.localizationapp.ui.app_language_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.localizationapp.R
import com.example.localizationapp.ui.theme.Dimensions

object AppLanguageView {
    @Composable
    fun Compose() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .paint(painter = painterResource(id = R.drawable.background), contentScale = ContentScale.FillBounds),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Content(onLanguageClick = {
                println("Selected language ${SetAppLanguage.valueOf(it)}")
            })
        }
    }

    @Composable
    fun Content(onLanguageClick: (String) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.set_language_app), fontSize = 24.sp, color = Color.White)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 90.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetAppLanguage.entries.forEach { setAppLanguage ->
                LanguageRow(setAppLanguage = setAppLanguage, onLanguageClick = onLanguageClick)
            }
        }
    }

    @Composable
    fun LanguageRow(setAppLanguage: SetAppLanguage, onLanguageClick: (String) -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimensions.PADDING_MINIMUM)
                .clickable { onLanguageClick.invoke(setAppLanguage.name) },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = setAppLanguage.image(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = stringResource(id = R.string.image)
            )
            Text(
                text = setAppLanguage.title(),
                color = Color.White,
                fontSize = 24.sp
            )
            Box {}
        }
    }
}