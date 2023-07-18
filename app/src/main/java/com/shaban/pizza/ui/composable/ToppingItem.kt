package com.shaban.pizza.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shaban.pizza.ui.theme.Secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToppingItem(
    modifier: Modifier = Modifier,
    @DrawableRes itemImage: Int
) {
    Card(
        modifier = modifier.size(54.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(Secondary),
        onClick = { }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = itemImage),
                contentDescription = "Topping Item",
                contentScale = ContentScale.Fit,
            )
        }
    }
}