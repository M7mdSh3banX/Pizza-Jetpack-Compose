package com.shaban.pizza.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Transparent
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.shaban.pizza.ui.screen.HomeScreen

@Composable
fun MainScreen() {
    val systemUiControl = rememberSystemUiController()
    systemUiControl.setStatusBarColor(color = Transparent, darkIcons = true)

    HomeScreen()
}