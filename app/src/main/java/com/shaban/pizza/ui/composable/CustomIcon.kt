package com.shaban.pizza.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.shaban.pizza.ui.theme.Black

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    imageVector: ImageVector,
    contentDescription: String
) {
    IconButton(
        modifier = modifier.size(45.dp),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = Black
        )
    }
}