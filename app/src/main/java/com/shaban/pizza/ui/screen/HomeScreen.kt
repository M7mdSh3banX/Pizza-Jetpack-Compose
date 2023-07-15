package com.shaban.pizza.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shaban.pizza.R
import com.shaban.pizza.ui.composable.CustomIcon
import com.shaban.pizza.ui.theme.Typography
import com.shaban.pizza.ui.theme.WhiteBackground

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackground)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIcon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.arrow_back_icon_desc)
            )
            Text(text = stringResource(R.string.header_title), style = Typography.titleLarge)
            CustomIcon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.favorite_icon_desc)
            )

        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}