package com.shaban.pizza.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class HomeUiState(
    val breads: List<BreadUiState> = emptyList(),
    val toppings: List<ToppingUiState> = emptyList()
)

data class BreadUiState(
    @DrawableRes val bread: Int = 0,
    val price: Double = 0.0,
    val size: PizzaSize = PizzaSize.MEDIUM,
    val ingredients: List<Int> = emptyList(),
    val isFavorite: Boolean = false,
)

data class ToppingUiState(
    @DrawableRes val item: Int = 0,
    @DrawableRes val items: List<Int> = emptyList(),
    val isSelected: Boolean = false,
    val type: ToppingType = ToppingType.BASIL
)

enum class PizzaSize(val size: Dp, val bias: Float) {
    SMALL(200.dp, -1F),
    MEDIUM(210.dp, 0F),
    LARGE(220.dp, 1F)
}

enum class ToppingType {
    BASIL,
    BROCCOLI,
    MUSHROOM,
    ONION,
    SAUSAGE
}