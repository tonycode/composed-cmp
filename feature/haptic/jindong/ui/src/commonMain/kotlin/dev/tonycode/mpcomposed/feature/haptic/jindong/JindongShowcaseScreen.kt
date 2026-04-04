package dev.tonycode.mpcomposed.feature.haptic.jindong

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tonycode.mpcomposed.core.designsystem.components.DsTopBar
import dev.tonycode.mpcomposed.core.designsystem.theme.DsTheme
import io.github.compose.jindong.JindongProvider

@Composable
internal fun JindongShowcaseScreen(onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = { DsTopBar("Haptic: Jindong", onNavigateBack) },
    ) { contentPadding ->
        JindongProvider {
            ScreenContent(Modifier.padding(contentPadding))
        }
    }
}

@Composable
private fun ScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DsHaptic.entries.forEach { dsHaptic ->
            HapticButton(
                title = dsHaptic.name,
                onClick = {},
                hapticPattern = dsHaptic.pattern,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

//region preview
@Preview
@Composable
private fun PreviewScreenContent() {
    DsTheme {
        ScreenContent()
    }
}
//endregion
