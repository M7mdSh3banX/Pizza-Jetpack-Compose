package com.shaban.pizza.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shaban.pizza.R
import com.shaban.pizza.ui.screen.BreadUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BreadPager(
    breads: List<BreadUiState>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) { pageIndex ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = breads[pageIndex].bread),
                contentDescription = stringResource(R.string.pizza_plate),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(180.dp)
            )
        }
    }
}