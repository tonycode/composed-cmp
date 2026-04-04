package dev.tonycode.mpcomposed.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {
    @Serializable
    data object Showcases : Route

    @Serializable
    data object HapticJindongShowcase : Route
}
