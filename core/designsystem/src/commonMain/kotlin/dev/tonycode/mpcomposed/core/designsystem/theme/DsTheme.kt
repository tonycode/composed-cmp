package dev.tonycode.mpcomposed.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun DsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        if (darkTheme) {
            darkColorScheme(
                primary = DsPalette.LavenderMist,
                background = DsPalette.CharcoalBlack, // e.g.: Scaffold bg
                surface = DsPalette.CharcoalBlack, // e.g.: TopAppBar bg
            )
        } else {
            lightColorScheme(
                primary = DsPalette.ElectricViolet,
                background = DsPalette.White, // e.g.: Scaffold bg
                surface = DsPalette.White, // e.g.: TopAppBar bg
            )
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content,
    )
}
