package com.shaban.pizza.ui.composable

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shaban.pizza.ui.theme.Primary


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .height(24.dp)
            .width(120.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val lineWeight = animateFloatAsState(
                targetValue = if (pagerState.currentPage == iteration)  1.5f
                else { if (iteration < pagerState.currentPage) 0.7f  else 1f },
                label = "weight", animationSpec = tween(300, easing = EaseInOut)
            )
            val color =
                if (pagerState.currentPage == iteration) Primary else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(color)
                    .weight(lineWeight.value)
                    .height(4.dp)
            )
        }
    }
}