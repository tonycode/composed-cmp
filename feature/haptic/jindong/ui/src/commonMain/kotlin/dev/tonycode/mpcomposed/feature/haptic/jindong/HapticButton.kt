package dev.tonycode.mpcomposed.feature.haptic.jindong

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.github.compose.jindong.Jindong
import io.github.compose.jindong.JindongScope
import io.github.compose.jindong.core.ms
import io.github.compose.jindong.dsl.Haptic

@Composable
internal fun HapticButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    hapticPattern: (@Composable JindongScope.() -> Unit) = { Haptic(100.ms) },
) {
    var hapticTriggerCount by remember { mutableStateOf(0) }

    Jindong(hapticTriggerCount) {
        hapticPattern()
    }

    Button(
        onClick = {
            hapticTriggerCount++
            onClick()
        },
        modifier = modifier,
    ) {
        Text(title)
    }
}
