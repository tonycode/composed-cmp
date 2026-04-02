package dev.tonycode.mpcomposed.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tonycode.mpcomposed.core.designsystem.components.DsTopBar
import dev.tonycode.mpcomposed.core.designsystem.theme.DsTheme
import dev.tonycode.mpcomposed.core.platform.presentation.platformName
import dev.tonycode.mpcomposed.feature.haptic.jindong.JindongShowcaseScreen

@Composable
fun RootContent() {
    DsTheme {
        var route: Route by remember { mutableStateOf(Route.Home) }

        Box(Modifier.fillMaxSize()) {
            when (route) {
                Route.Home -> HomeScreen(onNavigateToHapticShowcase = { route = Route.Haptic })
                Route.Haptic -> JindongShowcaseScreen(onNavigateBack = { route = Route.Home })
            }
        }
    }
}

private enum class Route {
    Home,
    Haptic,
}

@Composable
private fun HomeScreen(
    onNavigateToHapticShowcase: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { DsTopBar(title = "CMP on $platformName") },
    ) { contentPadding ->
        Column(modifier.padding(contentPadding).fillMaxWidth().padding(32.dp)) {
            Button(onNavigateToHapticShowcase, Modifier.fillMaxWidth()) { Text("Haptic effect") }
        }
    }
}

//region preview
@Preview
@Composable
private fun PreviewHomeScreen() {
    DsTheme {
        HomeScreen(
            onNavigateToHapticShowcase = {},
        )
    }
}
//endregion
