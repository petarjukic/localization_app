package com.example.localizationapp.ui.tab_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TabBar(selectedIndex: Int, onIndexClick: (Int) -> Unit) {
    val tabs = listOf("Home", "Screen 2", "Screen 3")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedIndex, indicator = {
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(
                    currentTabPosition = it[selectedIndex],
                ),
                color = Color.Gray
            )
        }) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            style = TextStyle(fontSize = 16.sp)
                        )
                    },
                    selected = selectedIndex == index,
                    onClick = {
                        if (selectedIndex != index) {
                            onIndexClick.invoke(index)
                        }
                    }
                )
            }
        }
    }
}