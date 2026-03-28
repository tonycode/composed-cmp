package dev.tonycode.mpcomposed.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tonycode.mpcomposed.core.platform.TargetPlatform
import dev.tonycode.mpcomposed.core.platform.targetPlatform

@Composable
@Preview
fun RootContent() {
    MaterialTheme {
        Box(Modifier.fillMaxSize()) {
            val platform = when (targetPlatform) {
                TargetPlatform.Android -> "Android"
                TargetPlatform.Ios -> "iOS"
            }

            Text("CMP in $platform!", Modifier.align(Alignment.Center))
        }
    }
}
