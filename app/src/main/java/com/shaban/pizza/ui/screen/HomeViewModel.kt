package com.shaban.pizza.ui.screen

import androidx.lifecycle.ViewModel
import com.shaban.pizza.data.breads
import com.shaban.pizza.data.toppings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getBreads()
        getToppings()
    }

    private fun getBreads() {
        _state.update { it.copy(breads = breads) }
    }

    private fun getToppings() {
        _state.update { it.copy(toppings = toppings) }
    }

    fun onClickUpdatePizzaSize(size: PizzaSize) {
        _state.update { currentState ->
            val updatedBread = currentState.breads.map { bread ->
                bread.copy(size = size)
            }
            currentState.copy(breads = updatedBread)
        }
    }
}