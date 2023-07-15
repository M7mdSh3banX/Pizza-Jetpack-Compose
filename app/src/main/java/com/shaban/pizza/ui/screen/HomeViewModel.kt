package com.shaban.pizza.ui.screen

import androidx.lifecycle.ViewModel
import com.shaban.pizza.data.breads
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getBreads()
    }

    private fun getBreads() {
        _state.update { it.copy(breads = breads) }
    }
}