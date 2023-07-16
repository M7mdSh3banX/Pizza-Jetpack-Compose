package com.shaban.pizza.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaban.pizza.R
import com.shaban.pizza.ui.composable.BreadPager
import com.shaban.pizza.ui.composable.CustomIndicator
import com.shaban.pizza.ui.composable.HomeHeader
import com.shaban.pizza.ui.composable.PressIconButton
import com.shaban.pizza.ui.theme.Typography
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState
) {
    var horizontalBias by remember { mutableFloatStateOf(-1F) }
    val alignment by animateHorizontalAlignmentAsState(horizontalBias)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackground)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$${state.breads[pagerState.currentPage].price}",
            style = Typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(0.4F)
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .size(48.dp)
                    .align(alignment),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(White),
            ) { }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "S",
                    style = Typography.bodyLarge,
                    modifier = Modifier.clickable { horizontalBias = -1F }
                )
                Text(
                    text = "M",
                    style = Typography.bodyLarge,
                    modifier = Modifier.clickable { horizontalBias = 0F }
                )
                Text(
                    text = "L",
                    style = Typography.bodyLarge,
                    modifier = Modifier.clickable { horizontalBias = 1F }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1F))
        PressIconButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp),
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Icon",
                    tint = White,
                    modifier = Modifier.size(24.dp)
                )
            }
        ) {
            Text(
                text = stringResource(id = R.string.add_to_cart),
                style = Typography.labelLarge.copy(color = White),
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun animateHorizontalAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue)
    return remember { derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) } }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}