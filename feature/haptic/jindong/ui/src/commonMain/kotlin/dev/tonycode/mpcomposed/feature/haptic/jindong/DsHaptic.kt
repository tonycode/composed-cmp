package dev.tonycode.mpcomposed.feature.haptic.jindong

import androidx.compose.runtime.Composable
import io.github.compose.jindong.JindongScope
import io.github.compose.jindong.core.model.HapticIntensity
import io.github.compose.jindong.core.ms
import io.github.compose.jindong.dsl.Delay
import io.github.compose.jindong.dsl.Haptic
import io.github.compose.jindong.dsl.Repeat
import io.github.compose.jindong.dsl.RepeatWithIndex

private val defaultDuration = 100.ms

/**
 * Haptic/Vibration pattern sample catalog.
 *
 * Origin: https://compose-jindong.github.io/jindong/docs/guide/quick-start#practical-examples
 */
internal enum class DsHaptic(
    val pattern: @Composable JindongScope.() -> Unit,
) {
    Light(pattern = { Haptic(duration = defaultDuration, intensity = HapticIntensity.LIGHT) }),

    Medium(pattern = { Haptic(duration = defaultDuration, intensity = HapticIntensity.MEDIUM) }),

    Strong(pattern = { Haptic(duration = defaultDuration, intensity = HapticIntensity.STRONG) }),

    High(pattern = { Haptic(duration = defaultDuration, intensity = HapticIntensity.HIGH) }),

    SingleTap(pattern = {
        Haptic(50.ms)
    }),

    LongPress(pattern = {
        Haptic(200.ms, HapticIntensity.MEDIUM)
    }),

    Success(pattern = {
        Haptic(50.ms, HapticIntensity.MEDIUM)
        Delay(50.ms)
        Haptic(100.ms, HapticIntensity.STRONG)
    }),

    Error(pattern = {
        Repeat(3) {
            Haptic(80.ms, HapticIntensity.HIGH)
            Delay(50.ms)
        }
    }),

    FadeIn(pattern = {
        RepeatWithIndex(4) { index ->
            val fadeIn = HapticIntensity.Custom(0.25f + (index * 0.25f))
            Haptic(50.ms, fadeIn)
            Delay(30.ms)
        }
    }),

    FadeOut(pattern = {
        RepeatWithIndex(5) { index ->
            val intensity = HapticIntensity.Custom(1.0f - (index * 0.2f))
            Haptic(50.ms, intensity)
            Delay(30.ms)
        }
    }),

    PulseWave(pattern = {
        RepeatWithIndex(6) { index ->
            val wave =
                if (index < 3) {
                    HapticIntensity.Custom(0.3f + (index * 0.3f))
                } else {
                    HapticIntensity.Custom(0.9f - ((index - 3) * 0.3f))
                }
            Haptic(40.ms, wave)
            Delay(30.ms)
        }
    }),

    Heartbeat(pattern = {
        // Lub
        Haptic(60.ms, HapticIntensity.STRONG)
        Delay(80.ms)
        // Dub
        Haptic(40.ms, HapticIntensity.MEDIUM)
        Delay(400.ms)
        // Repeat
        Haptic(60.ms, HapticIntensity.STRONG)
        Delay(80.ms)
        Haptic(40.ms, HapticIntensity.MEDIUM)
    }),
}
