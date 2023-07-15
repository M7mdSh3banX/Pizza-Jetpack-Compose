package com.shaban.pizza.ui.screen

data class HomeUiState(
    val breads: List<BreadUiState> = emptyList()
)

data class BreadUiState(
    val bread: Int = 0,
    val price: Double = 0.0,
    val size: String = "",
    val ingredients: List<Int> = emptyList(),
    val isFavorite: Boolean = false,
)