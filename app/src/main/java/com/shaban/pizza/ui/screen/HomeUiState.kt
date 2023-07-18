package com.shaban.pizza.ui.screen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class HomeUiState(
    val breads: List<BreadUiState> = emptyList()
)

data class BreadUiState(
    val bread: Int = 0,
    val price: Double = 0.0,
    val size: PizzaSize = PizzaSize.MEDIUM,
    val ingredients: List<Int> = emptyList(),
    val isFavorite: Boolean = false,
)

enum class PizzaSize(val size: Dp, val bias: Float) {
    SMALL(200.dp, -1F),
    MEDIUM(210.dp, 0F),
    LARGE(220.dp, 1F)
}