package dev.tonycode.mpcomposed.feature.showcases.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tonycode.mpcomposed.core.designsystem.components.DsTopBar
import dev.tonycode.mpcomposed.core.designsystem.theme.DsTheme
import dev.tonycode.mpcomposed.core.platform.presentation.platformName

@Composable
internal fun ShowcasesScreen(
    onNavigateToHapticShowcase: () -> Unit,
    onNavigateToSharedTransitionShowcase: () -> Unit,
) {
    Scaffold(
        topBar = { DsTopBar(title = "CMP on $platformName") },
    ) { contentPadding ->
        Column(Modifier.padding(contentPadding).fillMaxWidth().padding(32.dp)) {
            Button(onNavigateToHapticShowcase, Modifier.fillMaxWidth()) { Text("Haptic effect") }
            Button(onNavigateToSharedTransitionShowcase, Modifier.fillMaxWidth()) { Text("Shared element transition") }
        }
    }
}

//region preview
@Preview
@Composable
private fun PreviewHomeScreen() {
    DsTheme {
        ShowcasesScreen(
            onNavigateToHapticShowcase = {},
            onNavigateToSharedTransitionShowcase = {},
        )
    }
}
//endregion
