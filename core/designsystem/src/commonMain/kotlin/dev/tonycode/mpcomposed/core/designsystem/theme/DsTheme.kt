package dev.tonycode.mpcomposed.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun DsTheme(content: @Composable (() -> Unit)) {
    MaterialTheme(
        content = content,
    )
}
