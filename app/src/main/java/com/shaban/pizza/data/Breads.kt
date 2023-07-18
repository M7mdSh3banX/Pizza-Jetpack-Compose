package com.shaban.pizza.data

import com.shaban.pizza.R
import com.shaban.pizza.ui.screen.BreadUiState
import com.shaban.pizza.ui.screen.PizzaSize

val Bread1 = BreadUiState(
    bread = R.drawable.bread_1,
    price = 7.0,
    isFavorite = false,
    size = PizzaSize.MEDIUM,
    ingredients = emptyList()
)
val Bread2 = BreadUiState(
    bread = R.drawable.bread_2,
    price = 8.0,
    isFavorite = false,
    size = PizzaSize.MEDIUM,
    ingredients = emptyList()
)
val Bread3 = BreadUiState(
    bread = R.drawable.bread_3,
    price = 9.0,
    isFavorite = false,
    size = PizzaSize.MEDIUM,
    ingredients = emptyList()
)
val Bread4 = BreadUiState(
    bread = R.drawable.bread_4,
    price = 10.0,
    isFavorite = false,
    size = PizzaSize.MEDIUM,
    ingredients = emptyList()
)
val Bread5 = BreadUiState(
    bread = R.drawable.bread_5,
    price = 11.0,
    isFavorite = false,
    size = PizzaSize.MEDIUM,
    ingredients = emptyList()
)

val breads = listOf(Bread1, Bread2, Bread3, Bread4, Bread5)