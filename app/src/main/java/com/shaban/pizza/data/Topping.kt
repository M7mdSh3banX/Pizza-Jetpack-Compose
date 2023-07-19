package com.shaban.pizza.data

import com.shaban.pizza.R
import com.shaban.pizza.ui.screen.ToppingUiState
import com.shaban.pizza.ui.screen.ToppingType

val Basil = ToppingUiState(
    item = R.drawable.basil,
    items = R.drawable.basils,
    type = ToppingType.BASIL
)
val Broccoli = ToppingUiState(
    item = R.drawable.broccoli,
    items = R.drawable.broccolis,
    type = ToppingType.BROCCOLI
)
val Mushroom = ToppingUiState(
    item = R.drawable.mushroom,
    items = R.drawable.mushrooms,
    type = ToppingType.MUSHROOM
)
val Onion = ToppingUiState(
    item = R.drawable.onion,
    items = R.drawable.onions,
    type = ToppingType.ONION
)
val Sausage = ToppingUiState(
    item = R.drawable.sausage,
    items = R.drawable.sausages,
    type = ToppingType.SAUSAGE
)

val toppings = listOf(Basil, Broccoli, Mushroom, Onion, Sausage)