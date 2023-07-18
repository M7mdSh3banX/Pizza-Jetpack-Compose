package com.shaban.pizza.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shaban.pizza.R
import com.shaban.pizza.ui.theme.Primary
import com.shaban.pizza.ui.theme.Typography

@Composable
fun PressIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
) {
    var isVisible by remember { mutableStateOf(false) }

    Button(
        modifier = modifier,
        onClick = { isVisible = !isVisible},
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn() + expandHorizontally(),
                exit =  fadeOut() + shrinkHorizontally()
            ) {
                Text(
                    text = text,
                    style = Typography.labelLarge.copy(color = Color.White),
                    modifier = Modifier.padding(start = 8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}