package com.shaban.pizza.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.pizza.R
import com.shaban.pizza.ui.theme.Primary
import com.shaban.pizza.ui.theme.Typography

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIcon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.arrow_back_icon_desc),
            tint = Primary
        )
        Text(text = stringResource(R.string.header_title), style = Typography.titleLarge)
        CustomIcon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = stringResource(R.string.favorite_icon_desc),
            tint = Primary
        )
    }
}