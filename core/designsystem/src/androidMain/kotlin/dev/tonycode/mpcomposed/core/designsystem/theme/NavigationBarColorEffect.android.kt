package dev.tonycode.mpcomposed.core.designsystem.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.LocalActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb

@Composable
actual fun NavigationBarColorEffect() {
    val isDark = isSystemInDarkTheme()
    val activity: ComponentActivity? = (LocalActivity.current as? ComponentActivity)

    SideEffect {
        activity?.enableEdgeToEdge(
            navigationBarStyle =
                if (isDark) {
                    SystemBarStyle.dark(DsPalette.CharcoalBlack.toArgb())
                } else {
                    SystemBarStyle.light(DsPalette.White.toArgb(), DsPalette.CharcoalBlack.toArgb())
                },
        )
    }
}
