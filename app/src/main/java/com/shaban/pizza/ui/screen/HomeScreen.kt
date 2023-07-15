package com.shaban.pizza.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.pizza.R
import com.shaban.pizza.ui.composable.BreadPager
import com.shaban.pizza.ui.composable.CustomIndicator
import com.shaban.pizza.ui.composable.HomeHeader
import com.shaban.pizza.ui.theme.WhiteBackground

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { state.breads.size }

    HomeContent(state = state, pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackground)
    ) {
        HomeHeader()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = stringResource(R.string.pizza_plate),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(250.dp)
            )
            BreadPager(breads = state.breads, pagerState = pagerState)
            CustomIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.weight(1F))

    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}