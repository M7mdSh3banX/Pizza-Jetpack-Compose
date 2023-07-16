package com.shaban.pizza.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shaban.pizza.ui.theme.Primary

@Composable
fun PressIconButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
) {
    var isVisible by remember { mutableStateOf(false) }

    Button(
        modifier = modifier,
        onClick = { isVisible = !isVisible},
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row {
            icon()
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn() + expandHorizontally(),
                exit =  fadeOut() + shrinkHorizontally()
            ) {
                text()
            }
        }
    }
}